package com.cagatayhan.controller;

import com.cagatayhan.model.Worker;
import com.cagatayhan.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Çağatay Han on 21.10.2016.
 */
@Controller
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @RequestMapping("workers")
    public String workers(ModelMap modelMap) {
        modelMap.addAttribute("workers", workerService.getAllWorkers());

        return "workers";
    }

    @RequestMapping("workers/{id}")
    public String getWorkerById(ModelMap modelMap, @PathVariable("id") int id) {
        modelMap.addAttribute("worker", workerService.getWorkerById(id));

        return "worker";
    }

    @RequestMapping(value = "/workers", method = RequestMethod.POST)
    public String addWorker(@RequestParam String name,
                            @RequestParam String address,
                            @RequestParam int feePerHour,
                            @RequestParam int hourPerDay,
                            Worker worker) {
        worker.setName(name);
        worker.setAddress(address);
        worker.setFeePerHour(feePerHour);
        worker.setHourPerDay(hourPerDay);
        workerService.addWorker(worker);

        return "redirect:/workers";
    }
}
