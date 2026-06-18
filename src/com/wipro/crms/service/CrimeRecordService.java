package com.wipro.crms.service;

import java.util.ArrayList;

import com.wipro.crms.entity.CrimeCase;
import com.wipro.crms.entity.InvestigationUpdate;
import com.wipro.crms.entity.Suspect;
import com.wipro.crms.util.CaseNotFoundException;
import com.wipro.crms.util.InvalidCrimeOperationException;

public class CrimeRecordService {

    private ArrayList<CrimeCase> cases;
    private ArrayList<Suspect> suspects;
    private ArrayList<InvestigationUpdate> updates;

    public CrimeRecordService(ArrayList<CrimeCase> cases,
                              ArrayList<Suspect> suspects,
                              ArrayList<InvestigationUpdate> updates) {
        this.cases = cases;
        this.suspects = suspects;
        this.updates = updates;
    }

    public void addCrimeCase(CrimeCase crime)
            throws InvalidCrimeOperationException {

        if (crime.getDescription() == null ||
            crime.getDescription().trim().isEmpty()) {
            throw new InvalidCrimeOperationException("Invalid crime description");
        }
        cases.add(crime);
    }

    public CrimeCase findCrimeCase(String caseId)
            throws CaseNotFoundException {

        for (CrimeCase c : cases) {
            if (c.getCaseId().equals(caseId)) {
                return c;
            }
        }
        throw new CaseNotFoundException("Case not found : " + caseId);
    }

    public void addSuspectToCase(String caseId, Suspect suspect)
            throws CaseNotFoundException, InvalidCrimeOperationException {

        findCrimeCase(caseId);

        for (Suspect s : suspects) {
            if (s.getSuspectId().equals(suspect.getSuspectId())) {
                throw new InvalidCrimeOperationException("Duplicate suspect");
            }
        }

        suspects.add(suspect);
    }

    public void updateCaseStatus(String caseId, String newStatus)
            throws CaseNotFoundException, InvalidCrimeOperationException {

        CrimeCase c = findCrimeCase(caseId);

        String currentStatus = c.getStatus();

        if (currentStatus.equals("OPEN" ) && newStatus.equals("UNDER INVESTIGATION")) {
        	
            c.setStatus(newStatus);
        } 
        else if (currentStatus.equals("UNDER INVESTIGATION") && newStatus.equals("CLOSED")) {
        	
            c.setStatus(newStatus);

        } 
        else {
            throw new InvalidCrimeOperationException("Invalid status update : " + newStatus);
        }
    }

    public void addInvestigationUpdate(InvestigationUpdate update)
            throws CaseNotFoundException, InvalidCrimeOperationException {

        findCrimeCase(update.getCaseId());

        if (update.getDescription() == null || update.getDescription().trim().isEmpty()) {

            throw new InvalidCrimeOperationException("Invalid Description");
        }
        updates.add(update);
    }

    public ArrayList<Suspect> getCaseSuspects(String caseId)
            throws CaseNotFoundException {

        findCrimeCase(caseId);
                                  
        return suspects;
    }

    public ArrayList<InvestigationUpdate> getCaseUpdates(String caseId)
            throws CaseNotFoundException {

        findCrimeCase(caseId);

        return updates;
    }

    public void generateCaseSummary(String caseId) {

        try {
        	
            CrimeCase c = findCrimeCase(caseId);

            System.out.println("Case ID : " + c.getCaseId());
            System.out.println("Crime Type : " + c.getCrimeType());
            System.out.println("Description : " + c.getDescription());
            System.out.println("Status : " + c.getStatus());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}