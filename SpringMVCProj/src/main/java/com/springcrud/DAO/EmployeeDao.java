package com.springcrud.DAO;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.springcrud.beans.Employee;


@Component
public class EmployeeDao {
	
	@Autowired
	JdbcTemplate template;
	
	
		public List<Employee> getEmployeesDetails(){
		String sql="select * from Employee";
		List<Employee>empList=template.query(sql,new EmployeeMapper());
		return empList;
	}
		public Employee getEmpId(int id){
			String sql="select * from Employee where eid=?";
			@SuppressWarnings("deprecation")
			Employee emp=template.queryForObject(sql,new Object[]{id},new EmployeeMapper());
			
			//zz
			//not cool man
			return emp;
		}
		
		public int update(Employee emp){
			String sql="update Employee set name=?, designation=?, salary=? where eid=?";
			int ans=template.update(sql,emp.getName(),emp.getDesignation(),emp.getSalary(),emp.getEid());
			return ans;
		}
		
		public int insert(Employee emp){
			String sql="insert into Employee(eid,name,designation,salary)values(?,?,?,?)";
			int ans=template.update(sql,emp.getEid(),emp.getName(),emp.getDesignation(),emp.getSalary());
			return ans;
		}
		public int delete(int id) {
			String sql = "delete from employee where eid=?";
			return template.update(sql, id);
		}
	
}
