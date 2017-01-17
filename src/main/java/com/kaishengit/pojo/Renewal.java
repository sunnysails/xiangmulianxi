package com.kaishengit.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by sunny on 2017/1/17.
 */
@Data
public class Renewal implements Serializable {
    private Integer id;
    private Timestamp createTime;
    private Timestamp returnTime;
}
