package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isAgedBrie;

public class AgedBrieQualityIncreasesRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return isAgedBrie(item) &&
           item.sellIn > 0;
  }

  @Override
  public Item process(Item item) {
    item.quality++;
    return item;
  }

}
