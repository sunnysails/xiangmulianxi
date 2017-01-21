package com.kaishengit.service;

import com.kaishengit.pojo.Lease;
import com.kaishengit.pojo.LeaseDevice;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by sunny on 2017/1/17.
 */
public interface LeaseService {
    List<Lease> findAllLease();

    Lease findLeaseById(Integer leaseId);

    void saveNewLease(Lease lease, Integer[] deviceIds, String[] backs, Integer[] leaseNums);
}
