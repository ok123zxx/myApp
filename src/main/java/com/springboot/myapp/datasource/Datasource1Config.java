package com.springboot.myapp.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/*
 * 基于mybatis的数据源 1 的配置
 */
@Configuration
@MapperScan(basePackages = {"com.springboot.myapp.mapper.datasrc1Mapper"},sqlSessionFactoryRef = "dateSrc1SessionFactory")
public class Datasource1Config {

    @Bean(name = "dataSrc1")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSrc1TransactionManager")
    public DataSourceTransactionManager getTransactionManager(@Qualifier("dataSrc1") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dateSrc1SessionFactory")
    public SqlSessionFactory getSqlSessionFactroy(@Qualifier("dataSrc1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:resources/mapper/datasrc1/*.xml");
        //bean.setMapperLocations(resources);
        //xml位置配置
        return bean.getObject();
    }

    /*
     * TODO [zengjian] 这个是干嘛的？
     */
    @Bean(name = "dateSrc1SqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("dateSrc1SessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
