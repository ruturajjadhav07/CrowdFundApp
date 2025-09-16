package com.crowdfunding.backend.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crowdfunding.backend.dto.ContributionRequest;
import com.crowdfunding.backend.dto.ContributionResponse;
import com.crowdfunding.backend.entity.Campaign;
import com.crowdfunding.backend.entity.Contributions;
import com.crowdfunding.backend.entity.UserEntity;
import com.crowdfunding.backend.repository.CampaignRepository;
import com.crowdfunding.backend.repository.ContributionRepository;
import com.crowdfunding.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContributionServiceImpl implements ContributionService {

    private final ContributionRepository contributionRepository;
    private final UserRepository userRepository;
    private final CampaignRepository campaignRepository;

    @Override
    public ContributionResponse createContribution(ContributionRequest request, String email) {
        // 1. Find user
        UserEntity existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // 2. Find campaign
        Campaign campaign = campaignRepository.findById(request.getCampaignId())
                .orElseThrow(() -> new RuntimeException("Campaign not found with id: " + request.getCampaignId()));

        // 3. Build contribution entity
        Contributions contribution = buildContribution(request, campaign, existingUser);

        // 4. Save contribution
        Contributions savedContribution = contributionRepository.save(contribution);

        // 5. Update campaign amount raised
        campaign.setAmountRaised(campaign.getAmountRaised() + request.getAmount());
        campaignRepository.save(campaign);

        // 6. Build and return response
        return buildContributionResponse(savedContribution);
    }

    // ------------------- Private helper methods -------------------

    private Contributions buildContribution(ContributionRequest request, Campaign campaign, UserEntity user) {
        return Contributions.builder()
                .campaign(campaign)
                .user(user)
                .amount(request.getAmount())
                .build(); // rely on @CreationTimestamp in entity for createdAt
    }

    private ContributionResponse buildContributionResponse(Contributions contribution) {
        return ContributionResponse.builder()
                .contributionId(contribution.getContributionId()) // ensure entity uses "id"
                .amount(contribution.getAmount())
                .createdAt(contribution.getCreatedAt().toLocalDateTime()) // or contribution.getDate() if using                                                // LocalDate
                .contributor(contribution.getUser().getUsername()) // safer than getName()
                .campaignTitle(contribution.getCampaign().getTitle())
                .build();
    }
}
