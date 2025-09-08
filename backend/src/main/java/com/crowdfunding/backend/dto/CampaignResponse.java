package com.crowdfunding.backend.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampaignResponse {
    private long campaignId;
    private String title;
    private String description;
    private double goalAmount;
    private double amountRaised;
    private LocalDate deadline;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    private String createdBy; // username of the user
}
