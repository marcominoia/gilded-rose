package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTest {

    @Test
    public void testSulfurasQualityNeverDecreasesOrMustBeSold() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 80, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

}
