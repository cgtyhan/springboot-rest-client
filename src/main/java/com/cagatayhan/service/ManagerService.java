package com.cagatayhan.service;

import com.cagatayhan.model.Manager;

/*
 * Created by Çağatay Han on 21.10.2016.
 */
public interface ManagerService {
    Manager[] getAllManagers();
    Manager getManagerById(int id);
    Manager addManager(Manager manager);
}
