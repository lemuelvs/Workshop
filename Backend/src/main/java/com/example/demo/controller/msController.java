package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.main.Mobile;
import com.example.demo.repository.msRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/")
public class msController {
	@Autowired
	msRepository repo;
	
	@GetMapping("/")
	public List<Mobile> getAllEmp(){
		return repo.findAll();
	}
	
	@PostMapping("/")
	public Mobile createEmployee(@RequestBody Mobile x) {
		return repo.save(x);
	}
	
	@GetMapping("/{id}")
	public Optional<Mobile> getEmpbyId(@PathVariable int id){
		Optional<Mobile> temp=repo.findById(id);
		return temp;
	}
	
	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable int id,@RequestBody Mobile upd) {
		if(repo.existsById(id)) {
			Mobile t=new Mobile();
			t.setId(id);
			t.setMobileName(upd.getMobileName());
			t.setColor(upd.getColor());
			t.setPrice(upd.getPrice());
			repo.save(t);
		}
		return " ";
	}
	@DeleteMapping("/{id}")
	public String removeEmp(@PathVariable int id) {
		if(repo.existsById(id)) 
		{
			repo.deleteById(id);
		    return "Deleted Successfully";
			}
			else
			{
				return "Mobile Id not exists";
		}
	}
}