package cn.xpbootcamp.gilded_rose;

public class SulfurasProduct {


    private int sellIn;

    private int quality;

    public SulfurasProduct(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.sellIn + ", " + this.quality;
    }

}
