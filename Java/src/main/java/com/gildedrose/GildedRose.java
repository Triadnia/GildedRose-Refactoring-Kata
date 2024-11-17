package com.gildedrose;

class GildedRose {
    Item[] items;
    private static final int MaximumQuality = 50;
    private static final int Backstage1 = 11;
    private static final int Backstage2 = 6;

    private static final String Sulfuras = "Sulfuras, Hand of Ragnaros";
    private static final String AgedBrie = "Aged Brie";
    private static final String BackstagePasses = "Backstage passes to a TAFKAL80ETC concert";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private boolean SulfurasB(Item item) {
        return item.name.equals(Sulfuras);
    }
    private boolean AgedBrieB(Item item) {
        return item.name.equals(AgedBrie);
    }
    private boolean BackstagePassesB(Item item) {
        return item.name.equals(BackstagePasses);
    }
    
    private void IncreaseQuality(Item item) {
        if (item.quality < MaximumQuality) {
            item.quality++;
        }
    }

    private void DecreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void DecreaseSellIn(Item item) {
        item.sellin--;
    }
    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < MaximumQuality) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < Backstage1) {
                            if (items[i].quality < MaximumQuality) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < Backstage2) {
                            if (items[i].quality < MaximumQuality) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < MaximumQuality) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
