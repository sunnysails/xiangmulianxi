package com.kaishengit.service.impl;

import com.kaishengit.pojo.Lease;
import com.kaishengit.pojo.LeaseDevice;
import com.kaishengit.service.LeaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sunny on 2017/1/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class LeaseServiceImplTest {
    @Test
    public void findLeaseById() throws Exception {
        Lease lease = leaseService.findLeaseById(1);
        System.out.println(lease);
        assertNotNull(lease);
    }

    @Autowired
    private LeaseService leaseService;

    @Test
    public void findAllLease() throws Exception {
        List<Lease> lease = leaseService.findAllLease();
        System.out.println(lease);
        assertNotNull(lease);
    }

}