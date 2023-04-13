package com.example.assetmanager.service.comment;

import lombok.Data;

@Data
public class CommentRequest {

    private Long assetId;
    private Long employeeId;
    private String message;
}
