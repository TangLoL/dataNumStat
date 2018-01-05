package com.fiberhome.service;

import com.fiberhome.mapper.NodeControlRateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zyf on 2017/12/8.
 */
@Service
public class NodeControlRateImp {
    @Autowired
    private NodeControlRateDao nodeControlRateDao;
}
