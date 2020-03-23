package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SulfurasItemCaseTest {

  @Test
  public void sulfuras_sellin_never_decreases() {
    Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(5, gildedRose.items[0].sellIn);
  }

  @Test
  public void sulfuras_quality_never_changes() {
    Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(80, gildedRose.items[0].quality);
  }
  
  @Test
  public void sulfuras_item_name_must_be_precise() {
    Item[] items = new Item[]{new Item("Sulfuras, Hand of The Lich King", 10, 40)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();

    assertEquals(9, gildedRose.items[0].sellIn);
    assertEquals(39, gildedRose.items[0].quality);
  }
}
