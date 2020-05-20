package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class GildedRoseTest {

    private static Product createProduct(String name, int sellIn, int quality) {
        return new Product(name, sellIn, quality);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    " 2, 0, 1, 1",
                    " 2, 49, 1, 50",
                    " 2, 50, 1, 50",
                    " 0, 20, -1, 22",
                    " -1, 20, -2, 22",
            }
    )
    void should_update_sellIn_and_quatity_when_one_day_pass_given_aged_brieds_product(int sellIn, int quanlity, int updateSellIn, int updateQuanlity) {
        AgedBrieProduct agedBrieProduct = new AgedBrieProduct(sellIn, quanlity);
        agedBrieProduct.oneDayPass();
        AgedBrieProduct expectedagedBrieProduct = new AgedBrieProduct(updateSellIn, updateQuanlity);
        assertThat(expectedagedBrieProduct.toString()).isEqualTo(agedBrieProduct.toString());

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


    @ParameterizedTest
    @CsvSource(
            {
                    "-1,50, -1, 50",
                    "-1, 1, -1, 1",
                    "-2, 1, -2, 1",
                    "1, 1, 1, 1",
            }
    )
    void should_update_sellIn_and_quatity_when_one_day_pass_given_surfras_product(int sellIn, int quanlity, int updateSellIn, int updateQuanlity) {
        SulfurasProduct sulfurasProduct = new SulfurasProduct(sellIn, quanlity);
        SulfurasProduct expectedSulfurasProduct = new SulfurasProduct(updateSellIn, updateQuanlity);
        assertThat(sulfurasProduct.toString()).isEqualTo(expectedSulfurasProduct.toString());

    }


    @ParameterizedTest
    @CsvSource(
            {
                    " 10, 20, 9, 19",
                    " 2, 0, 1, 0",
                    " 3, 6, 2, 5",
                    " 0, 6, -1, 4",
                    " -1, 6, -2, 4",
            }
    )
    void should_update_sellIn_and_quatity_when_one_day_pass_given_common_product(int sellIn, int quanlity, int updateSellIn, int updateQuanlity) {
        CommonProduct commonProduct = new CommonProduct(sellIn, quanlity);
        commonProduct.oneDayPass();
        CommonProduct expectedCommonProduct = new CommonProduct(updateSellIn, updateQuanlity);
        assertThat(commonProduct.toString()).isEqualTo(expectedCommonProduct.toString());

    }

    @ParameterizedTest
    @MethodSource({"provideBackstagePass",})
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


        public static ProductFixture createBackstagePass(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            return new ProductFixture("Backstage passes to a TAFKAL80ETC concert", sellIn, quality, updatedSellIn, updatedQuality);
        }
    }
}
