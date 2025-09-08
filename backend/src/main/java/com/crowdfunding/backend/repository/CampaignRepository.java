package com.crowdfunding.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crowdfunding.backend.entity.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

}
