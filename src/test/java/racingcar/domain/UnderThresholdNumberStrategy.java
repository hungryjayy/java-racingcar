package racingcar.domain;

public class UnderThresholdNumberStrategy implements NumberCompareStrategy {
    @Override
    public boolean isSameOrOverThreshold(int threshold) {
        return false;
    }
}
