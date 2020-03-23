package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BackstagePassItemCaseTest {

  @Test
  public void backstage_pass_quality_increases_slow_long_before_concert() {
    Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 20, 5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(19, gildedRose.items[0].sellIn);
    assertEquals(6, gildedRose.items[0].quality);
  }

  @Test
  public void backstage_pass_quality_increases_medium_before_concert() {
    Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 7, 5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(6, gildedRose.items[0].sellIn);
    assertEquals(7, gildedRose.items[0].quality);
  }

  @Test
  public void backstage_pass_quality_increases_quick_just_before_concert() {
    Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(4, gildedRose.items[0].sellIn);
    assertEquals(8, gildedRose.items[0].quality);
  }

  @Test
  public void backstage_pass_quality_is_zero_after_concert() {
    Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(-1, gildedRose.items[0].sellIn);
    assertEquals(0, gildedRose.items[0].quality);
  }

  @Test
  public void backstage_pass_quality_never_below_min() {
    Item[] items = new Item[]{new Item("Backstage passes to a Song-hammer concert", 2, -5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(1, gildedRose.items[0].sellIn);
    assertEquals(0, gildedRose.items[0].quality);
  }

  @Test
  public void backstage_pass_quality_never_above_max() {
    Item[] items = new Item[]{new Item("Backstage passes to a Song-hammer concert", 2, 60)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(1, gildedRose.items[0].sellIn);
    assertEquals(50, gildedRose.items[0].quality);
  }
}
