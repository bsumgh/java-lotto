package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void checkResult() {
        LottoTicket lottoTicket1 = new LottoTicket("1,2,3,4,5,6");
        LottoTicket lottoTicket2 = new LottoTicket("1,2,3,4,5,30");
        LottoTicket lottoTicket3 = new LottoTicket("1,2,3,4,7,8");
        LottoTicket lottoTicket4 = new LottoTicket("1,2,3,4,8,9");
        LottoTicket lottoTicket5 = new LottoTicket("1,2,7,8,9,10");
        List<LottoTicket> lottoTickets = new ArrayList<>(List.of(lottoTicket1, lottoTicket2, lottoTicket3, lottoTicket4, lottoTicket5));

        LottoTicket winningTicket = new LottoTicket("1,2,3,4,5,6");
        LottoNumber bonusNumber = new LottoNumber(30);

        LottoResult lottoResult = new LottoResult(lottoTickets, new LottoWinningTicket(winningTicket, bonusNumber));

        Assertions.assertAll(
                () -> assertThat(lottoResult.matchCount(LottoRank.FIRST)).isEqualTo(1),
                () -> assertThat(lottoResult.matchCount(LottoRank.SECOND)).isEqualTo(1),
                () -> assertThat(lottoResult.matchCount(LottoRank.FOURTH)).isEqualTo(2),
                () -> assertThat(lottoResult.matchCount(LottoRank.FIRST)).isEqualTo(1)
        );
    }
}