package com.example.intelligentscheduling.controller;

import com.example.intelligentscheduling.entity.Employee;
import com.example.intelligentscheduling.entity.Store;
import com.example.intelligentscheduling.service.EmployeeService;
import com.example.intelligentscheduling.service.StoreService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/StoreController")
@CrossOrigin
public class StoreController {
    @Resource(name = "StoreService")
    StoreService service;
    @ResponseBody
    @RequestMapping("/storeSelect")
    public Store StoreSelect(@RequestParam("storesId") String storesId){
        return service.StoreSelect(storesId);
    }

    @ResponseBody
    @RequestMapping("/updateStore")
    public void UpdateStore(@RequestParam("storesId") String storesId,
                            @RequestParam("storesName") String storesName,
                            @RequestParam("storesAddress") String storesAddress,
                            @RequestParam("storesSize") String storesSize){
        service.UpdateStore(storesId,storesName,storesAddress,storesSize);
    }
}
