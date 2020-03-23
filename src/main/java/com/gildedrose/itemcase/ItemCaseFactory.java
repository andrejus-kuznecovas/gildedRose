package com.gildedrose.itemcase;

import com.gildedrose.configuration.ConfigData;
import com.gildedrose.itemcase.cases.nonlegendary.NormalItemCase;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class ItemCaseFactory {

  private static final Map<String, ItemCase> itemCaseMap = ConfigData.getItemCaseMap();

  private ItemCaseFactory() {
  } //Utility classes should not have public constructors

  public static ItemCase getItemCaseForItemName(String name) {
    Optional<ItemCase> itemCaseOptional = itemCaseMap.entrySet()
        .stream()
        .filter(entry -> name.startsWith(entry.getKey()))
        .findFirst()
        .map(Entry::getValue);

    return itemCaseOptional.isPresent() ? itemCaseOptional.get() : new NormalItemCase();
  }
}
