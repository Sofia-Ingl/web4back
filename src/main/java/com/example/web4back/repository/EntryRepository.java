package com.example.web4back.repository;

import com.example.web4back.model.EntryBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<EntryBean, Long> {
}
