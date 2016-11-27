package com.cagatayhan.service.Impl;

import com.cagatayhan.model.Manager;
import com.cagatayhan.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * Created by Çağatay Han on 21.10.2016.
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    private final String url = "http://localhost:8000/managers";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Manager[] getAllManagers() {
        return restTemplate.getForObject(url + "/all", Manager[].class);
    }

    @Override
    public Manager getManagerById(int id) {
        return restTemplate.getForObject(url + "/" + id, Manager.class);
    }

    @Override
    public Manager addManager(Manager manager) {
        restTemplate.postForObject(url + "/add", manager, Manager.class);
        return manager;
    }
}
