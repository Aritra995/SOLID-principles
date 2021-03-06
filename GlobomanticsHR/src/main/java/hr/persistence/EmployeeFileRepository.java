package hr.persistence;

import hr.personnel.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeFileRepository {
    List<Employee> findAll();
    void save(Employee employee) throws IOException;
}
