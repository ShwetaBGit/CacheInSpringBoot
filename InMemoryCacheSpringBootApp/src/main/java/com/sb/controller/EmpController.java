package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.dto.CommonDto;
import com.sb.entity.EmpEntity;
import com.sb.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {

//	http://localhost:8080/swagger-ui/index.html
	
	
	/*
	 * 1. First save multple Emp into table atleast 4/5. Api: /save 2. Then Fetch
	 * all EMP Api: /fetchAllEmp
	 * 
	 * 3. Then fetch perticular Emp by id. Api: "/fetchEmpById/{id}" 1. First time
	 * it will hit to the db for the same id 2.Secode time for the same it will not
	 * hit the db, hit will fetch from db 4. Try to update EMp Api:
	 * "/fullyUpdateEmp/{id}" 1. Data will be update into table as well as to Catche
	 * 2. Cache will be update, try to fetch emp by id or all. it will fetch from
	 * cache, it will give updated data cache 5.Same as delete
	 */	 
   		 

	@Autowired
	private EmpService empService;

	@PostMapping("/save")
	public EmpEntity saveEmp(@RequestBody CommonDto empdto) {
		return empService.saveEmp(empdto);
	}

	@GetMapping("/fetchEmpById/{id}")
	public EmpEntity getEmpById(@PathVariable Long id) {
		return empService.fetchEmpById(id);
	}

	@GetMapping("/fetchAllEmp")
	public List<EmpEntity> getAllEmp() {
		return empService.getAll();
	}

	@PutMapping("/fullyUpdateEmp/{id}")
	public EmpEntity updateFullyEmp(@PathVariable Long id, @RequestBody CommonDto dto) {
		return empService.putEmp(id, dto);
	}

	@DeleteMapping("/deleteEmpById")
	public String deleteEmpRecord(Long id) {
		return empService.removeEmp(id);
	}

}
