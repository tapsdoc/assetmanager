package com.example.assetmanager.repository;

import com.example.assetmanager.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c")
    @Override
    List<Comment> findAll();
}
