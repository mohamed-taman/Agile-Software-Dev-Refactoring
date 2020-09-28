package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MAXIMUM_QUALITY = 50;
    public static final int BACKSTAGE_PASS_THRESHOLD1 = 11;
    public static final int BACKSTAGE_PASS_THRESHOLD2 = 6;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            final Item item = items[i];
            if (!isAgedBrie(item)
                    && !isBackstagePasses(item)) {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        item.quality--;
                    }
                }
            } else {
                if (item.quality < MAXIMUM_QUALITY) {
                    item.quality++;

                    if (isBackstagePasses(item)) {
                        if (item.sellIn < BACKSTAGE_PASS_THRESHOLD1) {
                            if (item.quality < MAXIMUM_QUALITY) {
                                item.quality++;
                            }
                        }

                        if (item.sellIn < BACKSTAGE_PASS_THRESHOLD2) {
                            if (item.quality < MAXIMUM_QUALITY) {
                                item.quality++;
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(item)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePasses(item)) {
                        if (item.quality > 0) {
                            if (!isSulfuras(item)) {
                                item.quality--;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < MAXIMUM_QUALITY) {
                        item.quality++;
                    }
                }
            }
        }
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }
}