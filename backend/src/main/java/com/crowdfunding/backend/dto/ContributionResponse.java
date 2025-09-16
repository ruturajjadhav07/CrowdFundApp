package com.crowdfunding.backend.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContributionResponse {
    private Long contributionId;
    private Double amount;
    private LocalDateTime createdAt;
    private String contributor;     // username or full name
    private String campaignTitle;
}
