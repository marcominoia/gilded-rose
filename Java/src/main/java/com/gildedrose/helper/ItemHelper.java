package com.gildedrose.helper;

import com.gildedrose.Item;

import static com.gildedrose.helper.ItemConstants.*;

public class ItemHelper {

  public static boolean isAgedBrie(Item item) {
    return item.name.equals(AGED_BRIE);
  }

  public static boolean isNotAgedBrie(Item item) {
    return !item.name.equals(AGED_BRIE);
  }

  public static  boolean isBackstagePasses(Item item) {
    return item.name.equals(BACKSTAGE_PASSE);
  }

  public static  boolean isNotBackstagePasses(Item item) {
    return !item.name.equals(BACKSTAGE_PASSE);
  }

  public static boolean isSulfuras(Item item) {
    return item.name.equals(SULFURAS);
  }

  public static boolean isNotSulfuras(Item item) {
    return !item.name.equals(SULFURAS);
  }

  public static boolean isConjured(Item item) {
    return item.name.equals(CONJURED);
  }

  public static boolean isNotConjured(Item item) {
    return !item.name.equals(CONJURED);
  }

}
