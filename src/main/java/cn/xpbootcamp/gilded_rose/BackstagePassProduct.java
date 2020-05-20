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
        sellIn -= 1;
        if (sellIn < 0) quality = 0;

    }

    private void oneDayPassBeforPerformance() {
        quality += 1;
        if (sellIn < 11) quality += 1;
        if (sellIn < 6) quality++;
        quality = Math.min(50, quality);
    }


}
