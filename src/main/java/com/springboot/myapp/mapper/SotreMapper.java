package com.springboot.myapp.mapper;

import com.springboot.myapp.entity.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface SotreMapper {

    @Select("select * from store where id = #{id}")
    Store getById(String id);

    @Insert("insert into store values(#{id},#{key},#{val})")
    int insert(Store store);

}
