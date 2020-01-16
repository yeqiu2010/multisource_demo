package com.threestone.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by admin on 2019/12/19.
 */
@Configuration
@MapperScan(basePackages = "com.threestone.dao.xd",sqlSessionFactoryRef = "xdSqlSessionFactory")
public class XDDataSourceConfig {
    @Primary
    @Bean(name = "xdDataSource")
    @ConfigurationProperties("spring.datasource.xd")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "xdSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("xdDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:**/dao/mapping/xd/*.xml"));
        return sessionFactoryBean.getObject();
    }
}
