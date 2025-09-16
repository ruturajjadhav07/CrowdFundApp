package com.crowdfunding.backend.service;

import com.crowdfunding.backend.dto.ContributionRequest;
import com.crowdfunding.backend.dto.ContributionResponse;

public interface ContributionService {
    ContributionResponse createContribution(ContributionRequest request,String email);
}
