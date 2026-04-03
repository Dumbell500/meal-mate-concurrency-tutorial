package com.example.mealmate.controller;

import com.example.mealmate.service.MealPostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class MealPostController {

    private final MealPostService service;

    public MealPostController(MealPostService service) {
        this.service = service;
    }

    @PostMapping("/{id}/join")
    public String join(@PathVariable Long id) {
        service.join(id);
        return "참여 완료";
    }
}
