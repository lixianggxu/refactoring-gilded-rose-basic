package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class GildedRoseTest {
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

    @ParameterizedTest
    @CsvSource(
            {
                    "15, 20, 14, 21",
                    "11, 20, 10, 21",
                    "10, 45, 9, 47",
                    "9, 45, 8, 47",
                    "10, 49, 9, 50",
                    "10, 50, 9, 50",
                    "6, 45, 5, 47",
                    "5, 45, 4, 48",
                    "5, 49, 4, 50",
                    "1, 20, 0, 23",
                    "0, 20, -1, 0",
            }
    )
    void should_update_sellIn_and_quatity_when_one_day_pass_given_backstage_pass_product(int sellIn, int quanlity, int updateSellIn, int updateQuanlity) {
        BackstagePassProduct backstagePassProduct = new BackstagePassProduct(sellIn, quanlity);
        backstagePassProduct.oneDayPass();
        BackstagePassProduct expectedBackstagePassProduct = new BackstagePassProduct(updateSellIn, updateQuanlity);
        assertThat(backstagePassProduct.toString()).isEqualTo(expectedBackstagePassProduct.toString());

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
}
