package com.crowdfunding.backend.controllers;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crowdfunding.backend.dto.ContributionRequest;
import com.crowdfunding.backend.dto.ContributionResponse;
import com.crowdfunding.backend.service.ContributionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ContributeController {

    private final ContributionService contributionService;

    @PostMapping("/contribution")
    public ContributionResponse contribute(@CurrentSecurityContext(expression = "authentication?.name") String email,
            @Valid @RequestBody ContributionRequest request) {
        return contributionService.createContribution(request, email);
    }
}
