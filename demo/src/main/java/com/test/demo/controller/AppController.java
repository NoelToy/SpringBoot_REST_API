package com.test.demo.controller;

import com.test.demo.model.City;
import com.test.demo.service.AppMetaService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;

@RestController
public class AppController {

    @Autowired
    private AppMetaService appMetaObj;
    @CrossOrigin
    @RequestMapping(value = "/getCityList",method = RequestMethod.GET)
    public HashMap<Integer,City> getCustomerList() throws Exception
    {
        //JSONObject jsonOb = new JSONObject(body);
        HashMap<Integer, City> appMetadata = appMetaObj.getCityList();
        return appMetadata;
    }

    @RequestMapping(value = "/setCity",method = RequestMethod.GET)
    public String setCity(@RequestParam(value = "parameters") String body) throws Exception
    {
        //JSONObject jsonOb = new JSONObject(body);
        appMetaObj.insertCity(body);
        return "City Inserted "+ body;
    }

}
