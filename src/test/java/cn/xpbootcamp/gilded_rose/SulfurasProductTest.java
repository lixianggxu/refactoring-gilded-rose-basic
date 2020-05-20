package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class SulfurasProductTest {

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
}
