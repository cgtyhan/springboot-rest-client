package com.cagatayhan.service.Impl;

import com.cagatayhan.model.Worker;
import com.cagatayhan.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * Created by Çağatay Han on 21.10.2016.
 */
@Service
public class WorkerServiceImpl implements WorkerService {
    private final String url = "http://localhost:8000/workers";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Worker[] getAllWorkers() {
        return restTemplate.getForObject(url + "/all", Worker[].class);
    }

    @Override
    public Worker getWorkerById(int id) {
        return restTemplate.getForObject(url + "/" + id, Worker.class);
    }

    @Override
    public Worker addWorker(Worker worker) {
        restTemplate.postForObject(url + "/add", worker, Worker.class);
        return worker;
    }

    @Override
    public void deleteWorker(int id) {
        restTemplate.delete(url + "/delete/" + id, Worker.class);
    }
}
