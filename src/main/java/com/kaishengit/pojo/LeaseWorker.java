package com.kaishengit.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by sunny on 2017/1/21.
 */
@Data
public class LeaseWorker {
    private Integer outId;
    private Integer workerId;
    private Timestamp workerCreateTime;
    private Timestamp workerReturnTime;
    private Integer outNum;
    private Float workerCreatePrice;

    private Worker worker;
}
