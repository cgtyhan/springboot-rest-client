package com.cagatayhan.service;

import com.cagatayhan.model.Worker;

/*
 * Created by Çağatay Han on 21.10.2016.
 */
public interface WorkerService {
    Worker[] getAllWorkers();
    Worker getWorkerById(int id);
    Worker addWorker(Worker worker);
}
