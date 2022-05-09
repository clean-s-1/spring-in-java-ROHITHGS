package statisticker;

import java.util.List;

public class Statistics 
{
    public static Stats getStatistics(List<Float> numbers) {
        if(numbers==null || numbers.isEmpty()){
            return new Stats(Float.NaN,Float.NaN,Float.NaN);
        }
        float avg = (float) numbers.stream().mapToDouble(num->num).average().getAsDouble();
        float max = (float) numbers.stream().mapToDouble(num->num).max().getAsDouble();
        float min = (float) numbers.stream().mapToDouble(num->num).min().getAsDouble();
       return new Stats(avg,max,min);
    }

    static class Stats {
        public float average;
        public float max;
        public float min;
        public Stats(float average, float max, float min) {
            this.average = average;
            this.max = max;
            this.min = min;
        }
    }
}
