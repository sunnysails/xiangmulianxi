package com.kaishengit.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by sunny on 2017/1/17.
 */
@Data
public class LeaseDevice implements Serializable {
    private Integer deviceId;
    private Integer leaseId;
    private Timestamp createTime;
    private Timestamp returnTime;
    private Timestamp actualReturnTime;
    private Integer isRenewal;
    private Integer leaseNum;
    private Integer returnNum;
    private Float amount;
    private Float amountOfDefault;
    private Float paidAmount;
}
