package com.crowdfunding.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CampaignMediaResponse {
    private Long id;
    private String mediaUrl;
    private String mediaType;
    private Long campaignId;
    private String postedBy;
}
