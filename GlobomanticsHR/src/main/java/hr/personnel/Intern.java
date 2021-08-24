package hr.personnel;

public class Intern extends Employee {
    public Intern(String fullName, int monthlyIncome, int nbHours) {
        super(fullName, monthlyIncome);
        setNbHoursPerWeek(nbHours);
    }

    @Override
    public void requestTimeOff(int nbDays, Employee manager) {
        System.out.println("Timeoff req for intern"+this.getFullName()
                +"; Nb days: "+nbDays+" requested from: "+manager.getFullName());
    }
}
