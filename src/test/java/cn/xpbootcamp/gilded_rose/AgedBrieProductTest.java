package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class AgedBrieProductTest {
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

}
