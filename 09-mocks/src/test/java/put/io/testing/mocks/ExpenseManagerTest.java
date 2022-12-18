package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.Transient;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.service.FancyService;


public class ExpenseManagerTest {
    @Test
    void testCalculateTotal(){
        ExpenseRepository mExpenseRepository=mock(ExpenseRepository.class);
        FancyService mfancyService=mock(FancyService.class);
        ExpenseManager expenseManager=new ExpenseManager(mExpenseRepository,mfancyService);
        when(mExpenseRepository.getExpenses()).thenReturn(Arrays.asList(new Expense(),new Expense(),new Expense()));
        long expenses=expenseManager.calculateTotal();
        assertEquals(expenses,0);

    
    }
    @Test
    void testCalculateTotalForCategory(){
        ExpenseRepository mExpenseRepository=mock(ExpenseRepository.class);
        FancyService mfancyService=mock(FancyService.class);
        when(mExpenseRepository.getExpensesByCategory(argThat((String string)->(string=="Home"||string=="Car")))).thenReturn(Collections.emptyList());
        when(mExpenseRepository.getExpensesByCategory(anyString())).thenReturn(Arrays.asList(new Expense(),new Expense()));

        ExpenseManager expenseManager=new ExpenseManager(mExpenseRepository,mfancyService);

        assertEquals(expenseManager.calculateTotalForCategory("Food"), 0);
        assertEquals(expenseManager.calculateTotalForCategory("Home"), 0);
        //Changing the order doesnt change the rwesult of the test
    }
    @Test
    void testCalculateTotalInDollars()throws ConnectException{
        FancyService fancyService=mock(FancyService.class);
        when(fancyService.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer(new Answer(){public Object answer(InvocationOnMock invocation){
            Object[] args=invocation.getArguments();
            Double arg=(Double) args[0];
            return arg*4;
        }

        });
        //when(fancyService.convert(anyDouble(), anyString(), anyString())).thenThrow(new RuntimeException() );
        ExpenseRepository mExpenseRepository=mock(ExpenseRepository.class);
        ExpenseManager expenseManager =new ExpenseManager(mExpenseRepository, fancyService);
        
        assertEquals(expenseManager.calculateTotalInDollars(),0);

    }
}
