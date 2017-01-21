package com.kaishengit.service.impl;

import com.kaishengit.mapper.LeaseWorkerMapper;
import com.kaishengit.mapper.OutsourceMapper;
import com.kaishengit.mapper.WorkerMapper;
import com.kaishengit.pojo.LeaseWorker;
import com.kaishengit.pojo.Outsource;
import com.kaishengit.pojo.Worker;
import com.kaishengit.service.OutsourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sunny on 2017/1/21.
 */
@Service
public class OutsourceServiceImpl implements OutsourceService {
    @Autowired
    private OutsourceMapper outsourceMapper;
    @Autowired
    private LeaseWorkerMapper leaseWorkerMapper;
    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public List<Outsource> findAllLease() {
        return outsourceMapper.findAll();
    }

    @Override
    @Transactional
    public Integer saveNewOutWorker(Outsource outsource, Integer[] workerIds, Integer[] workerNums) {
        Integer newAccount = outsourceMapper.findMaxAccount() + 1;

        outsource.setOutAccount(newAccount);
        outsourceMapper.saveNew(outsource);

        LeaseWorker leaseWorker = new LeaseWorker();
        Worker worker = new Worker();

        for (int i = 0; i < workerIds.length; i++) {
            worker = workerMapper.findById(workerIds[i]);

            leaseWorker.setOutId(outsource.getId());
            leaseWorker.setWorkerId(workerIds[i]);
            leaseWorker.setOutNum(workerNums[i]);
            leaseWorker.setWorkerCreatePrice(worker.getWorkerUnitPrice());
            leaseWorkerMapper.saveNew(leaseWorker);

            worker.setWorkerNowNum(worker.getWorkerNowNum() - workerNums[i]);
            workerMapper.update(worker);
        }
        return newAccount;
    }
}
