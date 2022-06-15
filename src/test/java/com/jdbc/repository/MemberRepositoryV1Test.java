package com.jdbc.repository;

import com.jdbc.connection.ConnectionConst;
import com.jdbc.domain.Member;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.Transactional;

import static com.jdbc.connection.ConnectionConst.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;

    @BeforeEach
    void beforeEach() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        repository = new MemberRepositoryV1(dataSource);

    }

    @Test
    public void save_test() throws Exception {
        Member member = new Member("memberV12", 1000);
        repository.save(member);

        Member byId = repository.findById(member.getMemberId());
        log.info("byId = {}, ", byId);
        assertEquals(member, byId);

        repository.update(member.getMemberId(), 20000);
        Member byId2 = repository.findById(member.getMemberId());
        assertEquals(byId2.getMoney(), 20000);

        repository.delete(member.getMemberId());

        Thread.sleep(1000);
    }
}