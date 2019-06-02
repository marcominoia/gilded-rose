package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConjuredQualityDecreasesByFourTimesAfterSellByDateRuleTest {

  ConjuredQualityDecreasesByFourTimesAfterSellByDateRule rule;

  @Before
  public void setUp() {
    rule = new ConjuredQualityDecreasesByFourTimesAfterSellByDateRule();
  }

  @Test
  public void isApplicableTest() {
    assertTrue(rule.isApplicable(new Item("Conjured Mana Cake", 0, 1)));
    assertTrue(rule.isApplicable(new Item("Conjured Mana Cake", -1, 1)));
    assertFalse(rule.isApplicable(new Item("Conjured Mana Cake", 1, 1)));
    assertFalse(rule.isApplicable(new Item("Aged Brie", 1, 1)));
    assertFalse(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1)));
    assertFalse(rule.isApplicable(new Item("Sulfuras, Hand of Ragnaros", 1, 1)));
    assertFalse(rule.isApplicable(new Item("Item", 1, 1)));
  }

  @Test
  public void processTest() {
    Item item = new Item("Conjured Mana Cake", 0, 7);
    Item actual = rule.process(item);
    assertEquals(3, actual.quality);
  }

}