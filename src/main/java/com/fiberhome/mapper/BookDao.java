package com.fiberhome.mapper;

import com.fiberhome.entity.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * Created by zyf on 2017/11/24.
 */

//public interface BookDao extends JpaRepository<Book,Integer> {

//    @Query("select name from book where book.name like %?1%")
//    public List<Book> findByName(String name);
//    @Query(value = "select 1 from book order by RAND() limit ?1")
//    public List<Book> randomlist(Integer n);
//}
//@Repository
@Component
//@MapperScan
@Mapper
//@Repository
public interface BookDao{
    @Select(value = "select * from book where name =#{arg0} and author=#{arg1}")
     public List<Book> findByName(String name,String author);

    @Select(value = "select * from book where name =#{name}")
     public List<Book> randomlist(Integer n);
}

