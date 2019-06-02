package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BackstagePassesQualityIncreasesByThreeBeforeFiveDaysToSellDateRuleTest {

  BackstagePassesQualityIncreasesByThreeBeforeFiveDaysToSellDateRule rule;

  @Before
  public void setUp() {
    rule = new BackstagePassesQualityIncreasesByThreeBeforeFiveDaysToSellDateRule();
  }

  @Test
  public void isApplicableTest() {
    assertTrue(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 9)));
    assertTrue(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 9)));
    assertFalse(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 9)));
    assertFalse(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 9)));
    assertFalse(rule.isApplicable(new Item("Aged Brie", 5, 1)));
    assertFalse(rule.isApplicable(new Item("Sulfuras, Hand of Ragnaros", 5, 1)));
    assertFalse(rule.isApplicable(new Item("Conjured Mana Cake", 5, 1)));
    assertFalse(rule.isApplicable(new Item("Item", 5, 1)));
  }

  @Test
  public void processTest() {
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2);
    Item actual = rule.process(item);
    assertEquals(5, actual.quality);
  }

}