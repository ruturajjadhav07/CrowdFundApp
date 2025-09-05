package com.crowdfunding.backend.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crowdfunding.backend.dto.ProfileRequest;
import com.crowdfunding.backend.dto.ProfileResponse;
import com.crowdfunding.backend.entity.UserEntity;
import com.crowdfunding.backend.enums.Role;
import com.crowdfunding.backend.exception.UserNotFoundException;
import com.crowdfunding.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;

    // create user profile
    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
        UserEntity newProfile = convertToEntity(request);
        if (!userRepository.existsByEmail(request.getEmail())) {
            newProfile = userRepository.save(newProfile);
            return convertToProfileResponse(newProfile);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already Exists");
    }

    // get profile info
    @Override
    public ProfileResponse getProfile(String email) {
        UserEntity existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found for email:" + email));
        return convertToProfileResponse(existingUser);
    }

    // create user
    private UserEntity convertToEntity(ProfileRequest request) {
        return UserEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .userId(UUID.randomUUID().toString())
                .role(Role.USER)
                .build();
    }

    // show user info
    private ProfileResponse convertToProfileResponse(UserEntity profile) {
        return ProfileResponse.builder()
                .username(profile.getUsername())
                .email(profile.getEmail())
                .userId(profile.getUserId())
                .build();
    }

}
