package com.dersler.new_play_sales.Services.abstracts;

import com.dersler.new_play_sales.Entities.Campaign;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ICampaignService {

    public Campaign addCampaign(Campaign campaign);

    public Campaign getCampaign(int Id);

    public Campaign updateCampaign(int Id, Campaign campaign);

    public void deleteCampaign(int Id);

}
