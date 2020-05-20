package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class GildedRoseTest {

    private static Product createProduct(String name, int sellIn, int quality) {
        return new Product(name, sellIn, quality);
    }

    private static Stream<ProductFixture> provideAgedBries() {
        return Stream.of(
                ProductFixture.createAgedBrie(2, 0, 1, 1),
                ProductFixture.createAgedBrie(2, 49, 1, 50),
                ProductFixture.createAgedBrie(2, 50, 1, 50),
                ProductFixture.createAgedBrie(0, 20, -1, 22),
                ProductFixture.createAgedBrie(-1, 20, -2, 22)
        );
    }

    private static Stream<ProductFixture> provideBackstagePass() {
        return Stream.of(
                ProductFixture.createBackstagePass(15, 20, 14, 21),
                ProductFixture.createBackstagePass(11, 20, 10, 21),
                ProductFixture.createBackstagePass(10, 45, 9, 47),
                ProductFixture.createBackstagePass(9, 45, 8, 47),
                ProductFixture.createBackstagePass(10, 49, 9, 50),
                ProductFixture.createBackstagePass(10, 50, 9, 50),
                ProductFixture.createBackstagePass(6, 45, 5, 47),
                ProductFixture.createBackstagePass(5, 45, 4, 48),
                ProductFixture.createBackstagePass(5, 49, 4, 50),
                ProductFixture.createBackstagePass(1, 20, 0, 23),
                ProductFixture.createBackstagePass(0, 20, -1, 0)
        );
    }

    private static Stream<ProductFixture> provideSulfuras() {
        return Stream.of(
                ProductFixture.createSulfuras(-1, 50, -1, 50),
                ProductFixture.createSulfuras(-1, 1, -1, 1),
                ProductFixture.createSulfuras(-2, 1, -2, 1),
                ProductFixture.createSulfuras(1, 1, 1, 1)
        );
    }

    private static Stream<ProductFixture> provideRegularProducts() {
        return Stream.of(
                ProductFixture.createRegular("+5 Dexterity Vest", 10, 20, 9, 19),
                ProductFixture.createRegular("Elixir of the Mongoose", 2, 0, 1, 0),
                ProductFixture.createRegular("Conjured Mana Cake", 3, 6, 2, 5),
                ProductFixture.createRegular("1664 Beer", 0, 6, -1, 4),
                ProductFixture.createRegular("1664 Beer", -1, 6, -2, 4)
        );
    }

    @ParameterizedTest
    @MethodSource({"provideAgedBries", "provideBackstagePass", "provideSulfuras", "provideRegularProducts"})
    void should_update_product_correctly(ProductFixture productFixture) {
        Product product = createProduct(productFixture.name, productFixture.sellIn, productFixture.quality);

        product.updateQualityandSellIn();

        Product expectedProduct = createProduct(productFixture.name, productFixture.updatedSellIn, productFixture.updatedQuality);
        assertThat(product.toString()).isEqualTo(expectedProduct.toString());
    }

    private static class ProductFixture {
        String name;
        int sellIn;
        int quality;
        int updatedSellIn;
        int updatedQuality;

        private ProductFixture(String name, int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            this.name = name;
            this.sellIn = sellIn;
            this.quality = quality;
            this.updatedSellIn = updatedSellIn;
            this.updatedQuality = updatedQuality;
        }

        public static ProductFixture createRegular(String name, int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            return new ProductFixture(name, sellIn, quality, updatedSellIn, updatedQuality);
        }

        public static ProductFixture createAgedBrie(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            return new ProductFixture("Aged Brie", sellIn, quality, updatedSellIn, updatedQuality);
        }

        public static ProductFixture createSulfuras(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            return new ProductFixture("Sulfuras, Hand of Ragnaros", sellIn, quality, updatedSellIn, updatedQuality);
        }

        public static ProductFixture createBackstagePass(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            return new ProductFixture("Backstage passes to a TAFKAL80ETC concert", sellIn, quality, updatedSellIn, updatedQuality);
        }
    }
}
