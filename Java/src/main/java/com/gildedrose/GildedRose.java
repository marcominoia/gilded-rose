package com.gildedrose;

import com.gildedrose.service.UpdateQualityService;

class GildedRose {

    Item[] items;

    UpdateQualityService updateQualityService;

    public GildedRose(Item[] items) {
        updateQualityService = new UpdateQualityService();
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityService.updateQuality(item);
        }
    }


}