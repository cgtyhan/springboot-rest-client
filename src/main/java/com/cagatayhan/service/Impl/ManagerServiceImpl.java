package com.cagatayhan.service.Impl;

import com.cagatayhan.model.Manager;
import com.cagatayhan.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Çağatay Han on 21.10.2016.
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Manager[] getAllManagers() {
        final String url = "http://localhost:8000/managers/all";
        Manager[] managers = restTemplate.getForObject(url, Manager[].class);
        return managers;
    }

    @Override
    public Manager getManagerById(int id) {
        final String url = "http://localhost:8000/managers/" + id;
        Manager manager = restTemplate.getForObject(url, Manager.class);
        return manager;
    }

    @Override
    public Manager addManager(Manager manager) {
        final String url = "http://localhost:8000/managers/add";
        restTemplate.postForObject(url, manager, Manager.class);
        return manager;
    }
}
