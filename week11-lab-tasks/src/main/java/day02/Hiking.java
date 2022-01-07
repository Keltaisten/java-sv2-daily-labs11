package day02;

import java.util.List;

public class Hiking {
    public int getPlusElevation(List<Integer> heights){
        int sum = 0;
        int actualMax = heights.get(0);
        for(int actual = 0; actual < heights.size(); actual++){
            if(heights.get(actual) > actualMax) {
                sum += (heights.get(actual) - heights.get(actual - 1));
                actualMax = heights.get(actual);
            }
            else {
                actualMax = heights.get(actual);
            }
        }
        return sum;
    }
}
