package com.gildedrose.itemcase.cases.nonlegendary;

import com.gildedrose.Item;

public class NormalItemCase extends NonLegendaryItemCase {

  @Override
  public int getUpdatedQuality(Item item) {
    return item.quality - getQualityChange(item);
  }
}
