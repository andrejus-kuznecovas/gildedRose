package com.gildedrose.configuration;

import com.gildedrose.itemcase.ItemCase;
import com.gildedrose.itemcase.cases.legendary.SulfurasItemCase;
import com.gildedrose.itemcase.cases.nonlegendary.AgedBrieItemCase;
import com.gildedrose.itemcase.cases.nonlegendary.BackstagePassItemCase;
import com.gildedrose.itemcase.cases.nonlegendary.ConjuredItemCase;
import java.util.Map;

public class ConfigData {

  private ConfigData() {
  } //Utility classes should not have public constructors

  public static final int NORMAL_SELLIN_VALUE = 1;
  public static final int NON_EXPIRED_ITEM_DECAY_VALUE = 1;
  public static final int EXPIRED_ITEM_DECAY_VALUE = 2;
  public static final int CONJURED_ITEM_DECAY_VALUE = 2;
  public static final int ITEM_QUALITY_MAX_VALUE = 50;
  public static final int ITEM_QUALITY_MIN_VALUE = 0;

  public static final int LEGENDARY_SULFURAS_QUALITY = 80;

  private static final Map<String, ItemCase> ITEM_CASE_MAP = Map.ofEntries(
      Map.entry("Aged Brie", new AgedBrieItemCase()),
      Map.entry("Sulfuras, Hand of Ragnaros", new SulfurasItemCase()),
      Map.entry("Backstage passes", new BackstagePassItemCase()),
      Map.entry("Conjured", new ConjuredItemCase())
  );

  public static Map<String, ItemCase> getItemCaseMap() {
    return ITEM_CASE_MAP;
  }
}
