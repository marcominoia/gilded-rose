package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BackstagePassesQualityIncreasesBeforeSellDateRuleTest {

  BackstagePassesQualityIncreasesBeforeSellDateRule rule;

  @Before
  public void setUp() {
    rule = new BackstagePassesQualityIncreasesBeforeSellDateRule();
  }

  @Test
  public void isApplicableTest() {
    assertTrue(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 9)));
    assertFalse(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 9)));
    assertFalse(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 9)));
    assertFalse(rule.isApplicable(new Item("Aged Brie", 11, 1)));
    assertFalse(rule.isApplicable(new Item("Sulfuras, Hand of Ragnaros", 11, 1)));
    assertFalse(rule.isApplicable(new Item("Conjured Mana Cake", 11, 1)));
    assertFalse(rule.isApplicable(new Item("Item", 11, 1)));
  }

  @Test
  public void processTest() {
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 2);
    Item actual = rule.process(item);
    assertEquals(3, actual.quality);
  }

}