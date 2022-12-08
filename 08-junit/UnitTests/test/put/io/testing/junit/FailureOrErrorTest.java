package put.io.testing.junit;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailureOrErrorTest {
    @Test
    void test1() {
        assertEquals(1, 3);

    }

    @Test
    void test2() {
        int x = 1 / 0;
    }
    // test1 is marked as Assertion failure, while test2 is marked as error

    @Test
    void test3() {
        try {
            assertEquals(1, 9);
        }catch (Throwable e) {
            e.printStackTrace();
            //4.2 Thrown object has class AssertionFailedError
        }
        }
    }
