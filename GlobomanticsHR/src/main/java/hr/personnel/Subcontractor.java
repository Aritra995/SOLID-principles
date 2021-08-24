package hr.personnel;

public class Subcontractor {
    private final int monthlyIncome;
    private int nbHoursPerWeek;
    private String email;
    private String name;
    public Subcontractor(String name,String email,int monthlyIncome,int nbHoursPerWeek){
        this.name = name;
        this.email = email;
        this.monthlyIncome = monthlyIncome;
        this.nbHoursPerWeek = nbHoursPerWeek;
    }
    public boolean approveSLA(ServiceLicenceAgreement serviceLicenceAgreement){
        boolean result = false;
        if( serviceLicenceAgreement.getMinUptimePercent() >= 98 &&
            serviceLicenceAgreement.getProblemResolutionTimeDays() <= 2){
            result = true;
        }
        System.out.println("SLA for: "+this.name+" : "+result);
        return result;
    }
}
