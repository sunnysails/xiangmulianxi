package com.kaishengit.mapper;


import com.kaishengit.pojo.Outsource;

import java.util.List;

/**
 * Created by sunny on 2017/1/21.
 */
public interface OutsourceMapper {

    List<Outsource> findAll();

    int findMaxAccount();

    void saveNew(Outsource outsource);
}
