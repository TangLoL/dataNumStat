package com.fiberhome.mapper;

import com.fiberhome.entity.WZDataIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WZDataInDao extends JpaRepository<WZDataIn,Integer>{

    @Query(value = "select * from st_wzdatain_stat where time = ( select max(time) from st_wzdatain_stat where time <= ?1)" ,nativeQuery = true)
    public List<WZDataIn> getLatestListByTime(String time);

    @Query(value = "select time from st_wzdatain_stat where time = ?1",nativeQuery = true)
    public String getTimeByTime(String time);

    @Query(value = "select * from st_wzdatain_stat where time =?1",nativeQuery = true)
    public List<WZDataIn> getListByTime(String time);
}
