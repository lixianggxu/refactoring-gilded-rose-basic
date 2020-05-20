package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class CommonProductTest {

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
