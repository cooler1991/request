package com.ocrv.request.repository;

import com.ocrv.request.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Integer> {
    Request findById(int id);
}
