package MyList;

import Interface.GBLinkedLists;
import Interface.GBList;

public class Main {
    public static void main(String[] args) {
        GBList<Number> gbList = new GBArrayList<>();
        gbList.add(1);
        gbList.add(3.1415926);
        gbList.join(1).join(2).join(3);
        System.out.println(gbList);
        gbList.update(0, 1.213213f);
        System.out.println(gbList.size());

        GBLinkedLists<Number> gbLinkedList = new GBLinkedList<>();
        System.out.println(gbLinkedList);
        gbLinkedList.addFirst(1);
        System.out.println(gbLinkedList);
        gbLinkedList.addFirst(2);
        gbLinkedList.addFirst(3);
        gbLinkedList.addLast(4);
        System.out.println(gbLinkedList);
        System.out.println(gbLinkedList.get(1) + " " + gbLinkedList.size());
    }
}
