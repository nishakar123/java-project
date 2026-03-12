package test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentElementFromList {
    static void main() {
        /*["apple", "banana", "apple", "orange", "banana", "apple"]
        k = 2
        Output:
        ["apple", "banana"]*/
        int k = 2;
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        map.entrySet().stream().limit(k).forEach(System.out::println);

        /*int limit = 0;
        Set<String> set = map.keySet();
        for (String key : set) {
            if(limit >= k) break;
            limit = limit + 1;
            System.out.println(key);
        }*/
    }
}
