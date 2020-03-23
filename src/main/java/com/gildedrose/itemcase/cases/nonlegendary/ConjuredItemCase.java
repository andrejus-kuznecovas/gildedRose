package com.gildedrose.itemcase.cases.nonlegendary;

import static com.gildedrose.configuration.ConfigData.CONJURED_ITEM_DECAY_VALUE;

import com.gildedrose.Item;

public class ConjuredItemCase extends NonLegendaryItemCase {

  @Override
  public int getUpdatedQuality(Item item) {
    return item.quality - (getQualityChange(item) * CONJURED_ITEM_DECAY_VALUE);
  }
}