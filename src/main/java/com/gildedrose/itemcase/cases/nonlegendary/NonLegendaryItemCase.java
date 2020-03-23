package com.gildedrose.itemcase.cases.nonlegendary;

import static com.gildedrose.configuration.ConfigData.EXPIRED_ITEM_DECAY_VALUE;
import static com.gildedrose.configuration.ConfigData.ITEM_QUALITY_MAX_VALUE;
import static com.gildedrose.configuration.ConfigData.ITEM_QUALITY_MIN_VALUE;
import static com.gildedrose.configuration.ConfigData.NON_EXPIRED_ITEM_DECAY_VALUE;
import static com.gildedrose.configuration.ConfigData.NORMAL_SELLIN_VALUE;

import com.gildedrose.Item;
import com.gildedrose.itemcase.ItemCase;

public abstract class NonLegendaryItemCase implements ItemCase {

  @Override
  public void updateItemQualityAndSellIn(Item item) {
    item.quality = setQualityToNotExceedMinMaxValues(getUpdatedQuality(item));
    item.sellIn -= NORMAL_SELLIN_VALUE;
  }

  public int setQualityToNotExceedMinMaxValues(int quality) {
    return Math.min(Math.max(quality, ITEM_QUALITY_MIN_VALUE), ITEM_QUALITY_MAX_VALUE);
  }

  public int getQualityChange(Item item) {
    return item.sellIn > 0 ? NON_EXPIRED_ITEM_DECAY_VALUE : EXPIRED_ITEM_DECAY_VALUE;
  }

  public abstract int getUpdatedQuality(Item item);
}
