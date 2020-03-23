package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AgedBrieItemCaseTest {

  @Test
  public void aged_brie_quality_increases_with_time() {
    Item[] items = new Item[]{new Item("Aged Brie", 1, 8)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(0, gildedRose.items[0].sellIn);
    assertEquals(9, gildedRose.items[0].quality);
  }

  @Test
  public void aged_brie_quality_increases_faster_after_sellin_date() {
    Item[] items = new Item[]{new Item("Aged Brie", 0, 8)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(-1, gildedRose.items[0].sellIn);
    assertEquals(10, gildedRose.items[0].quality);
  }

  @Test
  public void aged_brie_quality_never_above_max() {
    Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(4, gildedRose.items[0].sellIn);
    assertEquals(50, gildedRose.items[0].quality);
  }

  @Test
  public void aged_brie_name_must_be_precise() {
    Item[] items = new Item[]{new Item("Aged Brian", 5, 5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(4, gildedRose.items[0].sellIn);
    assertEquals(4, gildedRose.items[0].quality);
  }

}
