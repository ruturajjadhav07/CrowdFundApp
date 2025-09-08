package com.crowdfunding.backend.service;

import com.crowdfunding.backend.dto.CampaignMediaRequest;
import com.crowdfunding.backend.dto.CampaignMediaResponse;

import java.util.List;

public interface CampaignMediaService {
    List<CampaignMediaResponse> insertMedia(CampaignMediaRequest request, String email);
}
