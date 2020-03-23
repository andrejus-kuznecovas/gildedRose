package com.gildedrose.itemcase.cases.legendary;

import static com.gildedrose.configuration.ConfigData.LEGENDARY_SULFURAS_QUALITY;

import com.gildedrose.Item;

public class SulfurasItemCase extends LegendaryItemCase {

  @Override
  public void updateItemQualityAndSellIn(Item item) {
    item.quality = LEGENDARY_SULFURAS_QUALITY;
  }
}
