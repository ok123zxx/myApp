package com.springboot.myapp.datasrc1Mapper;

import com.springboot.myapp.entity.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface DataSrc1StoreMapper {

    @Select("select * from store where id = #{id}")
    Store getById(String id);

    @Insert("insert into store(id,keyT,val) values(#{id},#{keyT},#{val})")
    int insert(Store store);

}
