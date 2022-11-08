package com.example.demo_cfp.repository;

import com.example.demo_cfp.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test,Long> {
}
