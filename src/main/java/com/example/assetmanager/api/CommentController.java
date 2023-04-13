package com.example.assetmanager.api;

import com.example.assetmanager.service.comment.CommentRequest;
import com.example.assetmanager.service.comment.CommentResponse;
import com.example.assetmanager.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment/")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentResponse> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse addComment(@RequestBody CommentRequest request) {
        return commentService.addComment(request);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentResponse getComment(@PathVariable Long id) {
        return commentService.getComment(id);
    }
}
