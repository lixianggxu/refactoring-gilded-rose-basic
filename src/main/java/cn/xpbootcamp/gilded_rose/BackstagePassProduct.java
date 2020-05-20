package cn.xpbootcamp.gilded_rose;

public class BackstagePassProduct {


    private int sellIn;

    private int quality;

    public BackstagePassProduct(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.sellIn + ", " + this.quality;
    }

    public void oneDayPass() {
        oneDayPassBeforPerformance();
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            quality = 0;
        }

    }

    private void oneDayPassBeforPerformance() {
        if (quality < 50) {
            quality = quality + 1;
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


}
