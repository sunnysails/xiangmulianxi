package com.kaishengit.service;

import com.kaishengit.pojo.Device;

import java.util.List;

/**
 * Created by sunny on 2017/1/16.
 */
public interface DeviceService {
    List<Device> findAllDevice();

    Integer saveNewDevice(Device device);

    Device findDeviceById(Integer deviceId);

    void updateDevice(Device device);

    void delDeviceById(Integer deviceId);
}
