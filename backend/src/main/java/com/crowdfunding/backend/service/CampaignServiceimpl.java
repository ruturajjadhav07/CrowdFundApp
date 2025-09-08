package com.crowdfunding.backend.service;

import org.springframework.stereotype.Service;

import com.crowdfunding.backend.dto.CampaignRequest;
import com.crowdfunding.backend.dto.CampaignResponse;
import com.crowdfunding.backend.entity.Campaign;
import com.crowdfunding.backend.entity.UserEntity;
import com.crowdfunding.backend.exception.UserNotFoundException;
import com.crowdfunding.backend.repository.CampaignRepository;
import com.crowdfunding.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampaignServiceimpl implements CampaignService {

    private final UserRepository userRepository;
    private final CampaignRepository campaignRepository;

    // create campaign
    @Override
    public CampaignResponse createCampaign(CampaignRequest request, String email) {
        UserEntity existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found for email: " + email));

        Campaign newCampaign = createCampaign(request, existingUser);
        newCampaign = campaignRepository.save(newCampaign);

        return convertToCampaignResponse(newCampaign);
    }

    private Campaign createCampaign(CampaignRequest request, UserEntity user) {
        return Campaign.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .goalAmount(request.getGoalAmount())
                .amountRaised(0.0) // always starts at 0
                .deadline(request.getDeadline())
                .user(user)
                .build();
    }

    private CampaignResponse convertToCampaignResponse(Campaign campaign) {
        return CampaignResponse.builder()
                .campaignId(campaign.getCampaignId())
                .title(campaign.getTitle())
                .description(campaign.getDescription())
                .goalAmount(campaign.getGoalAmount())
                .amountRaised(campaign.getAmountRaised())
                .deadline(campaign.getDeadline())
                .createdAt(campaign.getCreatedAt())
                .updatedAt(campaign.getUpdatedAt())
                .createdBy(campaign.getUser().getUsername()) // return only safe info
                .build();
    }
}
