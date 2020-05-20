package cn.xpbootcamp.gilded_rose;

public class Product {

    private String name;

    private int sellIn;

    private int quality;

    public Product(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQualityandSellIn() {
        if (!name.equals("Aged Brie")
                && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (quality > 0) {
                if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    oneDayPassBackstagePasses();
                }
            }
        }

        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            updateSellInExceptSufuras();
        }

        if (sellIn < 0) {
            if (!name.equals("Aged Brie")) {
                if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (quality > 0) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                            quality = quality - 1;
                        }
                    }
                } else {
                    quality = 0;
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
    }

    private void updateSellInExceptSufuras() {
        sellIn = sellIn - 1;
    }

    private void oneDayPassBackstagePasses() {
        if (sellIn < 11) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }

        if (sellIn < 6) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }
}
