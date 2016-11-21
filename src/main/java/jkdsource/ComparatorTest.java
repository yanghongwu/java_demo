package jkdsource;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yhw on 11/21/2016.
 */
public class ComparatorTest {
    public static void main(String[] args) {
        String s = "100,10,1,0,15,20,23,45,67,88,66,44,6,2,89,342,232,33,22,221,66,67,78,788,46,76,65,54,43,32,765,88,87,86,89,83,82,83,832,182,184,186";
        String[] strArr = s.split(",");
        Arrays.sort(strArr, new com1());
        for(String str : strArr){
            System.out.print(str+",");
        }
    
}

class com1<T> implements Comparator<T> {
    public int compare(T o1, T o2) {
        int i = Integer.parseInt(String.valueOf(o1));
        int j = Integer.parseInt(String.valueOf(o2));
        if (i > j) return 1;
        if (i < j) return -1;
        return 0;
    }
}