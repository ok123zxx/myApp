package com.springboot.myapp.mapper.datasrc2Mapper;

import com.springboot.myapp.entity.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface DataSrc2StoreMapper {

    @Select("select * from store where id = #{id}")
    Store getById(String id);

    @Insert("insert into store(id,keyT,val) values(#{id},#{keyT},#{val})")
    int insert(Store store);

}
