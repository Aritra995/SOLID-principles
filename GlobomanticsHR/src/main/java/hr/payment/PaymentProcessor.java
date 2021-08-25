package hr.payment;

import hr.notifications.EmployeeNotifier;
import hr.persistence.EmployeeFileRepository;
import hr.persistence.EmployeeRepository;
import hr.personnel.Employee;

import java.util.List;

public class PaymentProcessor {
    private EmployeeFileRepository employeeFileRepository;
    private EmployeeRepository employeeRepository;

    public PaymentProcessor(EmployeeFileRepository employeeFileRepository){
        this.employeeFileRepository = employeeFileRepository;
        //this.employeeRepository = employeeRepository;
    }
    public int sendPayments(){
        List<Employee> employees = employeeFileRepository.findAll();
        int totalPayments = 0;
        for(Employee employee: employees){
            totalPayments += employee.getMonthlyIncome();
            //this.employeeNotifier.notify(employee);
        }
        return totalPayments;
    }

}
