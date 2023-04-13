package com.example.assetmanager.service.comment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentRequest {

    private Long employeeId;
    private Long assetId;
    private String message;
    private LocalDateTime dateOfComment;
}
