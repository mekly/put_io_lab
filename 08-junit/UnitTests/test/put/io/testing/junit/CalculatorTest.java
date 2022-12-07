package put.io.testing.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;
    //3.1 Cannot use @BeforeAll  because methods are not static
    @BeforeEach
    public void setUp()throws Exception{
        calculator=new Calculator();
    }
    @Test
    void testAdd() {
        //Calculator calculator1=new Calculator();
        assertEquals(10,calculator.add(4,6));
        assertEquals(53,calculator.add(10,43));
    }

    @Test
    void testMultiply() {
        //Calculator calculator1=new Calculator();
        assertEquals(20,calculator.multiply(4,5));
        assertEquals(12,calculator.multiply(3,4));
    }
    @Test
    void testAddPositiveNumbers(){
        //Calculator calculator1=new Calculator();

        assertThrows(IllegalArgumentException.class,()-> calculator.addPositiveNumbers(-1,2));
    }

}