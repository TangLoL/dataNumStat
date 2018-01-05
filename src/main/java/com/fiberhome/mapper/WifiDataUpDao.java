package com.fiberhome.mapper;

import com.fiberhome.entity.WifiDataUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by zyf on 2017/12/8.
 */
public interface WifiDataUpDao extends JpaRepository<WifiDataUp,Integer> {

    @Query(value = "select * from ST_WIFIDATAUP where time=(select  max(time) from ST_WIFIDATAUP t) ORDER  by time desc",nativeQuery=true)
    public List<WifiDataUp> getRecentData();
    @Query(value = "select *  from ST_WIFIDATAUP where time = ?1 ",nativeQuery = true)
    public List<WifiDataUp> getRecentDate(String time);
    @Query(value = "SELECT  * from (SELECT * from ST_WIFIDATAUP ORDER by time desc) WHERE rownum<=?1",nativeQuery = true)
    List<WifiDataUp> getTopFive(int number);
    @Query(value = "select  max(time) from ST_WIFIDATAUP t",nativeQuery = true)
    String getMaxDate();
}
