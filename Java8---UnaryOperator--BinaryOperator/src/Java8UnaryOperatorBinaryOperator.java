import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Java8UnaryOperatorBinaryOperator {
    public static void main(String[] args) {
        
        UnaryOperator<Integer> uo=i->i.intValue();
        System.out.println(uo.apply(12));
    
        BinaryOperator<Integer> bo=(p,q)-> Integer.sum(p,q);
        System.out.println(bo.apply(12,13));       
    }
}
