package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isConjured;

public class ConjuredQualityDecreasesTwiceEachDayRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return isConjured(item) &&
           item.sellIn > 0;
  }

  @Override
  public Item process(Item item) {
    item.quality = item.quality - 2;
    return item;
  }

}
