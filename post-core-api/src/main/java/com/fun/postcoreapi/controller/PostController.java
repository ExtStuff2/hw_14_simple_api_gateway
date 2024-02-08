package com.fun.postcoreapi.controller;


import com.fun.postcoreapi.models.PostModel;
import com.fun.postcoreapi.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/check")
    public String getCheck() {
        return "post-core-api is working";
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("/check/status/{postId}")
    public String getPostStatusById(@PathVariable String postId) {
        return postService.getPostStatusById(postId);
    }

    @PostMapping
    public void createPost(@Valid @RequestBody PostModel postModel) {
        postService.createPost(postModel);
    }

    @PutMapping("/{postId}")
    public void updatePost(@PathVariable String postId,
                           @RequestBody PostModel postModel) {
        postService.updatePost(postModel);
    }

    //second api style
    @PutMapping
    public void updatePost(@RequestBody PostModel postModel) {
        postService.updatePost(postModel);
    }

    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable String postId) {
        postService.deletePostById(postId);
    }
}
