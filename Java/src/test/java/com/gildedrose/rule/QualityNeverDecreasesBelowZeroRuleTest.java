package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QualityNeverDecreasesBelowZeroRuleTest {

  QualityNeverDecreasesBelowZeroRule rule;

  @Before
  public void setUp() {
    rule = new QualityNeverDecreasesBelowZeroRule();
  }

  @Test
  public void isApplicableTest() {
    assertFalse(rule.isApplicable(new Item("Sulfuras, Hand of Ragnaros", 1, -1)));
    assertTrue(rule.isApplicable(new Item("Item", 1, -1)));
    assertFalse(rule.isApplicable(new Item("Item", 0, 0)));
    assertFalse(rule.isApplicable(new Item("Item", 0, 1)));

  }

  @Test
  public void processTest() {
    Item item = new Item("myItem", 2, -1);
    Item actual = rule.process(item);
    assertEquals(0, actual.quality);
  }

}