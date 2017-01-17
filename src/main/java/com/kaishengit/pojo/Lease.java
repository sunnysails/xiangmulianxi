package com.kaishengit.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sunny on 2017/1/17.
 */
@Data
public class Lease implements Serializable {
    private Integer id;
    private Integer leaseAccount;
    private String leaseAddress;
    private String leaseCompanyPhone;
    private String leaseLegal;
    private String leaseLegalPhone;
    private String leaseLegalIdCard;
    private Float leaseAmount;
    private Float leasePrepaid;
    private Float leaseUnpaid;
    private Float leaseOfDefault;

    private List<LeaseDevice> leaseDeviceList;
}
