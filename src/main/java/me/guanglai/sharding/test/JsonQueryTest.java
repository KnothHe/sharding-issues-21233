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
        System.out.println(shardingJdbcTemplate.queryForMap("SELECT json_field ->> '$.key' FROM json_test WHERE id = ?", 2));
        System.out.println(shardingJdbcTemplate.queryForMap("SELECT JSON_UNQUOTE(JSON_EXTRACT(jt.json_field, '$.key')) FROM json_test jt WHERE id = ?", 2));
        System.out.println(shardingJdbcTemplate.queryForMap("SELECT json_field FROM json_test WHERE id = ?", 2));
        System.out.println(shardingJdbcTemplate.queryForMap("SELECT jt.json_field FROM json_test jt WHERE id = ?", 2));

        // WRONG, table aliases and json ->>
        // https://github.com/apache/shardingsphere/issues/21233#issuecomment-1262165148
        System.out.println(shardingJdbcTemplate.queryForMap("SELECT jt.json_field ->> '$.key' FROM json_test jt WHERE id = ?", 2));

//        System.out.println(basicJdbcTemplate.queryForMap("SELECT json_field ->> '$.key' FROM json_test0 WHERE id = ?", 2));

    }

}
