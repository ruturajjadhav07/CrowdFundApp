package com.crowdfunding.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crowdfunding.backend.entity.CampaignMedia;

@Repository
public interface CampaignMediaRepository extends JpaRepository<CampaignMedia, Long> {

}
