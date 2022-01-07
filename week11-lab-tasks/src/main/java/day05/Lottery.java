package day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    private int numbers;
    private int lotteryType;
    private Random random;

    public Lottery(int numbers, int lotteryType, Random random) {
        this.numbers = numbers;
        this.lotteryType = lotteryType;
        this.random = random;
    }

    public List<Integer> startLottery() {
        List<Integer> selectedNumbers = new ArrayList<>();
        int steps = lotteryType;
        for (int i = 0; i < steps; i++) {
            int number = random.nextInt(1, numbers + 1);
            if (!selectedNumbers.contains(number)){
                selectedNumbers.add(number);
            }
            else{
                steps++;
            }
        }
        return selectedNumbers;
    }
}
