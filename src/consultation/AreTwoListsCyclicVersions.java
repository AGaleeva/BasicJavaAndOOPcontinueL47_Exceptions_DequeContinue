package consultation;

import java.util.*;

public class AreTwoListsCyclicVersions {
    /*
    Есть два списка с буквами. Определить, является один список циклической версией другого. Например, для списков:
    {aa, bb, cc, dd} и {cc, dd, aa, bb} -> true,
    {dd, ee, ff} и {dd, ff, ee} -> false.
    */
    public static void main(String[] args) {
        List<String> list1 = List.of("1", "2", "3");
        List<String> list2 = List.of("2", "1", "3");

        System.out.println(isSequenceCyclicVersionOfAnother(list1, list2));
    }

    public static boolean isSequenceCyclicVersionOfAnother(List<String> list1, List<String> list2) {
        if (list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty() || list1.size() != list2.size()) return false;

        Deque<String> queue1 = new LinkedList<>(list1);
        Deque<String> queue2 = new LinkedList<>(list2);

        for (int i = 0; i < list1.size() - 1; i++) {
            queue1.addFirst(queue1.removeLast());
            if (queue1.equals(queue2)) {
                return true;
            }
        }
        return false;
    }
}
