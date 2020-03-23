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

  @Test
  public void conjured_items_quality_never_negative() {
    Item[] items = new Item[]{new Item("Conjured Kiwi", 0, 3)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(-1, gildedRose.items[0].sellIn);
    assertEquals(0, gildedRose.items[0].quality);
  }

  @Test
  public void conjured_items_quality_never_above_max() {
    Item[] items = new Item[]{new Item("Conjured Tic-Tac", 10, 80)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(9, gildedRose.items[0].sellIn);
    assertEquals(50, gildedRose.items[0].quality);
  }
}
