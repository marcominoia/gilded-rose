package com.gildedrose.service;

import com.gildedrose.rule.AgedBrieQualityIncreasesRule;
import com.gildedrose.rule.AgedBrieQualityIncreasesTwiceAfterExpiresRule;
import com.gildedrose.rule.BackstagePassesQualityDropsToZeroAfterSellDateRule;
import com.gildedrose.rule.BackstagePassesQualityIncreasesBeforeSellDateRule;
import com.gildedrose.rule.BackstagePassesQualityIncreasesByThreeBeforeFiveDaysToSellDateRule;
import com.gildedrose.rule.BackstagePassesQualityIncreasesTwiceBeforeTenDaysToSellDateRule;
import com.gildedrose.rule.ConjuredQualityDecreasesByFourTimesAfterSellByDateRule;
import com.gildedrose.rule.ConjuredQualityDecreasesTwiceEachDayRule;
import com.gildedrose.rule.QualityDecreasesEachDayRule;
import com.gildedrose.rule.QualityDecreasesTwiceAfterSellByDateRule;
import com.gildedrose.rule.QualityIsNeverMoreThanFiftyRule;
import com.gildedrose.rule.QualityNeverDecreasesBelowZeroRule;
import com.gildedrose.rule.Rule;
import com.gildedrose.rule.SellInDecreasesEveryDayRule;

import java.util.ArrayList;
import java.util.List;

public class RulesService {

  private List<Rule> rules;

  public RulesService() {
    rules = new ArrayList<>();
    rules.add(new QualityDecreasesEachDayRule());
    rules.add(new QualityDecreasesTwiceAfterSellByDateRule());
    rules.add(new AgedBrieQualityIncreasesRule());
    rules.add(new AgedBrieQualityIncreasesTwiceAfterExpiresRule());
    rules.add(new BackstagePassesQualityIncreasesBeforeSellDateRule());
    rules.add(new BackstagePassesQualityIncreasesTwiceBeforeTenDaysToSellDateRule());
    rules.add(new BackstagePassesQualityIncreasesByThreeBeforeFiveDaysToSellDateRule());
    rules.add(new BackstagePassesQualityDropsToZeroAfterSellDateRule());
    rules.add(new ConjuredQualityDecreasesTwiceEachDayRule());
    rules.add(new ConjuredQualityDecreasesByFourTimesAfterSellByDateRule());
    rules.add(new QualityNeverDecreasesBelowZeroRule());
    rules.add(new QualityIsNeverMoreThanFiftyRule());
    rules.add(new SellInDecreasesEveryDayRule());
  }

  public List<Rule> getRules() {
    return rules;
  }

}
