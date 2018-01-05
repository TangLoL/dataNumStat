package com.fiberhome.mapper;

import com.fiberhome.entity.NodeControlRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by zyf on 2017/12/8.
 */
public interface NodeControlRateDao extends JpaRepository<NodeControlRate,Integer> {
    @Query(value = "select * from ST_Node_Control_Rate where time=(select  max(time) from ST_Node_Control_Rate)",nativeQuery=true)
    public List<NodeControlRate> getRecentData();
    @Query(value = "select * from ST_Node_Control_Rate where time=?1",nativeQuery = true)
    public List<NodeControlRate> getData(String time);

}
