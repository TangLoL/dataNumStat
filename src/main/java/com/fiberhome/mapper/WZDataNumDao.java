package com.fiberhome.mapper;

import com.fiberhome.entity.WZDataNum;
import com.fiberhome.entity.WZDataNum_Query;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 使用mybits 作为此WZ数据汇聚情况统计的持久化层
 */

@Mapper
@Component
public interface WZDataNumDao {

    @Select(value = "select * from nw_datasum_stat")
    public List<WZDataNum> getWZNumData();

    //多参数：写法
    // param1,param2....
    // arg0,arg1....
    //在方法参数前加上@Param("写入请求参数")注解
    //使用Map，key与{}里面参数名称保持一致(方法中参入一个MAP)
    @Select(value = "select sum(a.sucrecordnum) as sumnum,b.city,substr(a.statdate,1,8) as dates,a.companyname\n" +
            "from nw_datanum_stat a,henan_city_code b\n" +
            "where a.dealflag=30 and a.statdate>= #{arg0} and a.statdate< #{arg1} and a.upareaid=b.city_code\n" +
            "group by b.city,a.upareaid,substr(a.statdate,1,8),a.companyname\n" +
            "order by substr(a.statdate,1,8) DESC , a.upareaid")
    public List<WZDataNum_Query> getQueryData(String beforetime, String aftertime);

    @Select(value = "select max(statdate) from nw_datanum_stat")
    public String getMaxDate();
}
