package com.kaishengit.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by sunny on 2017/1/21.
 */
@Data
public class Outsource {
    private Integer id;
    private Integer outAccount;
    private String outAddress;
    private String outCompany;
    private String outCompanyPhone;
    private String outLegal;
    private String outLegalPhone;
    private String outLegalIdCard;
    private Float outAmount;
    private Float outPrepaid;
    private Float outUnpaid;
    private Float outOfDefault;
    private Integer outState;
    private Timestamp outCreateTime;

    private List<LeaseWorker> leaseWorkerList;
}
