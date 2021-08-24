package hr.personnel;

public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String fullName, int monthlyIncome) {
        super(fullName, monthlyIncome);
        this.setNbHoursPerWeek(40);
    }

    @Override
    public void requestTimeOff(int nbDays, Employee manager) {
        System.out.println("Timeoff req for full time employee"+this.getFullName()
        +"; Nb days: "+nbDays+" requested from: "+manager.getFullName());
    }
}
