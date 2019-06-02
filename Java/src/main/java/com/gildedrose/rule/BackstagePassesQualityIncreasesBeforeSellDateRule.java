package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isBackstagePasses;

public class BackstagePassesQualityIncreasesBeforeSellDateRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return isBackstagePasses(item) &&
           item.sellIn > 10;
  }

  @Override
  public Item process(Item item) {
    item.quality++;
    return item;
  }

}
