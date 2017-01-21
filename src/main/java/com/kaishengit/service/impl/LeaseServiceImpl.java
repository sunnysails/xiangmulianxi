package com.kaishengit.service.impl;

import com.kaishengit.mapper.DeviceMapper;
import com.kaishengit.mapper.LeaseDeviceMapper;
import com.kaishengit.mapper.LeaseMapper;
import com.kaishengit.pojo.Device;
import com.kaishengit.pojo.Lease;
import com.kaishengit.pojo.LeaseDevice;
import com.kaishengit.service.LeaseService;
import com.kaishengit.util.DateUtil;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by sunny on 2017/1/17.
 */
@Service
public class LeaseServiceImpl implements LeaseService {
    @Autowired
    private LeaseMapper leaseMapper;
    @Autowired
    private LeaseDeviceMapper leaseDeviceMapper;
    @Autowired
    private DeviceMapper deviceMapper;

    /**
     * 获取当前时间到天
     *
     * @return YYYY-MM-DD
     */
    private Timestamp getNowDay() {
        return new Timestamp(new DateTime().getDayOfYear());
    }

    @Override
    public List<Lease> findAllLease() {
        return leaseMapper.findAll();
    }

    @Override
    public Lease findLeaseById(Integer leaseId) {
        return leaseMapper.findById(leaseId);
    }

    @Override
    @Transactional
    public void saveNewLease(Lease lease, Integer[] deviceIds, String[] backs, Integer[] leaseNums) {
        Integer newAccount = leaseMapper.findMaxAccount() + 1;
        lease.setLeaseAccount(newAccount);
        leaseMapper.saveNew(lease);

        LeaseDevice leaseDevice = new LeaseDevice();
        Device device = new Device();

        leaseDevice.setLeaseId(lease.getId());
        for (int i = 0; i < deviceIds.length; i++) {
            //获取device对象
            device = deviceMapper.findById(deviceIds[i]);
            //存储leaseDevice对象
            leaseDevice.setDeviceId(deviceIds[i]);
            leaseDevice.setBackTime(Timestamp.valueOf(DateUtil.getWantDate(backs[i],DateUtil.PATTERN_STANDARD19H)));
//TODO 因spring获取时间问题，该功能暂有BUG存在。不能实用 ，后期修复！！！！
            leaseDevice.setLeaseNum(leaseNums[i]);
            leaseDevice.setCreatePrice(device.getDeviceUnitPrice());
//            int days = Days.daysBetween(DateUtil.getWantDate(getNowDay().toString(),DateUtil.PATTERN_STANDARD10H), DateUtil.string2Date(backs[i],DateUtil.PATTERN_STANDARD10H)).getDays();
//            leaseDevice.setAmount(device.getDeviceUnitPrice()*leaseNums[i]*(backs[i]-getNowDay()));
            leaseDeviceMapper.saveNewLeDe(leaseDevice);
//更新device 数量
            device.setDeviceNowNum(device.getDeviceNowNum() - leaseNums[i]);
            deviceMapper.update(device);
        }
    }
}
