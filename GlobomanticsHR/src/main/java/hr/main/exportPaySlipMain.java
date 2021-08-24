package hr.main;

import hr.documents.Payslip;
import hr.logging.ConsoleLogger;
import hr.persistence.EmployeeFileSerializer;
import hr.persistence.EmployeeRepository;
import hr.personnel.Employee;

import java.time.Month;
import java.util.List;

public class exportPaySlipMain {
    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository = new EmployeeRepository(employeeFileSerializer);

        List<Employee> employees = employeeRepository.findAll();
        for(Employee employee: employees){
            Payslip payslip = new Payslip(employee, Month.AUGUST);
            String exportableTxt = payslip.toTxt();
            consoleLogger.writeInfo(exportableTxt);
        }
    }
}
