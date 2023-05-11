package com.cms.project.dao;

import com.cms.project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {

    List<Category> getAllCategory();
}
