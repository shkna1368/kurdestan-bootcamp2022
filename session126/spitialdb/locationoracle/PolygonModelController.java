

import io.swagger.annotations.ApiOperation;
import ir.pakcharkh.bdood.core.dto.PolygonModelDTO;
import ir.pakcharkh.bdood.core.dto.TranslateDTO;
import ir.pakcharkh.bdood.core.dto.search.PolygonModelSearchDTO;
import ir.pakcharkh.bdood.core.mapper.PolygonModelMapper;
import ir.pakcharkh.bdood.core.mapper.TranslateMapper;
import ir.pakcharkh.bdood.core.model.PolygonModel;
import ir.pakcharkh.bdood.core.model.SimpleListAndTotalCountProvider;
import ir.pakcharkh.bdood.core.service.PolygonModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/polygon_model/")
public class PolygonModelController {


    private PolygonModelService polygonModelService;
    private PolygonModelMapper polygonModelMapper;
    private TranslateMapper translateMapper;


    @Lazy
    @Autowired
    public PolygonModelController(PolygonModelService polygonModelService, PolygonModelMapper polygonModelMapper, TranslateMapper translateMapper) {
        this.polygonModelService = polygonModelService;
        this.polygonModelMapper = polygonModelMapper;
        this.translateMapper = translateMapper;
    }

    ///#########################################################################################################

