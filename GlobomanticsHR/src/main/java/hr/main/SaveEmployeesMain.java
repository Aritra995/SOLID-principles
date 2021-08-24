package hr.main;

import hr.logging.ConsoleLogger;
import hr.persistence.EmployeeFileSerializer;
import hr.persistence.EmployeeRepository;
import hr.personnel.Employee;
import hr.taxes.TaxCalculator;
import hr.taxes.TaxCalculatorFactory;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        // Grab employees
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);
        List<Employee> employees = repository.findAll();

        // Save all
        Locale locale = new Locale("en","US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        double totalTax =0;
        for (Employee e : employees){
            TaxCalculator taxCalculator = TaxCalculatorFactory.create(e);
            double tax = taxCalculator.calculate(e);
            String formattedTax = currencyFormatter.format(tax);
            try {
                repository.save(e);
                consoleLogger.writeInfo("Employee saved "+e.toString());
                consoleLogger.writeInfo(e.getFullName()+" tax: "+formattedTax);
            } catch (IOException exception) {
                consoleLogger.writeError("Error saving employee", exception);
            }
            totalTax += tax;
        }
        consoleLogger.writeInfo("Total tax: "+currencyFormatter.format(totalTax));
    }
}
