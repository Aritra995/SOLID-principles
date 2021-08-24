package hr.documents;

import hr.personnel.Employee;

import java.time.Month;

public class Payslip implements ExportableText{
    private String employeeName;
    private int monthlyIncome;
    private Month month;

    public Payslip(Employee employee,Month month){
        this.employeeName = employee.getFullName();
        this.monthlyIncome = employee.getMonthlyIncome();
        this.month = month;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public Month getMonth() {
        return month;
    }
    @Override
    public String toTxt() {
        StringBuilder sb = new StringBuilder();
        sb.append("MONTH: ").append(this.month);
        sb.append(System.lineSeparator());
        sb.append("NAME: ").append(this.employeeName);
        sb.append(System.lineSeparator());
        sb.append("INCOME: ").append(this.monthlyIncome);
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
