package com.kurdestanbootcamp.postgis.controller;


import com.kurdestanbootcamp.postgis.Advertise;
import com.kurdestanbootcamp.postgis.AdvertiseRepository;
import com.kurdestanbootcamp.postgis.dto.AdvertiseDTO;
import com.kurdestanbootcamp.postgis.mapper.AdvertiseMapper;

import io.swagger.annotations.ApiOperation;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/advertise/")
public class AdvertiseController {

    @Autowired
    AdvertiseRepository advertiseRepository;

    @Autowired
    AdvertiseMapper advertiseMapper;


    @ApiOperation("Save or update assetDTO")
    @PostMapping()
    public ResponseEntity save(@RequestBody AdvertiseDTO advertiseDTO) {
        Advertise advertise = advertiseMapper.toAddvertise(advertiseDTO);
    Advertise advertise1=   advertiseRepository.save(advertise);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<AdvertiseDTO>> getAll() {



        List<Advertise> all = (List<Advertise>) advertiseRepository.findAll();
        List<AdvertiseDTO> assetDTOS = advertiseMapper.toAdvertiseDTOs(all);
        return ResponseEntity.ok(assetDTOS);
    }


    @GetMapping(value = "findNearest/{lat}/{lng}/{distance}")
    public ResponseEntity<List<AdvertiseDTO>> getAassetFile(@PathVariable("lat") double lat,@PathVariable("lng") double lng,@PathVariable("distance") int distance) {
        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(lng, lat), CoordinateReferenceSystems.WGS84);

        List<Advertise> all = advertiseRepository.findAllWithDistance3(candidPoint,distance);
        List<AdvertiseDTO> assetDTOS = advertiseMapper.toAdvertiseDTOs(all);
        return ResponseEntity.ok(assetDTOS);
    }





}
