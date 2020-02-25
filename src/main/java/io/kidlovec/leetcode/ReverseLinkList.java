package io.kidlovec.leetcode;

import java.util.*;


/**
 * TODO description
 *
 * @author kidlovec
 * @date 2019-11-07
 * @since v1.0.0
 */
public class ReverseLinkList {

    public static void main(String[] args) {

        LinkedList<Integer> list = initList();

        LinkedList<Integer> reversedList = reverse(list);

        System.out.println(reversedList);
    }

    private static LinkedList<Integer> reverse(LinkedList<Integer> list) {

        Integer[] reL = new Integer[list.size()];

        int size = list.size();

        Iterator<Integer> integerIterator = list.descendingIterator();
//        for (int i = 0; i < size / 2; i++) {
//            Integer first = list.removeFirst();
//            Integer last = list.removeLast();
//            reL[i]= last;
//            reL[size - 1 - i]= first;
//        }
//
//        if (size % 2 !=0){
//            reL[size / 2 ] = list.removeFirst();
//        }

        int i = 0;
        while (integerIterator.hasNext()){
            reL[i++] = integerIterator.next();
        }
        return new LinkedList<>(Arrays.asList(reL));

    }

    private static LinkedList<Integer>  initList() {
        LinkedList<Integer> list = new LinkedList<>();

        int size = 21;
        for (int i = 0; i < size; i++) {

            list.add(i);
        }

        System.out.println(list);

        return list;
    }
}
