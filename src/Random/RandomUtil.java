package Random;

public class RandomUtil {
    public static int randomizer(int minValue, int maxValue) {
        maxValue -= minValue;
        return (int) (Math.random() * ++(maxValue)) + minValue;
    }
}