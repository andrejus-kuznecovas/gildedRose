package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NormalItemCaseTest {

  @Test
  public void normal_items_decay_default_rate() {
    Item[] items = new Item[]{new Item("Chocolate Bar", 5, 5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(4, gildedRose.items[0].sellIn);
    assertEquals(4, gildedRose.items[0].quality);
  }

  @Test
  public void normal_item_quality_never_negative() {
    Item[] items = new Item[]{new Item("Half Empty Water Bottle with Vitamins", 0, 0)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(-1, gildedRose.items[0].sellIn);
    assertEquals(0, gildedRose.items[0].quality);
  }

  @Test
  public void normal_item_quality_decays_faster_after_sellin_date() {
    Item[] items = new Item[]{new Item("Deathwing's Wing", 0, 5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(-1, gildedRose.items[0].sellIn);
    assertEquals(3, gildedRose.items[0].quality);
  }
}
