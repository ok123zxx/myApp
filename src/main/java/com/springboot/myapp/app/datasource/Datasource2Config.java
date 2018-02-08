package com.springboot.myapp.app.datasource;

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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/*
 * 基于mybatis的数据源 2 的配置
 */
@Configuration
@MapperScan(basePackages = {"com.springboot.myapp.mapper.datasrc2Mapper"},sqlSessionFactoryRef = "dateSrc2SessionFactory")
public class Datasource2Config {

    @Bean(name = "dataSrc2")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    @Primary
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSrc2TransactionManager")
    public DataSourceTransactionManager getTransactionManager(@Qualifier("dataSrc2") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dateSrc2SessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactroy(@Qualifier("dataSrc2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:resources/mapper/datasrc2/*.xml");
        //bean.setMapperLocations(resources);
        //xml位置配置
        return bean.getObject();
    }

    @Bean(name = "dateSrc2SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("dateSrc2SessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
