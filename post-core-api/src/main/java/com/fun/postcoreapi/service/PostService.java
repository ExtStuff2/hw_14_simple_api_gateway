package com.fun.postcoreapi.service;

import com.fun.postcoreapi.models.PostModel;

import java.util.List;

public interface PostService {

    List<PostModel> getAllPosts();

    PostModel getPostById(String id);

    String getPostStatusById(String id);

    void createPost(PostModel postModel);

    void updatePost(PostModel postModel);

    void deletePostById(String id);

}
