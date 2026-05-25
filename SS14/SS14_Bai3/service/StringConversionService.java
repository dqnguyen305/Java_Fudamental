package SS14_Bai3.service;

import java.util.ArrayList;
import java.util.List;

public class StringConversionService {
    private final List<Integer> validNumbers = new ArrayList<>();
    private int invalidCount = 0;

    public void processString(String input) {
        try {
            int number = Integer.parseInt(input);
            validNumbers.add(number);
        } catch (NumberFormatException e) {
            invalidCount++;
        }
    }

    public List<Integer> getValidNumbers() {
        return validNumbers;
    }

    public int getValidCount() {
        return validNumbers.size();
    }

    public int getInvalidCount() {
        return invalidCount;
    }
}