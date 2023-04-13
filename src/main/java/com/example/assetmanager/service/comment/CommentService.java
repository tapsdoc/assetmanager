package com.example.assetmanager.service.comment;

import java.util.List;

public interface CommentService {

    CommentResponse addComment(CommentRequest request);
    CommentResponse getComment(CommentRequest request);
    List<CommentResponse> getAllComments();
    void delete(Long id);
}
