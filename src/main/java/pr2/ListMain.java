package pr2;

import java.util.Arrays;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        MyPlainArrList<String> list = new MyPlainArrList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");

        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.get(8));
        list.addFirst("5");
        list.addFirst("4");
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");
        list.addFirst("0");

        System.out.println(Arrays.toString(list.toArray()));
        list.addLast("last");
        list.addLast("lastTWO");
        list.addLast("lastTHREE");
        list.addLast("last4");
        list.addLast("last5");
        list.addLast("last6");
        list.addLast("last7");

        System.out.println(Arrays.toString(list.toArray()));
        List vivod = list.toArraylistss();
        System.out.println(vivod);

        System.out.println(list.get(0));
        System.out.println(list.indexOf("0"));
        System.out.println("Iterator");
        for(Object object:list){
            System.out.println(object);
        }
        list.remove("a");
        System.out.println(Arrays.toString(list.toArray()));
        list.removeAll(List.of("b","c","d","e"));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.contains("f"));
        list.addAll(List.of("b","c","d","e"));
        System.out.println(Arrays.toString(list.toArray()));
        list.clear();
        System.out.println(Arrays.toString(list.toArray()));

    }
}
