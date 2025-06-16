package com.project.EasyRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.EasyRoom.model.Blog;
import com.project.EasyRoom.service.BlogService;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public List<Blog> getAll() {
        return blogService.getAllBlog();
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> getById(@PathVariable int id) {
        Blog blog = blogService.getBlogById(id);
        if (blog != null) {
            return ResponseEntity.ok(blog);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/blogs")
    public Blog create(@RequestBody Blog blog) {
        blogService.saveBlog(blog);
        return blog;
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity<Blog> update(@PathVariable int id, @RequestBody Blog blog) {
        Blog existing = blogService.getBlogById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        blog.setIdBlog(id);
        blogService.saveBlog(blog);
        return ResponseEntity.ok(blog);
    }

    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }
}
