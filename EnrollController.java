package com.healthcare.enrollee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.healthcare.enrollee.model.Dependent;
import com.healthcare.enrollee.model.Enrollee;
import com.healthcare.enrollee.repository.EnrolleeRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.net.URI;

@RestController
@RequestMapping("/healthcare")
public class EnrollController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EnrollController.class);
	
    @Autowired
    EnrolleeRepository enrolleeRepository;
    
    Map<String, List<Dependent>> enrolleeMap = new HashMap<String, List<Dependent>>();
    
    //@PostMapping("/enrollees")
    @RequestMapping(value="/enrollee", method = RequestMethod.POST)
    public ResponseEntity<?> createEnrollee(@Valid @RequestBody Enrollee enrollee) {
    	LOGGER.info("Creating a new Enrollee entry with information: {}", enrollee);
    	enrollee = enrolleeRepository.save(enrollee);
        
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(enrollee.getId())
        .toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/enrollee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEnrollee(@PathVariable(value = "id") Long id,
                                            @Valid @RequestBody Enrollee enrolleeDetails) {

    	LOGGER.info("updating an Enrollee entry with information: {}", enrolleeDetails);
    	Enrollee enrollee = enrolleeRepository.findOne(id);

    	enrollee.setName(enrolleeDetails.getName());
    	enrollee.setActiveStatus(enrolleeDetails.getActiveStatus());
    	enrollee.setHasDependents(enrolleeDetails.isHasDependents());
    	enrollee.setBirthDate(enrolleeDetails.getBirthDate());
    	enrollee.setPhoneNum(enrolleeDetails.getPhoneNum());
    	
    	Enrollee updatedEnrollee = enrolleeRepository.save(enrollee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

    //@DeleteMapping("/enrollees/{id}")
    @RequestMapping(value="/enrollees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEnrollee(@PathVariable(value = "id") Long id) {
    	LOGGER.info("deleting an Enrollee entry with information: {}", id);
    	Enrollee enrollee = enrolleeRepository.findOne(id);

    	enrolleeRepository.delete(enrollee);
        return ResponseEntity.ok().build();
    }

}
