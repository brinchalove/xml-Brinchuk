package com.company.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryInMemory implements UserRepository {
    private static final Map<Long, Employee> data = new HashMap<>();
    static {
        data.put(1L, new Employee(1L, "Kyle","Walker","kyle002@gmail.com","+375346546", "qweasd123", "right back", Byte.valueOf((byte) 1)));
        data.put(2L, new Employee(2L, "Harry","Kane","kane@gmail.com","+375123421", "zxcasdqwe", "forward", Byte.valueOf((byte) 3)));
        data.put(3L, new Employee(3L, "John","Stones","stonsy1992@gmail.com","+654646546", "admin", "centre back", Byte.valueOf((byte) 2)));
    }
    
    
    @Override
    public Employee getById(Long id) {
        return data.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(data.values());
    }

}
