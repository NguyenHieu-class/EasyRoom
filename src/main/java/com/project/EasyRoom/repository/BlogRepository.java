package com.project.EasyRoom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

	long count();
}
