package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import put.io.testing.audiobooks.Audiobook;
import put.io.testing.audiobooks.AudiobookPriceCalculator;
import put.io.testing.audiobooks.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudiobookPriceCalculatorTest {
    AudiobookPriceCalculator calculator;
    Customer customer;
    Audiobook audiobook;
    @BeforeEach
    void setup(){
         calculator=new AudiobookPriceCalculator();
         audiobook=new Audiobook("Audiobook Test",30);

    }
    @Test
    void testCalculateStandard(){

            customer =new Customer("Test",Customer.LoyaltyLevel.STANDARD,false);
            assertEquals(calculator.calculate(customer,audiobook),30*1.0);

    }
    @Test
    void testCalculateGold(){
        customer =new Customer("Test",Customer.LoyaltyLevel.GOLD,false);
        assertEquals(calculator.calculate(customer,audiobook),30*0.8);
    }
    @Test
    void testCalculateSilver(){
        customer =new Customer("Test",Customer.LoyaltyLevel.SILVER,false);
        assertEquals(calculator.calculate(customer,audiobook),30*0.9);

    }
    @Test
    void testCalculateSubscriber(){
            Customer.LoyaltyLevel loyalty=Customer.LoyaltyLevel.STANDARD;
            customer = new Customer("Test", loyalty, true);
            assertEquals(calculator.calculate(customer, audiobook), 0);

    }
}
