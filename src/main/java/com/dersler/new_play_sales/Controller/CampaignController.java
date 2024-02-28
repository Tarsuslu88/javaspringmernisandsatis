package com.dersler.new_play_sales.Controller;

import com.dersler.new_play_sales.Entities.Campaign;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @PostMapping("/add")
    public Campaign addCampaign(@RequestBody Campaign campaign){
        return null;
    }

    @GetMapping("/")
    public Campaign getCampaign(@RequestParam int Id){
        return null;
    }

    @PutMapping("/update")
    public Campaign updateCampaign(@RequestParam int Id, @RequestBody Campaign campaign){
        return null;
    }

    @DeleteMapping("/delete")
    public void deleteCampaign(@RequestParam int Id){

    }

}
