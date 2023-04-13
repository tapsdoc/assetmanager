package com.example.assetmanager.service.comment;

import com.example.assetmanager.domain.Asset;
import com.example.assetmanager.domain.Comment;
import com.example.assetmanager.domain.Employee;
import com.example.assetmanager.repository.AssetRepo;
import com.example.assetmanager.repository.CommentRepo;
import com.example.assetmanager.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final AssetRepo assetRepo;
    private final EmployeeRepo employeeRepo;

    @Override
    public CommentResponse addComment(CommentRequest request) {

        Optional<Asset> asset = assetRepo.findById(request.getAssetId());
        if (asset.isEmpty()) {
            throw new IllegalArgumentException("Asset not found");
        }
        Optional<Employee> employee = employeeRepo.findById(request.getEmployeeId());
        if (employee.isEmpty()) {
            throw new IllegalArgumentException("Employee not found");
        }

        Comment comment = Comment.builder()
            .asset(asset.get())
            .employee(employee.get())
            .message(request.getMessage())
            .dateOfComment(LocalDateTime.now())
            .build();

        var savedComment = commentRepo.save(comment);
        return CommentResponse.of(savedComment);
    }

    @Override
    public CommentResponse getComment(Long id) {
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        return CommentResponse.of(comment);
    }

    @Override
    public List<CommentResponse> getAllComments() {
        List<Comment> comments = new ArrayList<>(commentRepo.findAll());
        return CommentResponse.of(comments);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Comment not found");
        }
    }
}
