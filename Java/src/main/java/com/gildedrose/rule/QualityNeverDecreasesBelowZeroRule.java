package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isNotSulfuras;

public class QualityNeverDecreasesBelowZeroRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return  isNotSulfuras(item) &&
            item.quality < 0;
  }

  @Override
  public Item process(Item item) {
    item.quality = 0;
    return item;
  }

}
