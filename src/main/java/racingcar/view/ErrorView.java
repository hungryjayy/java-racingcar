package racingcar.view;

public class ErrorView {

    private static final String UNEXPECTED_TERMINATION_EXCEPTION = "예상치 못한 오류로 게임이 종료됩니다.";

    public static void printGameAbnormalTermination() {
        System.out.println(UNEXPECTED_TERMINATION_EXCEPTION);
    }

    public static void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
