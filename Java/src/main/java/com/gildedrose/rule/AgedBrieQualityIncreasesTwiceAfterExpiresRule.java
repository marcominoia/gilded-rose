package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isAgedBrie;

public class AgedBrieQualityIncreasesTwiceAfterExpiresRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return isAgedBrie(item) &&
           item.sellIn <= 0;
  }

  @Override
  public Item process(Item item) {
    item.quality = item.quality+2;
    return item;
  }

}
