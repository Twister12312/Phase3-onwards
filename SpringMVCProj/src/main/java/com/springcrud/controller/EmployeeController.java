package com.springcrud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcrud.beans.Employee;
import com.springcrud.DAO.EmployeeDao;
@Controller
public class EmployeeController {
	@Autowired
	EmployeeDao dao;
	
	
	
	@RequestMapping(value="/viewemp")
	public String viewemp(Model m){
		List<Employee> empList= dao.getEmployeesDetails();
		/*for(Employee e : empList){
			System.out.println(e.getEid());
		}*/
		m.addAttribute("empList",empList);
		return "viewemp";
	}
	@RequestMapping(value="/viewemp2/{eid}",  method=RequestMethod.GET)
	public String viewsingle(@PathVariable int eid,Model m){
		
		
		try {
			Employee emp=dao.getEmpId(eid);
			m.addAttribute("emp1",emp);
			return "viewemp2";
		}
		catch(Exception e){
			return "redirect:/again.jsp";
		}
		
	}
	@RequestMapping(value="/empform", method=RequestMethod.GET)
	
	public String showForm(Model m){
	Employee emp=new Employee();
	m.addAttribute("emp", emp);
		
		return "empform";
	}
	
	@RequestMapping(value="/editemp/{eid}", method=RequestMethod.GET)
	public String edit(@PathVariable int eid, Model m){
		
		Employee emp=dao.getEmpId(eid);
		m.addAttribute("emp2",emp);
		return "empeditform";
	}
	
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public String editSave(@ModelAttribute("emp2") Employee emp){
		
		System.out.println(emp.getEid());
		dao.update(emp);
		return "redirect:/confirm.jsp";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("emp") Employee emp){
		dao.insert(emp);
	
	return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="/deleteemp/{eid}", method=RequestMethod.GET)
	public String deleterecord(@PathVariable("eid") int eid){
		dao.delete(eid);
		return "redirect:/viewemp";
	}
	
}
