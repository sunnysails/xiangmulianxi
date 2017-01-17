package com.kaishengit.service.impl;

import com.kaishengit.mapper.DeviceMapper;
import com.kaishengit.pojo.Device;
import com.kaishengit.service.DeviceService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by sunny on 2017/1/16.
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    /**
     * 获取当前时间到秒
     *
     * @return YYYY-MM-DD HH:MM:SS
     */
    private Timestamp getNowTime() {
        return new Timestamp(new DateTime().getMillis());
    }

    @Override
    public List<Device> findAllDevice() {
        return deviceMapper.findAll();
    }

    @Override
    @Transactional
    public Integer saveNewDevice(Device device) {
        Integer newAccount = deviceMapper.findMaxAccount() + 1;
        device.setDeviceAccount(newAccount);
        device.setDeviceNowNum(device.getDeviceAllNum());
        device.setUpdateTime(getNowTime());
        deviceMapper.save(device);
        return newAccount;
    }

    @Override
    public Device findDeviceById(Integer deviceId) {
        return deviceMapper.findById(deviceId);
    }

    @Override
    @Transactional
    public void updateDevice(Device device) {
        device.setUpdateTime(getNowTime());
        deviceMapper.update(device);
    }

    @Override
    public void delDeviceById(Integer deviceId) {
        deviceMapper.delById(deviceId);
        //TODO 外键约束关系添加后需更改。
    }
}
