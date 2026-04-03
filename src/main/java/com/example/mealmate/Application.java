package com.example.mealmate;

import com.example.mealmate.domain.MealPost;
import com.example.mealmate.domain.Status;
import com.example.mealmate.repository.MealPostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(MealPostRepository repository) {
        return args -> {
            MealPost post = new MealPost();
            post.setMaxParticipants(2);
            post.setCurrentParticipants(1);
            post.setStatus(Status.RECRUITING);
            repository.save(post);
        };
    }
}
