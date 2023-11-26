package step2;

import step2.domain.*;
import step2.view.ResultView;
import step2.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        int ticketMoney = new InputView().readIntInput("구입금액을 입력해 주세요.");

        int manualCount = new InputView().readIntInput("수동으로 구매할 로또 수를 입력해 주세요.");
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottoTickets.add(new LottoTicket(new InputView().readStringInput("수동으로 구매할 번호를 입력해 주세요.")));
        }

        int autoCount = ticketMoney/LottoIssuer.BASE_MONEY - manualCount;
        ResultView.printLottoCountNum(manualCount, autoCount);

        List<LottoTicket> lottoTickets = new LottoIssuer().issueTickets(autoCount);
        lottoTickets.addAll(manualLottoTickets);

        ResultView.printLottoTickets(lottoTickets);

        LottoTicket winningTicket = new LottoTicket(new InputView().readStringInput("지난 주 당첨 번호를 입력해 주세요."));
        LottoNumber bonusNumber = new LottoNumber(new InputView().readIntInput("보너스 볼을 입력해 주세요."));
        LottoResult lottoResult = new LottoResult(lottoTickets, new LottoWinningTicket(winningTicket, bonusNumber));

        ResultView.printLottoResult(ticketMoney, lottoResult);
    }
}
