package com.jdbc.connection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DBConnectionUtilTest {

    @Test
    public void connetion() throws Exception {
        // given
        Connection connection = DBConnectionUtil.getConnection();
        log.info("connection = {}", connection);

        // when

        // then
    }
}