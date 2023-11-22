package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.domain.LottoProfit;
import step2.domain.LottoResult;

import java.util.HashMap;
import java.util.Map;

class LottoProfitTest {

    @Test
    void profit() {

        Map<Integer, Integer> result = new HashMap<>();
        result.put(6, 0);
        result.put(5, 0);
        result.put(4, 0);
        result.put(3, 1);
        result.put(2, 0);
        result.put(1, 0);
        result.put(0, 0);

        LottoProfit lottoProfit = new LottoProfit();
        Assertions.assertThat(lottoProfit.profit(5000, new LottoResult(result))).isEqualTo(1.0);
    }
}