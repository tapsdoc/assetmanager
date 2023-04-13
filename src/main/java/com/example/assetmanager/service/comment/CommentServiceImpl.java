package com.example.assetmanager.service.comment;

import com.example.assetmanager.repository.AssetRepo;
import com.example.assetmanager.repository.CommentRepo;
import com.example.assetmanager.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final AssetRepo assetRepo;
    private final EmployeeRepo employeeRepo;

    @Override
    public CommentResponse addComment(CommentRequest request) {
        return null;
    }

    @Override
    public CommentResponse getComment(CommentRequest request) {
        return null;
    }

    @Override
    public List<CommentResponse> getAllComments() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
