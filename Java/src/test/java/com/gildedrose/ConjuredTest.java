package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredTest {

    @Test
    public void testConjuredQualityDecreasesTwiceEachDay() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 2, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testConjuredQualityDecreasesByFourTimesAfterSellByDate() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 1, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void testConjuredQualityNeverDecreasesBelowZero() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }



}
