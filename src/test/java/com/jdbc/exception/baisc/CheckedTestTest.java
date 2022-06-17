package com.jdbc.exception.baisc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CheckedTestTest {

    @Test
    public void checked_catch() throws Exception {
        Service service = new Service();
        service.callCatch();
    }

    /*
    * Exception을 상속받은 예외는 체크 예외가 된다.
    */
    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    static class Service {
        Repository repository = new Repository();

        public void callCatch() {
            repository.call();
        }
    }

    static class Repository {
        public void call() {
            try {
                throw new MyCheckedException("ex");
            } catch (Exception e) {
                e.printStackTrace();
                log.info("exception message= {}" , e.getMessage(), e);
            }
        }
    }


}