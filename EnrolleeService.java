package com.healthcare.enrollee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.healthcare.enrollee.model.Dependent;
import com.healthcare.enrollee.model.Enrollee;

public class EnrolleeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EnrolleeService.class);
	 Map<String, List<Dependent>> enrolleeMap = new HashMap<String, List<Dependent>>();
	 
    public Map<String, List<Dependent>> addDependents(List<Dependent> dependents, Enrollee enrollee) {
    	LOGGER.info("Creating list of dependents entry with information: {}", dependents);

    	if(enrollee.isHasDependents()) {
    		Enrollee updateEnrollee = new Enrollee(enrollee.getEnrolleeId(), enrollee.getName(), enrollee.getActiveStatus(), enrollee.isHasDependents(), enrollee.getBirthDate(), enrollee.getPhoneNum());
        	enrolleeMap.put(updateEnrollee.getEnrolleeId(), dependents);
    	}
    	LOGGER.info("The list of dependents entry with information: {}", enrolleeMap.values());
    	return enrolleeMap;
    }
    
    public Map<String, List<Dependent>> updateDependents(Dependent dependentDetails, Enrollee enrollee) {
    	LOGGER.info("Dependent for updating information: {}", dependentDetails);
    	List<Dependent> dependents = enrolleeMap.get(enrollee.getEnrolleeId());
     	for(Dependent dependentElem : dependents) {
     		dependentElem.setDependentId(dependentDetails.getDependentId());
     		dependentElem.setName(dependentDetails.getName());
     		dependentElem.setBirthDate(dependentDetails.getBirthDate());
    	}
     	LOGGER.info("After updating, the list of dependents entry with information: {}", dependents);
     	return enrolleeMap;
    }
    
    public Enrollee deleteDependents(Enrollee enrollee) {
    	LOGGER.info("Deleting list of dependents entry with Enrollee information: {}", enrollee);
    	List<Dependent> dependents = enrolleeMap.get(enrollee.getEnrolleeId());
     	dependents.removeAll(dependents);
     	enrollee.setHasDependents(false);
     	Enrollee updateEnrollee = new Enrollee(enrollee.getEnrolleeId(), enrollee.getName(), enrollee.getActiveStatus(), enrollee.isHasDependents(), enrollee.getBirthDate(), enrollee.getPhoneNum());
     	LOGGER.info("After deleting, the list of dependents with Enrollee information: {}", updateEnrollee);
     	return updateEnrollee;

    }
    
}
