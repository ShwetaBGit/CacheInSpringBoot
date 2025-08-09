package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

	@PatchMapping("/partiallyUpdateEmp/{id}")
	public EmpEntity updatePartialyEmp(@PathVariable Long id, @RequestBody CommonDto dto) {
		return empService.patchEmp(id, dto);
	}

}
