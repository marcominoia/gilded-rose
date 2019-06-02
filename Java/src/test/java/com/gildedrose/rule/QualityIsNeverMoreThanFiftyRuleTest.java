package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QualityIsNeverMoreThanFiftyRuleTest {

  QualityIsNeverMoreThanFiftyRule rule;

  @Before
  public void setUp() {
    rule = new QualityIsNeverMoreThanFiftyRule();
  }

  @Test
  public void isApplicableTest() {
    assertFalse(rule.isApplicable(new Item("Sulfuras, Hand of Ragnaros", 1, -1)));
    assertTrue(rule.isApplicable(new Item("Item", 1, 52)));
    assertTrue(rule.isApplicable(new Item("Item", 1, 51)));
    assertFalse(rule.isApplicable(new Item("Item", 1, 50)));
    assertFalse(rule.isApplicable(new Item("Item", 1, 0)));

  }

  @Test
  public void processTest() {
    Item item = new Item("myItem", 2, 51);
    Item actual = rule.process(item);
    assertEquals(50, actual.quality);
  }

}