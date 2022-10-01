package me.guanglai.sharding.test;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@Configuration
public class JdbcTemplateConfig {

    @Resource
    private ShardingDataSource shardingDataSource;

    @Bean
    public JdbcTemplate shardingJdbcTemplate() {
        return new JdbcTemplate(shardingDataSource);
    }

    @Bean
    public BasicDataSource basicDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/ds0");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        return basicDataSource;
    }

    @Bean
    public JdbcTemplate basicJdbcTemplate() {
        return new JdbcTemplate(basicDataSource());
    }

}
