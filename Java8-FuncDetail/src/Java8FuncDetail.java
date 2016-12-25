import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.ToIntFunction;

public class Java8FuncDetail {
    public static void main(String[] args) {
        
        Function<Integer,Integer> f=x->x+5;
        System.out.println(f.apply(3));
    
        IntFunction<Integer> u=x->x+5;
        System.out.println(u.apply(4));
        
        ToIntFunction<Integer> fp=x->x+5;
        System.out.println(fp.applyAsInt(6));
               
        IntToLongFunction lp=x->x+5;
        System.out.println(lp.applyAsLong(5)); 
    }    
}
