package hr.persistence;

import hr.personnel.Employee;
import hr.personnel.FullTimeEmployee;
import hr.personnel.Intern;
import hr.personnel.PartTimeEmployee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepository implements EmployeeFileRepository {
    private EmployeeFileSerializer serializer;
    public EmployeeRepository(EmployeeFileSerializer serializer){
        this.serializer = serializer;
    }
    public List<Employee> findAll(){
        List<Employee> employees = new ArrayList<>();

        String path =  this.getClass().getClassLoader()
                .getResource("employees.csv")
                .getPath();

        try (Scanner scanner = new Scanner(new File(path))) {
            
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Employee employee = createEmployeeFromCsvRecord(line);
                employees.add(employee);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return employees;
        /*
        Employee anna = new FullTimeEmployee("Anna Smith", 2000);
        Employee billy = new FullTimeEmployee("Billy Leech", 920);

        Employee steve = new PartTimeEmployee("Steve Jones", 800);
        Employee magda = new PartTimeEmployee("Magda Iovan", 920);

        return Arrays.asList(anna, billy, steve, magda);*/

    }
    private Employee createEmployeeFromCsvRecord(String line) {
        String[] employeeRecord = line.split(",");
        String name = employeeRecord[0];
        int income = Integer.parseInt(employeeRecord[1]);
        int nbHours = Integer.parseInt(employeeRecord[2]);

        Employee employee;
        if(nbHours == 40){
            employee = new FullTimeEmployee(name,income);
        } else if (nbHours == 20){
            employee = new PartTimeEmployee(name, income);
        } else{
            employee = new Intern(name, income, nbHours);
        }
        return employee;
    }

    public void save(Employee employee) throws IOException{
        String serializedString = this.serializer.serialize(employee);
        Path path = Paths.get(employee.getFullName()
                .replace(" ","_") + ".rec");
        Files.write(path, serializedString.getBytes());
    }
}
