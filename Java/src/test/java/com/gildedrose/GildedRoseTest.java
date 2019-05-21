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

    @Test
    public void testQualityDecreasesTwiceAfterSellByDate() {
        Item[] items = new Item[] { new Item("myItem", 1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("myItem", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
        app.updateQuality();
        assertEquals("myItem", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testQualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("myItem", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("myItem", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals("myItem", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testAgedBrieQualityIncreases() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void testAgedBrieQualityIncreasesTwiceAfterExpires() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void testAgedBrieQualityIsNeverMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void testSulfurasQualityNeverDecreasesOrMustBeSold() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 80, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIncreasesBeforeSellDate() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIncreasesTwiceBefore10DaysToSellDate() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIncreasesBy3Before5DaysToSellDate() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityDropsToZeroAfterSellDate() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
