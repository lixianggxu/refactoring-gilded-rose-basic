package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class BackstagePassProductTest {

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
}
