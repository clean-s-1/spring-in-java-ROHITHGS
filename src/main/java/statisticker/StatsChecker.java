package statisticker;

import java.util.Arrays;

public class StatsChecker {
    private float maxThreshold;
    private IAlerter[] alerters;
    public StatsChecker(float maxThreshold, IAlerter[] alerters) {
            this.maxThreshold = maxThreshold;
            this.alerters=alerters;
    }

    public void checkAndAlert(Float[] numbers) {
        Statistics.Stats s = Statistics.getStatistics(Arrays.asList(numbers));
        float max = s.max;
        if(maxThreshold<max){
            for(IAlerter x : alerters) {
                if (x instanceof EmailAlert) {
                    ((EmailAlert) x).emailSent = true;
                }
                if (x instanceof LEDAlert) {
                    ((LEDAlert) x).ledGlows = true;
                }
            }
        }

    }
}
