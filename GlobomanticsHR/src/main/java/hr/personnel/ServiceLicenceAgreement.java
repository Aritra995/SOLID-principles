package hr.personnel;

public class ServiceLicenceAgreement {
    private int minUptimePercent;
    private int problemResolutionTimeDays;

    public ServiceLicenceAgreement(int minUptime, int problemResolutionTimeDays) {
        this.minUptimePercent = minUptime;
        this.problemResolutionTimeDays = problemResolutionTimeDays;
    }

    public int getMinUptimePercent() {
        return minUptimePercent;
    }

    public int getProblemResolutionTimeDays() {
        return problemResolutionTimeDays;
    }
}
