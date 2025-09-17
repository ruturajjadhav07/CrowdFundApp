package com.crowdfunding.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crowdfunding.backend.dto.CampaignMediaRequest;
import com.crowdfunding.backend.dto.CampaignMediaResponse;
import com.crowdfunding.backend.service.CampaignMediaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class CampaignMediaController {

    private final CampaignMediaService campaignMediaService;

    // add media in url
    @PostMapping("/campaign/media")
    public List<CampaignMediaResponse> addMedia(
            @CurrentSecurityContext(expression = "authentication?.name") String email,
            @Valid @RequestBody CampaignMediaRequest request) {
        return campaignMediaService.insertMedia(request, email);
    }

}
