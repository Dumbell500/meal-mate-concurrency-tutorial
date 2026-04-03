package com.example.mealmate.repository;

import com.example.mealmate.domain.MealPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealPostRepository extends JpaRepository<MealPost, Long> {
}
