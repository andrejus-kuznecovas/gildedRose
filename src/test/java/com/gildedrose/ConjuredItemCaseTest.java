package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConjuredItemCaseTest {

  @Test
  public void conjured_items_decay_twice_faster_before_expiring() {
    Item[] items = new Item[]{new Item("Conjured Hammer", 5, 5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(4, gildedRose.items[0].sellIn);
    assertEquals(3, gildedRose.items[0].quality);
  }

  @Test
  public void conjured_items_decay_twice_faster_after_expiring() {
    Item[] items = new Item[]{new Item("Conjured Milk", 0, 5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(-1, gildedRose.items[0].sellIn);
    assertEquals(1, gildedRose.items[0].quality);
  }
}
