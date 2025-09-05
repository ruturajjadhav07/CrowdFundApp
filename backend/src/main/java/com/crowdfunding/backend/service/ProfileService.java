package com.crowdfunding.backend.service;

import com.crowdfunding.backend.dto.ProfileRequest;
import com.crowdfunding.backend.dto.ProfileResponse;

public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest request);

    ProfileResponse getProfile (String email);
}
