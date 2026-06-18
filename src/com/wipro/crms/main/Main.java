package com.wipro.crms.main;

import java.util.ArrayList;

import com.wipro.crms.entity.*;
import com.wipro.crms.service.CrimeRecordService;

public class Main {

    public static void main(String[] args) {

        ArrayList<CrimeCase> cases = new ArrayList<>();
        cases.add(new CrimeCase("C001","Theft","Mobile theft reported near market area","OPEN"));

        ArrayList<Suspect> suspects = new ArrayList<>();
        suspects.add(new Suspect("S001","Rahul Verma","Seen in the vicinity earlier"));

        ArrayList<InvestigationUpdate> updates = new ArrayList<>();

        CrimeRecordService service = new CrimeRecordService(cases, suspects, updates);

        try {

            // Add suspect
            Suspect s2 = new Suspect("S002","Manoj Singh","Known pickpocket in the area");

            service.addSuspectToCase("C001", s2);

            // Add update
            InvestigationUpdate upd1 = new InvestigationUpdate("U001","C001","2025-08-12","CCTV footage collected");

            service.addInvestigationUpdate(upd1);

            // Change status
            service.updateCaseStatus("C001","UNDER INVESTIGATION");

            // Summaries
            System.out.println("--- Case Suspects ---");

            for (Suspect s : service.getCaseSuspects("C001")) {
                System.out.println(s.getName());
            }

            System.out.println("\n--- Investigation Updates ---");

            for (InvestigationUpdate iu : service.getCaseUpdates("C001")) {
            	System.out.println("Date: "+iu.getDate());
                System.out.println("Description: "+iu.getDescription());
            }

            System.out.println("\n--- Case Summary ---");

           service.generateCaseSummary("C001");

        } catch (Exception ex) {

            System.out.println(ex);
        }
        
        //  System.out.println("\nOOPS Project done by: \n\nShyamkumar \nSathishkumar \nShamkumar");
    }
}