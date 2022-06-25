package com.company.xml;

import java.util.List;

public interface UserRepository {
    
    Employee getById(Long id);
    
    List<Employee> getAll();
}
