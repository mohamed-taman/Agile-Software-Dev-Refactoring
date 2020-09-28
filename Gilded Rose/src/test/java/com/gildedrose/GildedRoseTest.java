package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

  private final String FOO = "foo";

  private Item createAndUpdate(String name, int sellin, int quality) {
    Item[] items = new Item[] {new Item(name, sellin, quality)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    return items[0];
  }

  @Test
  void junitFrameworkWorks() {
    Item item = createAndUpdate(FOO, 0, 0);
    assertEquals(FOO, item.name);
  }

  @Test
  void systemLowersValues() {
    Item item = createAndUpdate(FOO, 15, 25);
    assertEquals(14, item.sellIn);
    assertEquals(24, item.quality);
  }

  @Test
  void qualityDegradesTwiceAsFast() {
    Item item = createAndUpdate(FOO, 0, 17);
    assertEquals(15, item.quality);
  }

  @Test
  void qualityIsNeverNegative() {
    Item item = createAndUpdate(FOO, 0, 0);
    assertEquals(0, item.quality);
  }

  @Test
  void agedBrieIncreasesInQuality() {
    Item item = createAndUpdate(AGED_BRIE, 15, 25);
    assertEquals(26, item.quality);
  }

  @Test
  void qualityNeverMoreThanMaximumQuality() {
    Item item = createAndUpdate(FOO, 15, 52);
    assertEquals(51, item.quality); // can exceed 50 if input exceeds 50

    item = createAndUpdate(AGED_BRIE, 15, MAXIMUM_QUALITY);
    assertEquals(MAXIMUM_QUALITY, item.quality);
  }

  @Test
  void sulfurasNeverHasToBeSoldOrDecreasesInQuality() {
    Item item = createAndUpdate(SULFURAS, 1, 42);
    assertEquals(1, item.sellIn); // sellIn doesn't change
    assertEquals(42, item.quality); // quality doesn't change
  }

  @Test
  void backstagePassesIncreaseInQuality() {
    Item item = createAndUpdate(BACKSTAGE_PASSES, 15, 25);
    assertEquals(26, item.quality);
  }

  @Test
  void backstagePassesIncreaseBy2() {
    Item item = createAndUpdate(BACKSTAGE_PASSES, 10, 25);
    assertEquals(27, item.quality);
  }

  @Test
  void backstagePassesIncreaseBy3() {
    Item item = createAndUpdate(BACKSTAGE_PASSES, 5, 25);
    assertEquals(28, item.quality);
  }

  @Test
  void backstagePassesQualityDropTo0() {
    Item item = createAndUpdate(BACKSTAGE_PASSES, 0, 25);
    assertEquals(0, item.quality);
  }

  @Test
  void agedBrieNeverExpires() {
    Item item = createAndUpdate(AGED_BRIE, 0, 42);
    assertEquals(-1, item.sellIn);
    assertEquals(44, item.quality);
  }

  @Test
  void backstagePassMaximumQuality() {
    Item item = createAndUpdate(BACKSTAGE_PASSES, 10, 48);
    assertEquals(MAXIMUM_QUALITY, item.quality);

    item = createAndUpdate(BACKSTAGE_PASSES, 10, 49);
    assertEquals(MAXIMUM_QUALITY, item.quality);

    item = createAndUpdate(BACKSTAGE_PASSES, 5, 49);
    assertEquals(MAXIMUM_QUALITY, item.quality);
  }

  @Test
  void degradeInQualityUnlessSulfuras() {
    Item item = createAndUpdate(FOO, -1, 1);
    assertEquals(0, item.quality);

    item = createAndUpdate(SULFURAS, -1, 1);
    assertEquals(1, item.quality);
  }

  @Test
  void agedBrieMaximumQuality() {
    Item item = createAndUpdate(AGED_BRIE, -1, 49);
    assertEquals(MAXIMUM_QUALITY, item.quality);
  }
}
