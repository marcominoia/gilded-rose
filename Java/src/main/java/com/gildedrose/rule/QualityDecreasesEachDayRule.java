package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.*;

public class QualityDecreasesEachDayRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return isNotAgedBrie(item) &&
           isNotBackstagePasses(item) &&
           isNotConjured(item) &&
           isNotSulfuras(item) &&
           item.sellIn > 0;
  }

  @Override
  public Item process(Item item) {
    item.quality--;
    return item;
  }

}
