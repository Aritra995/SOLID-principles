package hr.main;

import hr.personnel.Subcontractor;
import hr.personnel.ServiceLicenceAgreement;


import java.util.Arrays;
import java.util.List;

public class ApproveSLAMain {
    public static void main(String[] args) {
        int minTimeOffPercent = 98;
        int maxResolutionDays = 2;
        ServiceLicenceAgreement companySla = new ServiceLicenceAgreement(
                minTimeOffPercent,
                maxResolutionDays);

        // Get collaborators from their own source
        Subcontractor subcontractor1 = new Subcontractor(
                "Rebekah Jackson",
                "rebekah-jackson@abc.com",
                3000,
                15);
        Subcontractor subcontractor2 = new Subcontractor(
                "Harry Fitz",
                "harryfitz@def.com",
                3000, 15);
        List<Subcontractor> collaborators = Arrays.asList(subcontractor1, subcontractor2);

        // Check SLA
        for (Subcontractor s : collaborators) {
            s.approveSLA(companySla);
        }

    }
}
