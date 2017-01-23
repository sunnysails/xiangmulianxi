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
        Float a = Float.valueOf(0);
        for (int i = 0; i < deviceIds.length; i++) {
            //获取device对象
            device = deviceMapper.findById(deviceIds[i]);
            //存储leaseDevice对象
            leaseDevice.setDeviceId(deviceIds[i]);
            leaseDevice.setBackTime(Timestamp.valueOf(DateUtil.getWantDate(backs[i], DateUtil.PATTERN_STANDARD19H)));
            leaseDevice.setLeaseNum(leaseNums[i]);
            leaseDevice.setCreatePrice(device.getDeviceUnitPrice());

            Integer day = DateUtil.getDiff(DateUtil.getCurrentTime(DateUtil.PATTERN_STANDARD10H), backs[i]);
            if (day >= 0) {
                Float amount = device.getDeviceUnitPrice() * leaseNums[i] * day;
                leaseDeviceMapper.saveNewLeDe(leaseDevice);
                a = a + amount;
            } else {
                throw new RuntimeException("时间错误");
            }
            //更新device 数量
            device.setDeviceNowNum(device.getDeviceNowNum() - leaseNums[i]);
            deviceMapper.update(device);
        }
        lease.setLeaseAmount(a);
        lease.setLeasePrepaid(a * 20 / 100);
        lease.setLeaseUnpaid(a * 80 / 100);
        leaseMapper.update(lease);
    }
}
