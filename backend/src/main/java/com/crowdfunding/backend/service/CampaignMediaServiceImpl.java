package com.crowdfunding.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crowdfunding.backend.dto.CampaignMediaRequest;
import com.crowdfunding.backend.dto.CampaignMediaResponse;
import com.crowdfunding.backend.entity.Campaign;
import com.crowdfunding.backend.entity.CampaignMedia;
import com.crowdfunding.backend.entity.UserEntity;
import com.crowdfunding.backend.repository.CampaignMediaRepository;
import com.crowdfunding.backend.repository.CampaignRepository;
import com.crowdfunding.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampaignMediaServiceImpl implements CampaignMediaService {

    private final UserRepository userRepository;
    private final CampaignRepository campaignRepository;
    private final CampaignMediaRepository campaignMediaRepository;

    @Override
    public List<CampaignMediaResponse> insertMedia(CampaignMediaRequest request, String email) {

        // ✅ ensure user exists
        UserEntity existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found for email: " + email));

        // ✅ ensure campaign exists
        Campaign campaign = campaignRepository.findById(request.getCampaignId())
                .orElseThrow(() -> new RuntimeException("Campaign not found with Id:" + request.getCampaignId()));

        // ✅ ensure campaign belongs to user
        if (!campaign.getUser().getId().equals(existingUser.getId())) {
            throw new RuntimeException("You are not allowed to add media to this campaign");
        }

        // ✅ validate size (defensive check, though DTO already does this)
        if (request.getMediaUrls().size() > 4) {
            throw new RuntimeException("You can only upload up to 4 media files per request");
        }

        // ✅ loop through mediaUrls and save
        List<CampaignMediaResponse> responses = new ArrayList<>();
        for (String url : request.getMediaUrls()) {
            CampaignMedia campaignMedia = addMedia(url, request.getMediaType(), campaign);
            CampaignMedia saved = campaignMediaRepository.save(campaignMedia);
            responses.add(convertToResponse(saved));
        }

        return responses;
    }

    // 🔹 helper to build entity
    private CampaignMedia addMedia(String url, String type, Campaign campaign) {
        return CampaignMedia.builder()
                .mediaUrl(url)
                .mediaType(type)
                .campaign(campaign)
                .build();
    }

    // 🔹 helper to build response
    private CampaignMediaResponse convertToResponse(CampaignMedia media) {
        return CampaignMediaResponse.builder()
                .id(media.getId())
                .mediaUrl(media.getMediaUrl())
                .mediaType(media.getMediaType())
                .campaignId(media.getCampaign().getCampaignId()).postedBy(media.getCampaign().getUser().getEmail())
                .build();
    }

}
