package com.kaishengit.service;

import com.kaishengit.pojo.Outsource;

import java.util.List;

/**
 * Created by sunny on 2017/1/21.
 */
public interface OutsourceService {
    List<Outsource> findAllLease();

    Integer saveNewOutWorker(Outsource outsource, Integer[] workerIds, Integer[] workerNums);
}
