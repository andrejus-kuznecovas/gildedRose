package com.gildedrose;

import static java.util.Arrays.stream;

import com.gildedrose.itemcase.ItemCaseFactory;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  private static void updateItemQuality(Item item) {
    ItemCaseFactory.getItemCaseForItemName(item.name)
        .updateItemQualityAndSellIn(item);
  }

  public void updateQuality() {
    stream(items)
        .forEach(GildedRose::updateItemQuality);
  }
}