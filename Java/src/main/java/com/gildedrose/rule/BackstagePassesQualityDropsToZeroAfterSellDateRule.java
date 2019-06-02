package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isBackstagePasses;

public class BackstagePassesQualityDropsToZeroAfterSellDateRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return isBackstagePasses(item) &&
           item.sellIn <= 0;
  }

  @Override
  public Item process(Item item) {
    item.quality = 0;
    return item;
  }

}
