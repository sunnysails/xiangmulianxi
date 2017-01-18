package com.kaishengit.controller;

import com.kaishengit.pojo.Lease;
import com.kaishengit.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by sunny on 2017/1/17.
 */
@Controller
@RequestMapping("/business/lease")
public class LeaseController {
    @Autowired
    private LeaseService leaseService;

    @RequestMapping(method = RequestMethod.GET)
    public String leaseList(Model model) {
        List<Lease> leaseList = leaseService.findAllLease();
        model.addAttribute("leaseList",leaseList);
        return "/business/lease/list";
    }
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newLease(){
        return "/business/lease/new";
    }
}
