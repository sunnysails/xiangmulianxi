package com.kaishengit.mapper;

import com.kaishengit.pojo.Lease;
import com.kaishengit.pojo.LeaseDevice;

import java.util.List;

/**
 * Created by sunny on 2017/1/17.
 */
public interface LeaseMapper {

    List<Lease> findAll();

    Lease findById(Integer leaseId);

    void saveNew(Lease lease);

    int findMaxAccount();

    void update(Lease lease);
}
