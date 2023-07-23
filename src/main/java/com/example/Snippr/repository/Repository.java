package com.example.Snippr.repository;

import com.example.Snippr.model.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Snippet, Long> {


}
