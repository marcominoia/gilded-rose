package com.gildedrose.service;

import com.gildedrose.Item;
import com.gildedrose.helper.ItemHelper;

public class UpdateQualityService {

  public Item updateQuality(Item item) {
    updateItemQuality(item);

    updateItemSellIn(item);

    return item;
  }

  private void updateItemQuality(Item item) {
    if (!ItemHelper.isAgedBrie(item)
            && !ItemHelper.isBackstagePasses(item)) {
      if (item.quality > 0) {
        if (!ItemHelper.isSulfuras(item)) {
          if(ItemHelper.isConjured(item) && item.sellIn > 0) {
            item.quality = item.quality - 2;
          } else {
            item.quality = item.quality - 1;
          }
        }
      }
    } else {
      if (item.quality < 50) {
        item.quality = item.quality + 1;

        if (ItemHelper.isBackstagePasses(item)) {
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
    if (!ItemHelper.isSulfuras(item)) {
      item.sellIn = item.sellIn - 1;
    }

    if (item.sellIn < 0) {
      if (!ItemHelper.isAgedBrie(item)) {
        if (!ItemHelper.isBackstagePasses(item)) {
          if (item.quality > 0) {
            if (!ItemHelper.isSulfuras(item)) {
              if (ItemHelper.isConjured(item)) {
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


}
