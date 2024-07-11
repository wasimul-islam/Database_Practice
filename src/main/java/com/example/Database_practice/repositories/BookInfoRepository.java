package com.example.Database_practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Database_practice.models.BookInfo;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo, Long> {

}
