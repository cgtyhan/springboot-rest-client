package com.cagatayhan.service.Impl;

import com.cagatayhan.model.Worker;
import com.cagatayhan.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Çağatay Han on 21.10.2016.
 */
@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Worker[] getAllWorkers() {
        final String url = "http://localhost:8000/workers/all";
        Worker[] workers = restTemplate.getForObject(url, Worker[].class);
        return workers;
    }

    @Override
    public Worker getWorkerById(int id) {
        final String url = "http://localhost:8000/workers/" + id;
        Worker worker = restTemplate.getForObject(url, Worker.class);
        return worker;
    }

    @Override
    public Worker addWorker(Worker worker) {
        final String url = "http://localhost:8000/workers/add";
        restTemplate.postForObject(url, worker, Worker.class);
        return worker;
    }

    @Override
    public void deleteWorker(int id) {
        final String url = "http://localhost:8000/workers/delete/" + id;
        restTemplate.delete(url, Worker.class);
    }
}
