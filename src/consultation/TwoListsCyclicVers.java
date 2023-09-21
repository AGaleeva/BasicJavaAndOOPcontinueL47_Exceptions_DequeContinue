package consultation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class TwoListsCyclicVers {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(List.of("aa", "bb", "cc", "dd"));
//        List<String> list2 = new ArrayList<>(List.of("dd", "cc", "bb", "aa"));
//        List<String> list2 = new ArrayList<>(List.of("dd", "aa", "bb", "cc"));
        List<String> list2 = new ArrayList<>(List.of("cc", "dd", "aa", "bb"));
//        List<String> list2 = new ArrayList<>(List.of("bb", "cc", "dd", "aa"));
        List<String> list3 = new ArrayList<>(List.of("dd", "ee", "ff"));
        List<String> list4 = new ArrayList<>(List.of("dd", "ff", "ee"));

        System.out.println(isTwoListsCyclicVers(list1, list2));
        System.out.println(isTwoListsCyclicVers(list3, list4));
    }

    public static boolean isTwoListsCyclicVers(List<String> list1, List<String> list2) {
        if (list1 == null || list2 == null || list1.size() != list2.size()) {
            return false;
        }

        List<String> cyclicList = new LinkedList<>();
        cyclicList.add(list1.get(list1.size() - 1));
        for (int i = 0; i < list1.size() - 1; i++) {
            cyclicList.add(list1.get(i));
        }

        for (int i = 0; i < cyclicList.size() - 1; i++) {
            if (cyclicList.equals(list2)) {
                return true;
            }
            for (int j = 0; j < cyclicList.size() - 1; j++) {
                int l = cyclicList.size() - 1 - j;
                cyclicList.add(j, cyclicList.remove(l));
            }
        }
        return false;
    }
}
