package com.gildedrose;

import static java.util.Arrays.stream;

import com.gildedrose.itemcase.ItemCaseFactory;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    stream(items)
        .forEach(this::updateItemQuality);
  }

  private void updateItemQuality(Item item) {
    ItemCaseFactory.getItemCaseForItemName(item.name)
        .updateItemQualityAndSellIn(item);
  }
}