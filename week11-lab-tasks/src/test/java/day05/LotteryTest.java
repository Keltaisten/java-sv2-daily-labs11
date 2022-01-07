package day05;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    void startLotteryListSize() {
        Lottery lottery = new Lottery(99,5,new Random(1));
        assertEquals(5,lottery.startLottery().size());
    }

    @Test
    void startLotteryListFirstPart() {
        Lottery lottery = new Lottery(99,5,new Random(1));
        assertEquals(16,lottery.startLottery().get(0));
    }

    @Test
    void startLottery() {
        Lottery lottery = new Lottery(99,5,new Random(1));
        List<Integer> result = lottery.startLottery();
        for(int i = 0; i < result.size(); i++){
            assertFalse(result.subList(i+1,result.size()).contains(result.get(i)));
        }
    }
}