package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.Blog;

public interface BlogService {
	List<Blog> getAllBlog();

	Blog getBlogById(int id);

	void saveBlog(Blog blog);

	void deleteBlog(int id);
	int countBlog();
}
