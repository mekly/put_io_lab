package put.io.testing.mocks;

import java.util.Collections;
import java.util.List;

import put.io.students.fancylibrary.database.IFancyDatabase;

public class MyDatabase implements IFancyDatabase{

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void connect() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <T> void persist(T arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <T> List<T> queryAll() {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }

}