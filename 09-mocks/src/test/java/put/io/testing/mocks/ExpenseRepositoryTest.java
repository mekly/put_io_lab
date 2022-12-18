package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        
        ExpenseRepository mockObject =mock(ExpenseRepository.class,withSettings().useConstructor(new MyDatabase()));
        Boolean empty=mockObject.getExpenses().isEmpty();
        assert(empty);
        //Tests always pass after exchanging FancyDatabase with MyDatabase
    }
    @Test
    void testLoadExpenses(){
        IFancyDatabase mockDatabase=mock(FancyDatabase.class);
        when(mockDatabase.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository expenseRepository=new ExpenseRepository(mockDatabase);
        expenseRepository.loadExpenses();
        InOrder inOrder= inOrder(mockDatabase);
        inOrder.verify(mockDatabase).connect();
        inOrder.verify(mockDatabase).close();
        verify(mockDatabase).queryAll();
        verify(mockDatabase).close();
        verify(mockDatabase).connect();
        List<Expense> expenses=expenseRepository.getExpenses();
        assert(expenses.isEmpty());
        
        }
    @Test
    void testSaveExpenses(){
        IFancyDatabase mockDatabase=mock(FancyDatabase.class);
        when(mockDatabase.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository expenseRepository=new ExpenseRepository(mockDatabase);
        Expense expense=new Expense();
        for(int i=0;i<5;i++){
        expenseRepository.addExpense(expense);}
        expenseRepository.saveExpenses();
        //verify(mockDatabase).persist(new Expense());
        verify(mockDatabase,times(5)).persist(any(Expense.class));
        
        
        
    }
    }

