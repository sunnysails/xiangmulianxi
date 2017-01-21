package com.kaishengit.controller;

import com.kaishengit.pojo.Lease;
import com.kaishengit.pojo.Outsource;
import com.kaishengit.pojo.Worker;
import com.kaishengit.service.OutsourceService;
import com.kaishengit.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by sunny on 2017/1/21.
 */
@Controller
@RequestMapping("/business/outsource")
public class OutsourceController {
    @Autowired
    private OutsourceService outsourceService;
    @Autowired
    private WorkerService workerService;

    @RequestMapping(method = RequestMethod.GET)
    public String outList(Model model) {
        List<Outsource> outsourceList = outsourceService.findAllLease();
        model.addAttribute("outsourceList", outsourceList);
        return "/business/outsource/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newOut(Model model) {
        List<Worker> workerList = workerService.findAllWorker();
        model.addAttribute("workerList", workerList);
        return "/business/outsource/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newOut(Outsource outsource, Integer[] workerIds, Integer[] workerNums, RedirectAttributes redirectAttributes) {
        Integer newAccount = outsourceService.saveNewOutWorker(outsource,workerIds,workerNums);
        redirectAttributes.addFlashAttribute("message", "添加新外包项目成功");
        return "redirect:/business/outsource";
    }
}
