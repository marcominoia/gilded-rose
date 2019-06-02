package com.gildedrose.rule;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemHelper.isNotSulfuras;

public class QualityIsNeverMoreThanFiftyRule implements Rule {

  @Override
  public boolean isApplicable(Item item) {
    return  isNotSulfuras(item) &&
            item.quality > 50;
  }

  @Override
  public Item process(Item item) {
    item.quality = 50;
    return item;
  }

}
