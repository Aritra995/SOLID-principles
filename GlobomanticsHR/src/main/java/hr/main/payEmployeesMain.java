package hr.main;

import hr.logging.ConsoleLogger;
import hr.payment.PaymentProcessor;
import hr.persistence.EmployeeFileRepository;
import hr.persistence.EmployeeFileSerializer;
import hr.persistence.EmployeeRepository;

public class payEmployeesMain {
    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        //EmployeeRepository employeeRepository = new EmployeeRepository(employeeFileSerializer);
        EmployeeFileRepository employeeFileRepository = new EmployeeRepository(employeeFileSerializer);

        PaymentProcessor paymentProcessor = new PaymentProcessor(employeeFileRepository);
        int totalPayments = paymentProcessor.sendPayments();
        consoleLogger.writeInfo("Total payments: "+ totalPayments);
    }
}
