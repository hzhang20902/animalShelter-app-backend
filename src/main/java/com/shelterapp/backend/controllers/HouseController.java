package com.shelterapp.backend.controllers;

import com.shelterapp.backend.dto.HouseDto;
import com.shelterapp.backend.entity.Housekeeping;
import com.shelterapp.backend.repository.HouseRepository;
import com.shelterapp.backend.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/housekeeping")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HouseController {

    //JSON packet key string must match exactly with column name, case and syntax
    //if not posting booleans, GET request to see the formatting of the column names
    //copy and paste from the ResponseBody, the exact column name

    @Autowired
    private HouseService houseService;

    @Autowired
    private HouseRepository houseRepository;


    @PostMapping
    public ResponseEntity createHousekept(@RequestBody HouseDto houseDto) {
        return houseService.saveHouseData(houseDto);

    }

    @GetMapping
    public ResponseEntity<List<Housekeeping>> getAllHousekept(){
        return houseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Housekeeping> getHousekeptByHouseId(@PathVariable UUID id){
        return houseService.findByHouseId(id);
    }

    @GetMapping("/volunteerId/{id}")
    public ResponseEntity<List<Housekeeping>> getHouseKeptByVolunteerId(@PathVariable UUID id){
        return houseService.findByVolunteerId(id);
    }

//    private Housekeeping convertToEntity(HouseDto houseDto) throws ParseException{
//        ModelMapper modelMapper = new ModelMapper();
//        Housekeeping houseTask = modelMapper.map(houseDto, Housekeeping.class);
//
//        if (houseDto.getVolunteerId() != null){
//            Housekeeping housekeeping = houseService.findByVolunteerId(houseDto.getVolunteerId());
//            houseTask.setHCleanGroomRoom(
//                    housekeeping.isHCleanGroomRoom());
//            houseTask.setHEmptyWashKongs(
//                    housekeeping.isHEmptyWashKongs());
//            houseTask.setHOrganizeVolArea(
//                    housekeeping.isHOrganizeVolArea());
//            houseTask.setHLaundry(
//                    housekeeping.isHLaundry());
//            houseTask.setHGroundskeeping(
//                    housekeeping.isHGroundskeeping());
//        }
//        return houseTask;
//    };

}
