package com.example.mealmate.service;

import com.example.mealmate.domain.MealPost;
import com.example.mealmate.domain.Status;
import com.example.mealmate.repository.MealPostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MealPostService {

    private final MealPostRepository repository;

    public MealPostService(MealPostRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void join(Long postId) {
        MealPost post = repository.findById(postId)
                .orElseThrow(() -> new RuntimeException("모집글이 존재하지 않습니다."));

        if (post.getStatus() != Status.RECRUITING) {
            throw new RuntimeException("현재 모집 중인 글이 아닙니다.");
        }

        if (post.getCurrentParticipants() >= post.getMaxParticipants()) {
            throw new RuntimeException("이미 모집이 완료되었습니다.");
        }

        post.increaseParticipants();

        if (post.getCurrentParticipants() == post.getMaxParticipants()) {
            post.changeToFull();
        }
    }
}
