package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testQualityDecreasesEachDay() {
        Item[] items = new Item[] { new Item("myItem", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("myItem", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals("myItem", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
