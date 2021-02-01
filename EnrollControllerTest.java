package com.healthcare.enrollee;

import static org.junit.Assert.assertEquals;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.healthcare.enrollee.controller.EnrolleeService;
import com.healthcare.enrollee.model.Dependent;
import com.healthcare.enrollee.model.Enrollee;

public class EnrollControllerTest extends AbstractTest {
	private EnrolleeService enrolleeService;
	
	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	      enrolleeService = new EnrolleeService(); 
	   }
	   
	   @Test
	   public void createEnrollee() throws Exception {
	      String uri = "/healthcare/enrollee";
	      Enrollee enrollee = new Enrollee();
	      enrollee.setEnrolleeId("aa1");
	      enrollee.setName("Albert");
	      enrollee.setActiveStatus(true);
	      enrollee.setHasDependents(false);
	      enrollee.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1999-02-10"));

	      String inputJson = super.mapToJson(enrollee);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "");
	   }
	   
	   @Test
	   public void updateEnrollee() throws Exception {
	      String uri = "/healthcare/enrollee/3";
	      Enrollee enrollee = new Enrollee();
	      enrollee.setEnrolleeId("cc");
	      enrollee.setName("Jessica");
	      enrollee.setActiveStatus(true);
	      enrollee.setHasDependents(true);
	      enrollee.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1997-03-14"));
	      String inputJson = super.mapToJson(enrollee);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "");
	   }
	   
	   @Test
	   public void deleteEnrollee() throws Exception {
	      String uri = "/healthcare/enrollees/2";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "");
	   }
	   
	   @Test
	   public void createDependents() throws Exception {
		   Map<String, List<Dependent>> enrolleeMap = new HashMap<String, List<Dependent>>();
	      Enrollee enrollee = new Enrollee();
	      enrollee.setEnrolleeId("aa");
	      enrollee.setName("John");
	      enrollee.setActiveStatus(true);
	      enrollee.setHasDependents(true);
	      enrollee.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1989-09-03"));
	      
	      List<Dependent> deptList = new ArrayList<Dependent>();
	      Dependent dependentEE = new Dependent();
	      dependentEE.setDependentId("ee");
	      dependentEE.setName("Eleina");
	      dependentEE.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-04-14"));
		  deptList.add(dependentEE);
		  
		  Dependent dependentFF = new Dependent();
		  dependentFF.setDependentId("ff");
		  dependentFF.setName("Flendanna");
		  dependentFF.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-06-22"));
		  deptList.add(dependentFF);
		  
		  enrolleeMap = enrolleeService.addDependents(deptList, enrollee);
	      assertEquals(1, enrolleeMap.values().size());
	   }
	   
	   @Test
	   public void UpdateDependents() throws Exception {
		   Map<String, List<Dependent>> enrolleeMap = new HashMap<String, List<Dependent>>();
	      Enrollee enrollee = new Enrollee();
	      enrollee.setEnrolleeId("aa");
	      enrollee.setName("John");
	      enrollee.setActiveStatus(true);
	      enrollee.setHasDependents(true);
	      enrollee.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1989-09-03"));
	      
	      List<Dependent> deptList = new ArrayList<Dependent>();
	      Dependent dependentEE = new Dependent();
	      dependentEE.setDependentId("ee");
	      dependentEE.setName("Eleina");
	      dependentEE.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-04-14"));
		  deptList.add(dependentEE);
		  
		  Dependent dependentFF = new Dependent();
		  dependentFF.setDependentId("ff");
		  dependentFF.setName("Flendanna");
		  dependentFF.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-06-22"));
		  deptList.add(dependentFF);
		  
		  Dependent dependentGG = new Dependent();
		  dependentGG.setDependentId("gg");
		  dependentGG.setName("Gina");
		  dependentGG.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-04-14"));
		  
		  enrolleeMap = enrolleeService.addDependents(deptList, enrollee);
		  enrolleeMap = enrolleeService.updateDependents(dependentGG, enrollee);
	   }
	   
	   @Test
	   public void DeletingDependents() throws Exception {
		   Map<String, List<Dependent>> enrolleeMap = new HashMap<String, List<Dependent>>();
	      Enrollee enrollee = new Enrollee();
	      enrollee.setEnrolleeId("aa");
	      enrollee.setName("John");
	      enrollee.setActiveStatus(true);
	      enrollee.setHasDependents(true);
	      enrollee.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1989-09-03"));
	      
	      List<Dependent> deptList = new ArrayList<Dependent>();
	      Dependent dependentEE = new Dependent();
	      dependentEE.setDependentId("ee");
	      dependentEE.setName("Eleina");
	      dependentEE.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-04-14"));
		  deptList.add(dependentEE);
		  
		  Dependent dependentFF = new Dependent();
		  dependentFF.setDependentId("ff");
		  dependentFF.setName("Flendanna");
		  dependentFF.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-06-22"));
		  deptList.add(dependentFF);
		  
		  Dependent dependentGG = new Dependent();
		  dependentGG.setDependentId("gg");
		  dependentGG.setName("Gina");
		  dependentGG.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-04-14"));
		  
		  enrolleeMap = enrolleeService.addDependents(deptList, enrollee);
		  enrollee = enrolleeService.deleteDependents(enrollee);
	   }
}
