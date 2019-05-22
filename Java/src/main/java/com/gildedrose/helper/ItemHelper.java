package com.gildedrose.helper;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemConstants.*;

public class ItemHelper {

  public static boolean isAgedBrie(Item item) {
    return item.name.equals(AGED_BRIE);
  }

  public static  boolean isBackstagePasses(Item item) {
    return item.name.equals(BACKSTAGE_PASSE);
  }

  public static boolean isSulfuras(Item item) {
    return item.name.equals(SULFURAS);
  }

  public static boolean isConjured(Item item) {
    return item.name.startsWith(CONJURED);
  }

}
