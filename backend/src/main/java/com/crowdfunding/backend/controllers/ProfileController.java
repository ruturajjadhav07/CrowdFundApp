package com.crowdfunding.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crowdfunding.backend.dto.ProfileRequest;
import com.crowdfunding.backend.dto.ProfileResponse;
import com.crowdfunding.backend.service.ProfileService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    // create user profile
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request) {
        return profileService.createProfile(request);
    }

    // get user profile
    @GetMapping("/profile")
    public ProfileResponse getProfile(@RequestParam String email) {
        return profileService.getProfile(email);
    }

}
