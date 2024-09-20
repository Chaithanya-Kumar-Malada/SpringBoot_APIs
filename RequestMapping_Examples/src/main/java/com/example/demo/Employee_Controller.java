package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employee_Controller {

	
	List<Employee> emplist = new ArrayList<>(
			
							Arrays.asList(		
									 new Employee(4,"Sumo",22,5000.00d),
									 new Employee(2,"Pavan",26,1500.00d),
									 new Employee(3,"Kodi",23,25000.00)	,
									 new Employee(5,"Surya",16,1200.00) ,
									 new Employee(1,"Surya",16,1000.00)   ));
	
	//Employee HighestSalary = sortSalary.get(emplist.size()-1);
	//Employee LowestSalary = sortSalary.get(0);
	
	
	@RequestMapping("/list")
	public List<Employee> list(){
		return emplist;
	}
	
	@RequestMapping("/list/{id}")
	public Employee listById(@PathVariable int id){
		
		Employee e1 = emplist.stream().filter(i->i.getId()==id).findFirst().get();
		
		return e1;
	}
	
	
	@RequestMapping("/sortID")
	public List<Employee> sortid(){
		
		List<Employee> sortID = emplist.stream().sorted(Comparator.comparing(i->i.getId())).collect(Collectors.toList()) ;
		return sortID;
	}
	
	@RequestMapping("/sortName")
	public List<Employee> sortName(){
		
		List<Employee> sortName =emplist.stream().sorted(Comparator.comparing(Employee::getName).thenComparingDouble(i->i.getSalary())).collect(Collectors.toList());
		return sortName;
	}
	
	@RequestMapping("/sortSalary")
	public List<Employee> sortSalary(){
		
		List<Employee> sortSalary =emplist.stream().sorted(Comparator.comparing(i->i.getSalary())).collect(Collectors.toList());
		return sortSalary;
	}
	
	@RequestMapping("/HighestSalary")
	public Employee HighSalary(){
		
		Employee HighestSalary = emplist.stream().sorted(Comparator.comparing(i->i.getSalary())).collect(Collectors.toList()).getLast();
		return HighestSalary;
	}
	
	@RequestMapping("/LowestSalary")
	public Employee LowSalary(){
		Employee LowestSalary = emplist.stream().sorted(Comparator.comparing(i->i.getSalary() )).findFirst().get();;
		return LowestSalary;
	}
	
	@RequestMapping("/AgeEligibility")
	public List<Employee> AgeEligibility(){
		List<Employee> AgeEligibility = emplist.stream().filter(i->i.getAges()>18).collect(Collectors.toList());
		return AgeEligibility;
	}
	
	@RequestMapping("/empnames")
	public List<String> empnames(){
		List<String> empnames = emplist.stream().map(i->i.getName()).collect(Collectors.toList());
		return empnames;
	}
	
	@RequestMapping("/AmtGivenList")
	public List<Double> AmtGiven(){
		List<Double> AmtGivenList =emplist.stream().map(i->i.getSalary()).collect(Collectors.toList());
		return AmtGivenList;
	} 
	
	@RequestMapping("/TotalAmt")
	public double TotalAmt() {
		List<Double> AmtGivenList =emplist.stream().map(i->i.getSalary()).collect(Collectors.toList());

		double sum = 0;
			for(double i : AmtGivenList) {
				sum = sum + i;
			}
		return sum;
	}
	
	///   POST request syntax 
	
	@PostMapping("/addEmp")
	public String addEmp(@RequestBody Employee e1) {
		
		emplist.add(e1);
		return "Employee added Succesfully ";
	}
	
	// Delete request syntax 
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		
		emplist.removeIf(i->i.getId()==id);
		
		return "Employee Deleted Succesfully ";
		
	}
	
	
	// Update request Syntax 
	
	@PutMapping("/update/{id}")
	public String updateEmp( @PathVariable int id, @RequestBody Employee e2 ) {
		
		Employee existingEmp = emplist.stream().filter(i->i.getId()==id).findFirst().get() ;
		
		existingEmp.setId(e2.getId());
		existingEmp.setName(e2.getName());
		existingEmp.setAge(e2.getAges());
		existingEmp.setSalary(e2.getSalary());
		
		return "Employee updated succesfully ";	
	}
	
//	@PatchMapping("/patch/{name}")
//	public String patchEmp( @PathVariable String name, @RequestBody String e2 ) {
//		
//		Employee existingEmp = emplist.stream().filter(i->i.getName()==name).findFirst().get() ;
//		
//		//existingEmp.setId(e2.getId());
//		existingEmp.setName(e2);
//		//existingEmp.setAge(e2.getAges());
//		//existingEmp.setSalary(e2.getSalary());
//		
//		return "Employee patch updated succesfully ";	
//	}
	
	
}
