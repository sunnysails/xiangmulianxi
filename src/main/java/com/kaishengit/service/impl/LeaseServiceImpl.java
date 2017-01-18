package com.kaishengit.service.impl;

import com.kaishengit.mapper.LeaseMapper;
import com.kaishengit.pojo.Lease;
import com.kaishengit.pojo.LeaseDevice;
import com.kaishengit.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sunny on 2017/1/17.
 */
@Service
public class LeaseServiceImpl implements LeaseService {
    @Autowired
    private LeaseMapper leaseMapper;

    @Override
    public List<Lease> findAllLease() {
        return leaseMapper.findAll();
    }

    @Override
    public Lease findLeaseById(Integer leaseId) {
        return leaseMapper.findById(leaseId);
    }
}
