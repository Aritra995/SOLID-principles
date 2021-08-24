package hr.personnel;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String fullName, int monthlyIncome) {
        super(fullName, monthlyIncome);
        this.setNbHoursPerWeek(20);
    }

    @Override
    public void requestTimeOff(int nbDays, Employee manager) {
        System.out.println("Timeoff req for part time employee"+this.getFullName()
                +"; Nb days: "+nbDays+" requested from: "+manager.getFullName());
    }
}
