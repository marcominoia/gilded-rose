package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isBackstagePasses;

public class BackstagePassesQualityIncreasesByThreeBeforeFiveDaysToSellDateRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return isBackstagePasses(item) &&
           item.sellIn <=5 &&
           item.sellIn > 0;
  }

  @Override
  public Item process(Item item) {
    item.quality = item.quality + 3;
    return item;
  }

}
