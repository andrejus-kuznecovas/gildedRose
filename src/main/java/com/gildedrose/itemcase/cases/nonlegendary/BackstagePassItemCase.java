package com.gildedrose.itemcase.cases.nonlegendary;

import com.gildedrose.Item;

public class BackstagePassItemCase extends NonLegendaryItemCase {

  @Override
  public int getUpdatedQuality(Item item) {
    return getQualityChange(item);
  }

  @Override
  public int getQualityChange(Item item) {
    return calculateBackstagePassQualityChange(item);
  }

  private int calculateBackstagePassQualityChange(Item item) {
    if (item.sellIn > 10) {
      return item.quality + 1;
    }
    if (item.sellIn > 5) {
      return item.quality + 2;
    }
    if (item.sellIn > 0) {
      return item.quality + 3;
    } else {
      return 0;
    }
  }
}
