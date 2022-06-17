package com.jdbc.exception.baisc;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


@Slf4j
public class UncheckedTest {
    
    @Test
    public void unChecked() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow())
                .isInstanceOf(MyUncheckedException.class);

    }

    static class MyUncheckedException extends RuntimeException {
        public MyUncheckedException(String message) {
            super(message);
        }
    }

    static class Repository {
        public void call() {
            throw new MyUncheckedException("ex");
        }
    }

    /*
    * Unchecked 예외는
    * 잡거나, 던지지 않아도 된다.
    * 자동으로 밖으로 던진다
    */
    static class Service {
        Repository repository = new Repository();

        public void callCatch() {
            try {
                repository.call();
            } catch (MyUncheckedException e) {
                log.info("예외 처리, message={}", e.getMessage(), e);
            }
        }

        public void callThrow() {
            repository.call();
        }
    }


}
