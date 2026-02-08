package baseball;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private Converter() {
    }

    public static List<Integer> toList(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (String s : input.split("")) {
            numbers.add(Integer.parseInt(s));
        }

        return numbers;
    }
}
