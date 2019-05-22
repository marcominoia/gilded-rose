package com.gildedrose.service;

import com.gildedrose.Item;

public class UpdateQualityService {

  private static final String AGED_BRIE = "Aged Brie";
  private static final String BACKSTAGE_PASSE = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  private static final String CONJURED = "Conjured";

  public Item updateQuality(Item item) {
    updateItemQuality(item);

    updateItemSellIn(item);

    return item;
  }

  private void updateItemQuality(Item item) {
    if (!isAgedBrie(item)
            && !isBackstagePasses(item)) {
      if (item.quality > 0) {
        if (!isSulfuras(item)) {
          if(isConjured(item) && item.sellIn > 0) {
            item.quality = item.quality - 2;
          } else {
            item.quality = item.quality - 1;
          }
        }
      }
    } else {
      if (item.quality < 50) {
        item.quality = item.quality + 1;

        if (isBackstagePasses(item)) {
          if (item.sellIn < 11) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }

          if (item.sellIn < 6) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }
        }
      }
    }
  }

  private void updateItemSellIn(Item item) {
    if (!isSulfuras(item)) {
      item.sellIn = item.sellIn - 1;
    }

    if (item.sellIn < 0) {
      if (!isAgedBrie(item)) {
        if (!isBackstagePasses(item)) {
          if (item.quality > 0) {
            if (!isSulfuras(item)) {
              if (isConjured(item)) {
                item.quality = item.quality - 3;
              } else {
                item.quality = item.quality - 1;
              }
            }
          }
        } else {
          item.quality = 0;
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }
    }
  }

  private boolean isAgedBrie(Item item) {
    return item.name.equals(AGED_BRIE);
  }

  private boolean isBackstagePasses(Item item) {
    return item.name.equals(BACKSTAGE_PASSE);
  }

  private boolean isSulfuras(Item item) {
    return item.name.equals(SULFURAS);
  }

  private boolean isConjured(Item item) {
    return item.name.startsWith(CONJURED);
  }

}
