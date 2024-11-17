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

    private boolean sulfurasB(Item item) {
        return item.name.equals(Sulfuras);
    }
    private boolean agedBrieB(Item item) {
        return item.name.equals(AgedBrie);
    }
    private boolean backstagePassesB(Item item) {
        return item.name.equals(BackstagePasses);
    }
    
    private void increaseQuality(Item item) {
        if (item.quality < MaximumQuality) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellin--;
    }

    public void updateQuality() {
        for (int i =0; i < items.length; i++) {
            updateItemQuality(items[i]);
        }
    }

    private void updateItemQuality(Item item) {
        if(sulfurasB(item)) {
            return
        }
        decreaseSellIn(item);
        qualityType(item);
    }

    private void qualityType(Item item) {
        if (agedBrieB(item)) {
            updateAgedBrieQua(item);
            return;
        }

        if (backstagePassesB(item)) {
            updateBackPassQua(item);
            return;
        }
        
        regularQA(item);
    }

    private void regularQA(Item item) {
        decreaseQuality(item);
        if (item.sellin < 0) {
            decreaseQuality(item);
        }
    }

    private void updateAgedBrieQua(Item item) {
        increaseQuality(item);
        if(item.sellin < 0) {
            increaseQuality(item);
        }
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
