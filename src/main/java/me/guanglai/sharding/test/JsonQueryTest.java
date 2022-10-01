package me.guanglai.sharding.test;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class JsonQueryTest {

    @Resource(name = "shardingJdbcTemplate")
    private JdbcTemplate shardingJdbcTemplate;

    @Resource(name = "basicJdbcTemplate")
    private JdbcTemplate basicJdbcTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        // WRONG
        System.out.println(shardingJdbcTemplate.queryForMap("SELECT json_field->>'$.key' FROM json_test WHERE id = ?", 2));
        // WORK
//        System.out.println(shardingJdbcTemplate.queryForMap("SELECT json_field FROM json_test WHERE id = ?", 2));

        System.out.println(basicJdbcTemplate.queryForMap("SELECT json_field->>'$.key' FROM json_test0 WHERE id = ?", 2));

    }

}
