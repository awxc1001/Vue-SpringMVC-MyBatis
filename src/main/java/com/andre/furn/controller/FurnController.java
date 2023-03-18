package com.andre.furn.controller;

import com.andre.furn.bean.Furn;
import com.andre.furn.bean.Msg;
import com.andre.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Andre Wang
 * @version 1.0
 */
@Controller
public class FurnController {

    @Resource
    private FurnService furnService;

    @PostMapping("/save")
    @ResponseBody
    public Msg save(@RequestBody Furn furn) {
        System.out.println("saving Furniture info...");
        furnService.save(furn);
        return Msg.success();
    }

    @RequestMapping("/list")
    @ResponseBody
    public Msg listFruns(){
        List<Furn> furnList = furnService.findAll();
        return Msg.success().add("furnList", furnList);
    }

    @PutMapping("/update")
    @ResponseBody
    public Msg update(@RequestBody  Furn furn ){
        furnService.update(furn);
        return Msg.success();
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public Msg del(@PathVariable Integer id){
        furnService.del(id);
        return Msg.success();
    }
}
