package cn.xpbootcamp.gilded_rose;

public class CommonProduct {


    private int sellIn;

    private int quality;

    public CommonProduct(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.sellIn + ", " + this.quality;
    }

    public void oneDayPass() {
        sellIn--;
        quality -= 1;
        if (sellIn < 0) quality -= 1;
        if (quality < 0) quality = 0;
    }
}
