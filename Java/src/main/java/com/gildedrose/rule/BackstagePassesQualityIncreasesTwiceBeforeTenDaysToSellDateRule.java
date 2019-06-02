package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isBackstagePasses;

public class BackstagePassesQualityIncreasesTwiceBeforeTenDaysToSellDateRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return isBackstagePasses(item) &&
           item.sellIn > 5 &&
           item.sellIn <=10;
  }

  @Override
  public Item process(Item item) {
    item.quality = item.quality + 2;
    return item;
  }

}
