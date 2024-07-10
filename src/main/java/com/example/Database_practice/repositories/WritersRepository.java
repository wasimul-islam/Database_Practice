package com.example.Database_practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Database_practice.models.Writers;

public interface WritersRepository  extends JpaRepository<Writers, Long> {

}
