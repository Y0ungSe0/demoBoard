package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private PostService postService;

    @GetMapping("/board")
    public String board(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "board/view";
    }
    // 글하나 읽기
    @GetMapping("/board/{no}")
    public String viewPost(@PathVariable("no") Long no, Model model) {
        Post post = postService.findById(no);
        if(post == null) {
            return "error";
        }
        model.addAttribute("post", post);
        return "board/view-one";
    }

    @GetMapping("/board/new")
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "board/new";
    }

    @PostMapping("/board/post")
    public String createPost(@ModelAttribute("post") Post post) {
        post.setRDateTime(); // 등록 시간 설정
        postService.saveUpdtaePost(post);
        return "redirect:/board";
    }

    @PostMapping("/board/update")
    public String update(@ModelAttribute("post") Post post,
                         @RequestParam("no") Long no,
                         RedirectAttributes attributes){
        post.setUDateTime();
        postService.saveUpdtaePost(post);

        attributes.addAttribute("no", no);

        return "redirect:/board/{no}";
    }

    @GetMapping("/board/update/{no}")
    public String updatePost(@PathVariable("no") Long no,
                             Model model) {
        Post post = postService.findById(no);
        model.addAttribute("post", post);
        return "board/update";
    }

    @DeleteMapping("/board/delete/{no}")
    public String deletePost(@PathVariable Long no){
        postService.deletePost(no);
        return "redirect:/board";
    }

}
