package com.gildedrose.rule;

import com.gildedrose.Item;

public interface Rule {

  boolean isApplicable(Item item);

  Item process(Item item);
}
