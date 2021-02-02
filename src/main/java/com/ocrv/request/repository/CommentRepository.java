package com.ocrv.request.repository;

import com.ocrv.request.entity.Comment;
import com.ocrv.request.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findById(int id);
}
