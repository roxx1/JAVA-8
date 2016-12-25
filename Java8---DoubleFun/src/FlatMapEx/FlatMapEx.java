package FlatMapEx;

import java.util.Arrays;

public class FlatMapEx {

    public static void main(String[] args) {
        Integer arr[][]={{1,2,3},{4,5,6},{7,8,9}};
            
        Arrays.stream(arr).flatMap(row->Arrays.stream(row)).forEach(x->System.out.print(x+"  ->"));
    
    }

}
