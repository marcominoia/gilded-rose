package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QualityDecreasesEachDayRuleTest {

  QualityDecreasesEachDayRule rule;

  @Before
  public void setUp() {
    rule = new QualityDecreasesEachDayRule();
  }

  @Test
  public void isApplicableTest() {
    assertFalse(rule.isApplicable(new Item("Aged Brie", 1, 1)));
    assertFalse(rule.isApplicable(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1)));
    assertFalse(rule.isApplicable(new Item("Sulfuras, Hand of Ragnaros", 1, 1)));
    assertFalse(rule.isApplicable(new Item("Conjured Mana Cake", 1, 1)));
    assertTrue(rule.isApplicable(new Item("Item", 1, 1)));
    assertFalse(rule.isApplicable(new Item("Item", 0, 1)));

  }

  @Test
  public void processTest() {
    Item item = new Item("myItem", 2, 2);
    Item actual = rule.process(item);
    assertEquals(1, actual.quality);
  }

}