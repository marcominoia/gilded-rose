package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isNotAgedBrie;
import static com.gildedrose.helper.ItemHelper.isNotBackstagePasses;
import static com.gildedrose.helper.ItemHelper.isNotConjured;
import static com.gildedrose.helper.ItemHelper.isNotSulfuras;

public class SellInDecreasesEveryDayRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return isNotSulfuras(item);
  }

  @Override
  public Item process(Item item) {
    item.sellIn--;
    return item;
  }

}
