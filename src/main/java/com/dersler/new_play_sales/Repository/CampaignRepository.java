package com.dersler.new_play_sales.Repository;

import com.dersler.new_play_sales.Entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}
