package com.kaishengit.controller;

import com.kaishengit.pojo.Device;
import com.kaishengit.pojo.Lease;
import com.kaishengit.service.DeviceService;
import com.kaishengit.service.LeaseService;
import com.kaishengit.util.DateUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sunny on 2017/1/17.
 */
@Controller
@RequestMapping("/business/lease")
public class LeaseController {
    @Autowired
    private LeaseService leaseService;
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(method = RequestMethod.GET)
    public String leaseList(Model model) {
        List<Lease> leaseList = leaseService.findAllLease();
        model.addAttribute("leaseList", leaseList);
        return "/business/lease/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newLease(Model model) {
        List<Device> deviceList = deviceService.findAllDevice();
        model.addAttribute("deviceList", deviceList);
        return "/business/lease/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newLease(Lease lease, Integer[] deviceIds, String[] backs, Integer[] leaseNums, RedirectAttributes redirectAttributes) {
        leaseService.saveNewLease(lease, deviceIds, backs, leaseNums);
        redirectAttributes.addFlashAttribute("message", "添加新租赁关系");
        return "redirect:/business/lease";
    }
}
