package com.crowdfunding.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crowdfunding.backend.entity.Contributions;

@Repository
public interface ContributionRepository extends JpaRepository<Contributions, Long> {

}
