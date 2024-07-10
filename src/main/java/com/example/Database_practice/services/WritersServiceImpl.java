package com.example.Database_practice.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Database_practice.models.ResponseMessage;
import com.example.Database_practice.models.Writers;
import com.example.Database_practice.repositories.WritersRepository;

@Service
public class WritersServiceImpl implements WritersServices{
	
	@Autowired
	private WritersRepository writersRepository;

	@Override
	public ResponseEntity<?> add(Writers writers) {
		if(Objects.isNull(writers.getName()) || writers.getName().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid name"));
		}
		return ResponseEntity.ok(writersRepository.save(writers));
	}

	@Override
	public ResponseEntity<?> getAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(writersRepository.findAll());
	}

	@Override
	public ResponseEntity<?> get(Long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(writersRepository.findById(id));
	}

	@Override
	public ResponseEntity<?> update(Writers writers, Long id) {
		Optional<Writers> optionalExistingBU = writersRepository.findById(id);
		if(optionalExistingBU.isPresent()) {
			optionalExistingBU.get().setCatagory(writers.getCatagory().trim());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Succesfully Updated"));
		}
		else
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Not Found"));
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		// TODO Auto-generated method stub
		Optional<Writers> optionalExistingBU = writersRepository.findById(id);
		if(optionalExistingBU.isPresent())
		{
			writersRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Writer deleted"));

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Not Found"));

	}
	

}
