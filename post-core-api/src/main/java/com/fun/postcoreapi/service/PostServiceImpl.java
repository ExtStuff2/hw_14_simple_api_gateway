package com.fun.postcoreapi.service;

import com.fun.postcoreapi.models.PostModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private HashMap<String, PostModel> posts = new HashMap<>();

    {
        PostModel post = new PostModel("21123919", "21123912",
                "Just test post 1", "send");

        PostModel post1 = new PostModel("21123333", "21123222",
                "Just test post 2", "in progress");
        posts.put(post.getPostId(), post);
        posts.put(post1.getPostId(), post1);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return posts.values().stream().toList();
    }

    @Override
    public PostModel getPostById(String id) {
        if (posts.containsKey(id)) {
            return posts.get(id);
        }
        return null;
    }

    @Override
    public String getPostStatusById(String id) {
        if (posts.containsKey(id)) {
            return posts.get(id).getStatus();
        }
        return null;
    }

    @Override
    public void createPost(PostModel postModel) {
        posts.put(postModel.getPostId(), postModel);

    }

    @Override
    public void updatePost(PostModel postModel) {
        if (posts.containsKey(postModel.getPostId())) {
            posts.put(postModel.getPostId(), postModel);
        }
    }

    @Override
    public void deletePostById(String id) {
        posts.remove(id);
    }
}
