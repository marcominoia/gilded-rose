package com.gildedrose.service;

import com.gildedrose.Item;
import com.gildedrose.rule.Rule;

import java.util.List;

public class UpdateQualityService {

  public Item updateQuality(Item item, List<Rule> rules) {
    for (Rule rule : rules) {
      if (rule.isApplicable(item))
        item = rule.process(item);
    }
    return item;
  }

}
