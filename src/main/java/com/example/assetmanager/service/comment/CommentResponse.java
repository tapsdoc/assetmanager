package com.example.assetmanager.service.comment;

import com.example.assetmanager.domain.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class CommentResponse {

    private Long id;
    private String employeeName;
    private String assetName;
    private String message;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfComment;

    public static CommentResponse of(Comment comment) {
        Objects.requireNonNull(comment);
        CommentResponse response = new CommentResponse();

        response.setId(comment.getId());
        response.setEmployeeName(comment.getEmployee().getFirstName() + " " + comment.getEmployee().getLastName());
        response.setAssetName(comment.getAsset().getAssetId());
        response.setMessage(comment.getMessage());
        response.setDateOfComment(comment.getDateOfComment());
        return response;
    }

    public static List<CommentResponse> of(List<Comment> comments) {
        return comments.stream().map(CommentResponse::of).collect(Collectors.toList());
    }
}
