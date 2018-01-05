package com.fiberhome.service;

import com.fiberhome.mapper.WifiDataUpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zyf on 2017/12/8.
 */
@Service
public class WifiDataUpImp {
    @Autowired
    private WifiDataUpDao wifiDataUpDao;
}
