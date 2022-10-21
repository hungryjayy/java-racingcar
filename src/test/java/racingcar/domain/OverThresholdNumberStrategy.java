package racingcar.domain;

public class OverThresholdNumberStrategy implements NumberCompareStrategy {

    @Override
    public boolean isSameOrOverThreshold(int threshold) {
        return true;
    }
}
