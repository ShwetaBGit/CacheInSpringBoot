package com.sb.service;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sb.dto.CommonDto;
import com.sb.entity.EmpEntity;
import com.sb.mysql.repository.EmpRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepo;

	private AtomicInteger dbCallCount = new AtomicInteger(0);

	@Cacheable("saveEmp")
	public EmpEntity saveEmp(CommonDto empDto) {
		EmpEntity emp = new EmpEntity();
		emp.setEname(empDto.getName());
		emp.setDepartment(empDto.getDepartment());
		emp.setDesignation(empDto.getDesignation());
		emp.setExperience(empDto.getExperience());
		emp.setDoj(Instant.now());
		return empRepo.save(emp);
	}

	@Cacheable(key = "#id", value = "emp", unless = "#result != null && #result.designation == 'SE'") //here it means designation 'SE' will not be cached, it will fetch from db
	public EmpEntity fetchEmpById(Long id) {
		System.out.println("Hit the data from db:findById");
		return empRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
	}

	public List<EmpEntity> getAll() {
		System.out.println("Hit the data from db:findAll()");
		return empRepo.findAll();
	}

	@CachePut(value = "emp", key = "#id")
	public EmpEntity putEmp(Long id, CommonDto empDto) {
		EmpEntity existingEmp = empRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity not found with id:" + id));
		existingEmp.setEname(empDto.getName());
		existingEmp.setDepartment(empDto.getDepartment());

		return empRepo.save(existingEmp);
	}

	public EmpEntity patchEmp(Long id, CommonDto empDto) {
		EmpEntity existingEmp = empRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity not found with id:" + id));
		existingEmp.setEname(empDto.getName());
		existingEmp.setDepartment(empDto.getDepartment());
		existingEmp.setExperience(empDto.getExperience());
		return empRepo.save(existingEmp);
	}

	public int getDbCallCount() {
		return dbCallCount.get();
	}

}
