package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isNotAgedBrie;
import static com.gildedrose.helper.ItemHelper.isNotBackstagePasses;
import static com.gildedrose.helper.ItemHelper.isNotConjured;
import static com.gildedrose.helper.ItemHelper.isNotSulfuras;

public class QualityDecreasesTwiceAfterSellByDateRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return isNotAgedBrie(item) &&
           isNotBackstagePasses(item) &&
           isNotConjured(item) &&
           isNotSulfuras(item) &&
           item.sellIn <= 0;
  }

  @Override
  public Item process(Item item) {
    item.quality = item.quality -2;
    return item;
  }

}
