


import com.querydsl.core.BooleanBuilder;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PolygonServiceImpl implements PolygonModelService {


    private PolygonModelRepository polygonModelRepository;
    private CityService cityService;
    private AreaService areaService;
    private LanguageService languageService;
    private TranslatesService translatesService;


    @Autowired
    @Lazy
    public PolygonServiceImpl(PolygonModelRepository polygonModelRepository, CityService cityService,
                              AreaService areaService, LanguageService languageService, TranslatesService translatesService) {
        this.polygonModelRepository = polygonModelRepository;
        this.cityService = cityService;
        this.areaService = areaService;
        this.languageService = languageService;
        this.translatesService = translatesService;
    }


    @Override
    public PolygonModel addPolygonModel(String acceptLanguage, PolygonModel polygonModel, List<Translate> translates) {

        Optional<PolygonModel> optionalPolygonModel = polygonModelRepository.findByTitleAndIsDeletedIsFalse(polygonModel.getTitle());
        if (optionalPolygonModel.isPresent()) {
            throw new ConflictException(StringResource.conflict_error);
        }

        City city = cityService.getCityByUuid(acceptLanguage, String.valueOf(polygonModel.getCityId()));
        polygonModel.setCity(city);


        Area area = areaService.getAreaByUuid(acceptLanguage, String.valueOf(polygonModel.getAreaId()));
        polygonModel.setArea(area);


        try {
            PolygonModel addedPolygon = polygonModelRepository.save(polygonModel);
            List<Translate> translateList = new ArrayList<>(translates.size());
            translates.forEach(translate -> {
                UUID languageId = translate.getLanguageId();
                Language language = languageService.getLanguageByUuid(acceptLanguage, languageId);
                Translate translateObj = new Translate();
                translateObj.setTranslateTypeEnum(TranslateTypeEnum.PROVINCE);
                translateObj.setLanguage(language);
                translateObj.setTitle(translate.getTitle());
                translateObj.setReferenceId(addedPolygon.getUuid());
                translateList.add(translateObj);
            });
            translatesService.addTranslates(acceptLanguage, translateList);
            return addedPolygon;
        } catch (Exception e) {
            throw new SqlException(StringResource.adding_error);
        }

    }


    @Override
    public void deletePolygonModel(String acceptLanguage, List<String> ids) {


        ids.forEach(id -> {
            UUID uuid = Utils.strToUuid(id);
            Optional<PolygonModel> optionalPolygonModel = polygonModelRepository.findByUuidAndIsDeletedIsFalse(uuid);
            if (!optionalPolygonModel.isPresent()) {
                throw new SqlException(StringResource.not_found_error_FA);
            }
            PolygonModel polygonModel = optionalPolygonModel.get();
            polygonModel.setIsDeleted(true);

            try {
                polygonModelRepository.save(polygonModel);
            } catch (Exception e) {
                throw new SqlException(StringResource.deleting_error);
            }
        });


    }


    @Override
    public PolygonModel updatePolygonModel(String acceptLanguage, String polygonId, PolygonModel polygonModel, List<Translate> translates) {

        UUID uuid = Utils.strToUuid(polygonId);
        Optional<PolygonModel> optionalPolygonModel = polygonModelRepository.findByUuidAndIsDeletedIsFalse(uuid);

        if (!optionalPolygonModel.isPresent()) {
            throw new NotFoundException(StringResource.not_found_error_FA);
        }

        PolygonModel temp = optionalPolygonModel.get();
        temp.setTitle(polygonModel.getTitle());
        temp.setPolygonEnum(polygonModel.getPolygonEnum());


        City city = cityService.getCityByUuid(acceptLanguage, String.valueOf(polygonModel.getCityId()));
        temp.setCity(city);


        Area area = areaService.getAreaByUuid(acceptLanguage, String.valueOf(polygonModel.getAreaId()));
        temp.setArea(area);


        ////


        try {

            List<Translate> translateList = new ArrayList<>(translates.size());
            translates.forEach(translate -> {
                String translateId = String.valueOf(translate.getTranslateId());
                Translate obj = translatesService.getTranslateByUuid(acceptLanguage, translateId);
                obj.setTitle(translate.getTitle());
                translateList.add(obj);
            });

            translatesService.addTranslates(acceptLanguage, translateList);
            temp.setTranslates(translateList);
            temp.setPolygon(polygonModel.getPolygon());


            return polygonModelRepository.save(temp);
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException(StringResource.error_conflict_data);
        } catch (Exception e) {
            throw new SqlException(StringResource.error_while_updating_FA);
        }


    }

    @Override
    public PolygonModel getPolygonModelByUuid(String acceptLanguage, String polygonId) {

        UUID uuid = Utils.strToUuid(polygonId);
        try {
            PolygonModel polygonModel = polygonModelRepository.findByUuidAndIsDeletedIsFalse(uuid).get();
            List<Translate> translates = translatesService.getAllTranslatesByRefId(acceptLanguage, polygonId);
            polygonModel.setTranslates(translates);
            return polygonModel;
        } catch (Exception e) {
            throw new SqlException(StringResource.geting_data_error);
        }

    }


//    @Override
//    public List<PolygonModel> searchPolygonModelByTitle(String polygonTitle) {
//
//        List<PolygonModel> polygonModels = new ArrayList<>();
//
//        List<Translate> translateList = translatesService.searchTranslateByTitle(polygonTitle);
//        for (Translate translate : translateList) {
//            polygonModels = polygonModelRepository.findAllByUuidAndIsDeletedIsFalse(translate.getReferenceId());
//        }
//
//        List<PolygonModel> temp = new ArrayList<>(polygonModels.size());
//        polygonModels.forEach(polygon -> {
//            UUID polygonId = polygon.getUuid();
//            List<Translate> translates = translatesService.getAllTranslatesByRefId(String.valueOf(polygonId));
//            polygon.setTranslates(translates);
//            temp.add(polygon);
//        });
//
//        try {
//            return temp;
//        } catch (Exception e) {
//            throw new SqlException(StringResource.geting_data_error);
//        }
//
//
//    }


    @Override
    public List<PolygonModel> getAllActivePolygonModel(String acceptLanguage) {

        try {
            List<PolygonModel> polygonModels = polygonModelRepository.findAllByIsDeletedIsFalse();
            List<PolygonModel> temp = new ArrayList<>(polygonModels.size());
            polygonModels.forEach(polygon -> {
                UUID polygonId = polygon.getUuid();
                List<Translate> translates = translatesService.getAllTranslatesByRefId(acceptLanguage, String.valueOf(polygonId));
                polygon.setTranslates(translates);
                temp.add(polygon);
            });
            return temp;
        } catch (Exception e) {
            throw new SqlException(StringResource.geting_data_error);
        }

    }


    @Override
    public List<PolygonModel> getCityPolygons(String acceptLanguage, String cityId) {

        City city = cityService.getCityByUuid(acceptLanguage, cityId);

        try {
            List<PolygonModel> polygonModels = polygonModelRepository.findAllByCityAndIsDeletedIsFalse(city);
            List<PolygonModel> temp = new ArrayList<>(polygonModels.size());
            polygonModels.forEach(polygon -> {
                UUID polygonId = polygon.getUuid();
                List<Translate> translates = translatesService.getAllTranslatesByRefId(acceptLanguage, String.valueOf(polygonId));
                polygon.setTranslates(translates);
                temp.add(polygon);
            });
            return temp;
        } catch (Exception e) {
            throw new SqlException(StringResource.geting_data_error);
        }


    }

    @Override
    public List<PolygonModel> getAreaPolygons(String acceptLanguage, String areaId) {

        Area area = areaService.getAreaByUuid(acceptLanguage, areaId);
        try {
            List<PolygonModel> polygonModels = polygonModelRepository.findAllByAreaAndIsDeletedIsFalse(area);
            List<PolygonModel> temp = new ArrayList<>(polygonModels.size());
            polygonModels.forEach(polygon -> {
                UUID polygonId = polygon.getUuid();
                List<Translate> translates = translatesService.getAllTranslatesByRefId(acceptLanguage, String.valueOf(polygonId));
                polygon.setTranslates(translates);
                temp.add(polygon);
            });
            return temp;
        } catch (Exception e) {
            throw new SqlException(StringResource.geting_data_error);
        }
    }


    @Override
    public List<PolygonModel> searchPolygonModel(String acceptLanguage, PolygonModelSearchDTO polygonModelSearchDTO, Boolean isDeleted) {


        QPolygonModel qPolygonModel = QPolygonModel.polygonModel;
        BooleanBuilder builder = new BooleanBuilder();

        if (isDeleted == false) {
            builder.and(qPolygonModel.isDeleted.eq(false));
        }

        if (!StringUtils.isBlank(polygonModelSearchDTO.getTitle())) {
            builder.and(qPolygonModel.title.containsIgnoreCase(polygonModelSearchDTO.getTitle()));
        }


        Pageable pageable = PageRequest.of(
                polygonModelSearchDTO.getPageNumber(),
                polygonModelSearchDTO.getPageSize(),
                polygonModelSearchDTO.getSortedBy(),
                polygonModelSearchDTO.getOrderedBy());


        List<PolygonModel> tempList = polygonModelRepository.findAll(builder.getValue(), pageable).getContent();

        List<PolygonModel> list = new ArrayList<>(tempList.size());

        tempList.forEach(item -> {
            UUID id = item.getUuid();
            List<Translate> translates = translatesService.getAllTranslatesByRefId(acceptLanguage, String.valueOf(id));
            item.setTranslates(translates);
            list.add(item);
        });

        return list;

    }


}
