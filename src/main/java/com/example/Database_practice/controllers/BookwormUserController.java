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

import com.example.Database_practice.models.BookwormUser;
import com.example.Database_practice.services.BookwormUserService;



@RestController
@RequestMapping("/bookworm-user")
public class BookwormUserController {
	
	@Autowired
	private BookwormUserService bookwormUserService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addBookwormUser(@RequestBody BookwormUser bookwormUser) {
		System.out.println("add");
		return bookwormUserService.add(bookwormUser);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		System.out.println("get");
		return bookwormUserService.getAll();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable (name = "id") Long id,
			@RequestBody BookwormUser bookwormUser){
		return bookwormUserService.update(id, bookwormUser);
	}
	@DeleteMapping("/delete/{id}") 
	 public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long id) { 
	        // Delete the user in this method with the id.
		return bookwormUserService.delete(id);
	 }

}