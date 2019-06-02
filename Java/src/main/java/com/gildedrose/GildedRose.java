package com.gildedrose;

import com.gildedrose.service.RulesService;
import com.gildedrose.service.UpdateQualityService;

class GildedRose {

    Item[] items;

    private UpdateQualityService updateQualityService;

    private RulesService rulesService;

    public GildedRose(Item[] items) {
        updateQualityService = new UpdateQualityService();
        rulesService = new RulesService();
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityService.updateQuality(item, rulesService.getRules());
        }
    }

}