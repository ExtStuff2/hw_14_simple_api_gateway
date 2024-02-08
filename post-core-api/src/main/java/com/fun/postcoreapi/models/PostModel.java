package com.fun.postcoreapi.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class PostModel {
    private String postId;
    @NotNull(message = "Client Id can not be empty")
    @Size(min = 8, max = 8, message = "Client id must contain 8 digits")
    private String clientId;
    @NotNull
    @Size(min = 8, max = 8, message = "Recipient id must contain 8 digits")
    private String postRecipientId;
    @NotNull
    private String postItem;
    private String status;

    public PostModel(String clientId, String postRecipientId, String postItem, String status) {
        this.postId = UUID.randomUUID().toString();
        this.clientId = clientId;
        this.postRecipientId = postRecipientId;
        this.postItem = postItem;
        this.status = status;
    }
}
