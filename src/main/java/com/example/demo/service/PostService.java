package com.example.demo.service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(Long no){
        return postRepository.findById(no).orElse(null);
    }

    public Post saveUpdtaePost(Post post){
        return postRepository.save(post);
    }

    public void deletePost(Long no){
        postRepository.deleteById(no);
    }

}
