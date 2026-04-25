package pl.pjatk.s36691.gui.zad34;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Supplier<Integer> number = () -> (int) (Math.random() * 100 + 1);

        List<Integer> numberList = Stream
                .generate(number)
                .limit(100)
                .toList();
        System.out.println(numberList);

        Map<Integer, Long> counter = numberList.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        System.out.println(counter);
    }

}
