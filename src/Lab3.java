import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Lab3 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(7);

        System.out.println(mergeLists(list1, list2));



        Map<String, Integer> m = new HashMap<>();
        m.put("tolon", 30);
        m.put("daniyar", 25);
        m.put("alym", 35);
        displayMap(m);
    }

    public static <T> ArrayList<T> mergeLists(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> result = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        int i = 0;

        while (i < size1 || i < size2) {
            if (i < size1) {
                result.add(list1.get(i));
            }

            if (i < size2) {
                result.add(list2.get(i));
            }
            i++;
        }

        return result;
    }


    public static <K, V> void displayMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}