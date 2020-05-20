package cn.xpbootcamp.gilded_rose;

public class AgedBrieProduct {


    private int sellIn;

    private int quality;

    public AgedBrieProduct(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.sellIn + ", " + this.quality;
    }

    public void oneDayPass() {
        sellIn = sellIn - 1;

        if (quality < 50) {
            quality = quality + 1;
        }
        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }
}