    @ApiOperation(value = "Add or Insert new PolygonModel")
    @PostMapping(value = "")
    public ResponseEntity<Void> addNewPolygonModel(@RequestHeader("Accept-Language") String acceptLanguage,
                                                   @RequestBody PolygonModelDTO polygonModelDTO) {
        PolygonModel polygonModel = polygonModelMapper.toPolygonModel(polygonModelDTO);
        List<TranslateDTO> translatesDTOS = polygonModelDTO.getTranslates();
        polygonModelService.addPolygonModel(acceptLanguage, polygonModel, translateMapper.toTranslates(translatesDTOS));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    ///#########################################################################################################

    @ApiOperation(value = "Delete a Polygon Model by id")
    @DeleteMapping(value = "{polygonModelId}")
    public ResponseEntity<Void> deletePolygonModelById(@RequestHeader("Accept-Language") String acceptLanguage,
                                                       @PathVariable("polygonModelId") List<String> polygonModelId) {
        polygonModelService.deletePolygonModel(acceptLanguage, polygonModelId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    ///##########################################################################################################

    @ApiOperation(value = "Update a PolygonModel with id and new model")
    @PutMapping(value = "{polygonId}")
    public ResponseEntity<Void> updatePolygonById(@RequestHeader("Accept-Language") String acceptLanguage,
                                                  @PathVariable("polygonId") String polygonId, @Valid PolygonModelDTO polygonModelDTO) {
        PolygonModel polygonModel = polygonModelMapper.toPolygonModel(polygonModelDTO);
        List<TranslateDTO> translateDTOS = polygonModelDTO.getTranslates();
        polygonModelService.updatePolygonModel(acceptLanguage, polygonId, polygonModel, translateMapper.toTranslates(translateDTOS));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    ///##########################################################################################################


    @ApiOperation(value = "Get details of all PolygonModel")
    @GetMapping(value = "")
    public ResponseEntity<List<PolygonModelDTO>> getAllPolygonModels(@RequestHeader("Accept-Language") String acceptLanguage) {
        List<PolygonModel> polygonModels = polygonModelService.getAllActivePolygonModel(acceptLanguage);
        List<PolygonModelDTO> polygonModelDTOS = polygonModelMapper.toPolygonDTOs(polygonModels);
        return ResponseEntity.ok(polygonModelDTOS);
    }


    ///##########################################################################################################

    @ApiOperation(value = "Getting the details of a PolygonModel by id")
    @GetMapping(value = "get_details/{polygonModelId}")
    public ResponseEntity<PolygonModelDTO> getPolygonModelDetailsById(@RequestHeader("Accept-Language") String acceptLanguage,
                                                                      @PathVariable("polygonModelId") String polygonModelId) {
        PolygonModelDTO polygonModelDTO = polygonModelMapper.toPolygonDTO(polygonModelService.getPolygonModelByUuid(acceptLanguage, polygonModelId));
        return ResponseEntity.ok(polygonModelDTO);
    }


    ///#########################################################################################################

    @ApiOperation(value = "Getting city polygons by id")
    @GetMapping(value = "get_city_polygons/{cityId}")
    public ResponseEntity<List<PolygonModelDTO>> getCityPolygons(@RequestHeader("Accept-Language") String acceptLanguage,
                                                                 @PathVariable("cityId") String cityId) {
        List<PolygonModel> polygonModels = polygonModelService.getCityPolygons(acceptLanguage, cityId);
        List<PolygonModelDTO> polygonModelDTOS = polygonModelMapper.toPolygonDTOs(polygonModels);
        return ResponseEntity.ok(polygonModelDTOS);
    }

    ///##########################################################################################################

    @ApiOperation(value = "Getting area polygons by id")
    @GetMapping(value = "get_area_polygons/{areaId}")
    public ResponseEntity<List<PolygonModelDTO>> getAreaPolygons(@RequestHeader("Accept-Language") String acceptLanguage,
                                                                 @PathVariable("areaId") String areaId) {
        List<PolygonModel> polygonModels = polygonModelService.getAreaPolygons(acceptLanguage, areaId);
        List<PolygonModelDTO> polygonModelDTOS = polygonModelMapper.toPolygonDTOs(polygonModels);
        return ResponseEntity.ok(polygonModelDTOS);
    }

    ///##########################################################################################################

    @ApiOperation(value = "Search by filter")
    @PostMapping(value = "search")
    public ResponseEntity<SimpleListAndTotalCountProvider> search(@RequestHeader("Accept-Language") String acceptLanguage,
                                                                  @RequestBody PolygonModelSearchDTO polygonModelSearchDTO) {
        List<PolygonModelDTO> polygonModelDTOS = polygonModelMapper.toPolygonDTOs(polygonModelService.searchPolygonModel(acceptLanguage, polygonModelSearchDTO, false));
        return ResponseEntity.status(HttpStatus.OK).body(new SimpleListAndTotalCountProvider<>(polygonModelDTOS, polygonModelDTOS.size()));
    }

    ///##########################################################################################################


//
//    @PostMapping(value = "")
//    public ResponseEntity<Void> addPolygonModel(@RequestBody PolygonModelDTO PolygonModelDTO) {
//
//        PolygonModel PolygonModel = PolygonModelMapper.toPolygonModel(PolygonModelDTO);
//
//        // get multi language from PolygonModelDTO and set on the PolygonModel object for add to tbl
////        Set<PolygonModelTranslate> PolygonModelTranslates = new HashSet<>(PolygonModelDTO.getTranslates().size());
////        PolygonModelDTO.getTranslates().forEach(translateDTO -> {
////            UUID languageId = translateDTO.getLanguageId();
////
////            Language language = languagesService.getLanguageByUuid(languageId);
////
////            PolygonModelTranslate PolygonModelTranslate = new PolygonModelTranslate();
////            PolygonModelTranslate.setLanguage(language);
////            PolygonModelTranslate.setTitle(translateDTO.getLanguageTitle());
////            PolygonModelTranslate.setPolygonModel(PolygonModel);
////            PolygonModelTranslates.add(PolygonModelTranslate);
////
////        });
////        PolygonModel.setTranslates(PolygonModelTranslates);
//
//        PolygonModelService.addPolygonModel(PolygonModel);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    ///#########################################################################################################
//
//    @GetMapping(value = "")
//    public ResponseEntity<List<PolygonModelDTO>> getAllPolygonModels() {
//        List<PolygonModel> PolygonModels = PolygonModelService.getAllActivePolygonModel();
//        List<PolygonModelDTO> PolygonModelDTOS = PolygonModelMapper.toPolygonModelDTOs(PolygonModels);
//        return ResponseEntity.ok(PolygonModelDTOS);
//    }
//
//
//    ///#########################################################################################################
//
//    @DeleteMapping(value = "{PolygonModelId}")
//    public ResponseEntity<Void> deletePolygonModel(@PathVariable(required = true) @NotBlank String PolygonModelId) {
//        PolygonModelService.deletePolygonModel(PolygonModelId);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//
//    ///##########################################################################################################
//
//
//    @PutMapping(value = "{PolygonModelId}")
//    public ResponseEntity<Void> updatePolygonModel(@PathVariable(required = true) @NotBlank String PolygonModelId, @RequestBody PolygonModelDTO PolygonModelDTO) {
//        PolygonModelService.updatePolygonModel(PolygonModelId, PolygonModelMapper.toPolygonModel(PolygonModelDTO));
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//


    /////////////////////////////
    /////////////////////////////
    /////////////////////////////
    /////////////////////////////


}
