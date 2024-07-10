package com.example.Database_practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Database_practice.models.Writers;
import com.example.Database_practice.services.WritersServices;


@RestController
@RequestMapping("/writers")
public class WritersController {
	@Autowired
	private WritersServices writersServices;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Writers writer) {
		System.out.println("add operation completed");
		return writersServices.add(writer);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		System.out.println("get all operation completed");
		return writersServices.getAll();
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> get(@PathVariable (name = "id")Long id){
		System.out.println("get operation completed");
		return writersServices.get(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable (name = "id") Long id,
			@RequestBody Writers writer){
		System.out.println("update operation completed");
		return writersServices.update(writer, id);
	}
	@DeleteMapping("/delete/{id}") 
	 public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) { 
	        // Delete the user in this method with the id.
		System.out.println("delete operation completed");
		return writersServices.delete(id);
	 }
}
