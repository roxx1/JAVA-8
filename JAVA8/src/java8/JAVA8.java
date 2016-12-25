
package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JAVA8 {

    public static void main(String[] args) {
          List<String> l=Arrays.asList("bbabc","ttdef","aghi");
          l.forEach(System.out::println);
        
         System.out.println("<<<<<------------------------------------>>>>>>"); 
         
         String s=l.stream().filter(x->x.startsWith("a")).collect(Collectors.joining("--"));
         System.out.println(s);
          
         Comparator<String> cc=new Comparator<String>() {

              @Override
              public int compare(String o1, String o2) {
                return o1.compareTo(o2);
              }
          };
         
         Collections.sort(l,cc);
         
         System.out.println(l);
         
    }
    
}
