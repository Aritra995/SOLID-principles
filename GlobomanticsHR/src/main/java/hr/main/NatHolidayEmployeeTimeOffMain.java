package hr.main;

import hr.persistence.EmployeeFileSerializer;
import hr.persistence.EmployeeRepository;
import hr.personnel.Employee;
import hr.personnel.FullTimeEmployee;

import java.util.List;

public class NatHolidayEmployeeTimeOffMain {
    public static void main(String[] args) {
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository = new EmployeeRepository(employeeFileSerializer);

        List<Employee> employees = employeeRepository.findAll();
        Employee manager = new FullTimeEmployee("Steve Jackson",5000);

        for(Employee employee :employees){
            employee.requestTimeOff(1,manager);
        }
    }
}
