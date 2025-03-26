import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;

public class Lab5 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Black");
        colors.add("Green");
        colors.add("Blue");
        System.out.println(colors);



        for (String color:colors){
            System.out.println(color);
        }



        colors.add(0, "Orange");
        System.out.println(colors);



        String color = colors.get(2);
        System.out.println(color);



        colors.set(2, "White");
        System.out.println(colors);



        colors.remove(2);
        System.out.println(colors);



        LinkedList<String> colors2 = new LinkedList<>();
        colors2.add("Black");
        colors2.add("Green");
        colors2.add("Blue");
        System.out.println(colors2);



        for (String color2 : colors2) {
            System.out.println(color2);
        }



        int startIndex = 1;
        for (; startIndex < colors2.size(); startIndex++) {
            System.out.println(colors2.get(startIndex));
        }



        Iterator<String> iterator = colors2.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }



        colors2.add(0, "Orange");
        System.out.println(colors);



        colors2.addFirst("Brown");
        colors2.addLast("Green");
        System.out.println(colors2);



        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Black");
        hashSet.add("Yellow");
        hashSet.add("Pink");

        System.out.println(hashSet);



        for (String colorH : hashSet) {
            System.out.println(colorH);
        }



        System.out.println(hashSet.size());



        hashSet.removeAll(hashSet);
        System.out.println("empty " + hashSet);



        if (hashSet.isEmpty()) {
            System.out.println("HashSet пуст.");
        } else {
            System.out.println("HashSet содержит элементы: " + hashSet);
        }



        hashSet.add("Black");
        hashSet.add("Yellow");
        hashSet.add("Pink");
        HashSet <String> newHashSet = new HashSet <>();
        newHashSet = (HashSet) hashSet.clone();
        System.out.println(newHashSet);



        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Black");
        treeSet.add("Yellow");
        treeSet.add("Pink");
        System.out.println(treeSet);



        for (String colorT : treeSet) {
            System.out.println(colorT);
        }



        TreeSet<String> treeSet2 = new TreeSet<>();
        treeSet2.add("Orange");
        treeSet2.add("White");
        treeSet2.add("Blue");
        treeSet.addAll(treeSet2);
        System.out.println(treeSet);



        Iterator iterator2 = treeSet.descendingIterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }



        String firstElement = treeSet.first();
        String lastElement = treeSet.last();
        System.out.println("Первый элемент: " + firstElement);
        System.out.println("Последний элемент: " + lastElement);



        TreeSet<String> newTreeSet = new TreeSet<>();
        newTreeSet = (TreeSet)treeSet.clone();
        System.out.println(newTreeSet);



        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Black");
        priorityQueue.add("Yellow");
        priorityQueue.add("Pink");
        System.out.println(priorityQueue);



        for (String colorQ : priorityQueue) {
            System.out.println(colorQ);
        }



        PriorityQueue<String> priorityQueue2 = new PriorityQueue<>(Arrays.asList("Orange", "White", "Blue"));
        priorityQueue.addAll(priorityQueue2);
        System.out.println(priorityQueue);



        priorityQueue.offer("Brown");
        System.out.println(priorityQueue);



        priorityQueue.clear();
        System.out.println(priorityQueue);



        System.out.println(priorityQueue2.size());



        HashMap<Integer, String> colorsHashMap = new HashMap<>();
        colorsHashMap.put(1, "Red");
        colorsHashMap.put(2, "Blue");
        colorsHashMap.put(3, "Green");
        System.out.println(colorsHashMap);



        System.out.println(colorsHashMap.size());



        HashMap<Integer, String> newColorsHashMap = new HashMap<>();
        newColorsHashMap.putAll(colorsHashMap);
        System.out.println(newColorsHashMap);



        colorsHashMap.clear();
        System.out.println(colorsHashMap);



        if (colorsHashMap.isEmpty()) {
            System.out.println("HashMap is empty.");
        }
        else {
            System.out.println(colorsHashMap);
        }



        HashMap<Integer, String> clonedMap = (HashMap) newColorsHashMap.clone();
        System.out.println("Cloned HashMap: " + clonedMap);



        TreeMap<Integer, String> treeMap = new TreeMap<>(Map.of(1, "Red", 2, "Blue", 3, "Green"));
        treeMap.put(1, "Yellow");
        System.out.println(treeMap);



        TreeMap<Integer, String> treeMap2 = new TreeMap<>();
        treeMap2.putAll(treeMap);
        System.out.println(treeMap2);



        if (treeMap.containsKey(2)) {
            System.out.println("TreeMap contains key: " + 2);
        } else {
            System.out.println("TreeMap does not contain key: " + 2);
        }



        if (treeMap.containsValue("Yellow")) {
            System.out.println("TreeMap contains value: Yellow");
        } else {
            System.out.println("TreeMap does not contain value: Yellow");
        }



        Set<Integer> keys = treeMap.keySet();
        System.out.println(keys);



        treeMap.clear();
        System.out.println(treeMap);
    }
}
