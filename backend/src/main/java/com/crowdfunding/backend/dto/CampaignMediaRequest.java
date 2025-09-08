package com.crowdfunding.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampaignMediaRequest {

    @NotNull(message = "Media URLs cannot be empty")
    @Size(min = 1, max = 4, message = "You can upload between 1 and 4 media files")
    private List<@NotBlank(message = "Media URL cannot be blank") String> mediaUrls;

    @NotBlank(message = "Media type cannot be empty") // IMAGE or VIDEO
    private String mediaType;

    @NotNull(message = "Campaign ID is required")
    private Long campaignId;
}
