package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BackstagePassesQualityIncreasesTwiceBeforeTenDaysToSellDateRuleTest {

  BackstagePassesQualityIncreasesTwiceBeforeTenDaysToSellDateRule rule;

  @Before
  public void setUp() {
    rule = new BackstagePassesQualityIncreasesTwiceBeforeTenDaysToSellDateRule();
  }

  @Test
  public void isApplicableTest() {
    assertTrue(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 9)));
    assertTrue(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 9)));
    assertFalse(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 9)));
    assertFalse(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 9)));
    assertFalse(rule.isApplicable(new Item("Aged Brie", 10, 1)));
    assertFalse(rule.isApplicable(new Item("Sulfuras, Hand of Ragnaros", 10, 1)));
    assertFalse(rule.isApplicable(new Item("Conjured Mana Cake", 10, 1)));
    assertFalse(rule.isApplicable(new Item("Item", 10, 1)));
  }

  @Test
  public void processTest() {
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2);
    Item actual = rule.process(item);
    assertEquals(4, actual.quality);
  }

}