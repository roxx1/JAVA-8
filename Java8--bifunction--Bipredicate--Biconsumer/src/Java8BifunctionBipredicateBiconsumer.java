import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Java8BifunctionBipredicateBiconsumer {
    public static void main(String[] args) {
 
    BiConsumer<Integer,String> bc=(key,value)->System.out.println(key+"   "+value);
    bc.accept(12,"hello");
   
    BiPredicate<Integer,String> bp=(i,s)->i>2&&s.startsWith("a");     
    boolean b= bp.test(11,"amsterdam");
    System.out.println(b);
            
     BiFunction<Integer,Integer,String> bf=(i,j)->"Result--->"+(i+j);   
     String s=bf.apply(12,13);
     System.out.println(s);   
    
    }    
}
