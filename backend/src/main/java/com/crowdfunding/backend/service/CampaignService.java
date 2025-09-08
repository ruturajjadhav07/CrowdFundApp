package com.crowdfunding.backend.service;

import com.crowdfunding.backend.dto.CampaignRequest;
import com.crowdfunding.backend.dto.CampaignResponse;

public interface CampaignService {
    CampaignResponse createCampaign(CampaignRequest request, String email);
}
