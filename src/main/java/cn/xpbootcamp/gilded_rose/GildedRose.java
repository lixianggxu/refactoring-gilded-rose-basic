package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Product product;

    public GildedRose(Product product) {
        this.product = product;
    }

    public void update_quality() {
        if (!product.name.equals("Aged Brie")
                && !product.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (product.quality > 0) {
                if (!product.name.equals("Sulfuras, Hand of Ragnaros")) {
                    product.quality = product.quality - 1;
                    }
                }
            } else {
            if (product.quality < 50) {
                product.quality = product.quality + 1;

                if (product.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (product.sellIn < 11) {
                        if (product.quality < 50) {
                            product.quality = product.quality + 1;
                            }
                        }

                    if (product.sellIn < 6) {
                        if (product.quality < 50) {
                            product.quality = product.quality + 1;
                            }
                        }
                    }
                }
            }

        if (!product.name.equals("Sulfuras, Hand of Ragnaros")) {
            product.sellIn = product.sellIn - 1;
            }

        if (product.sellIn < 0) {
            if (!product.name.equals("Aged Brie")) {
                if (!product.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (product.quality > 0) {
                        if (!product.name.equals("Sulfuras, Hand of Ragnaros")) {
                            product.quality = product.quality - 1;
                            }
                        }
                    } else {
                    product.quality = 0;
                    }
                } else {
                if (product.quality < 50) {
                    product.quality = product.quality + 1;
                    }
                }
            }
    }
}
