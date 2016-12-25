package Array1DStream;
import java.util.Arrays;

public class StreamArray {    
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7};
        int sum=Arrays.stream(a).reduce(0,(x,y)->x+y);
        System.out.println(sum);
        
        Arrays.stream(a).average().ifPresent(x->System.out.println(x));
        
        double x=Arrays.stream(a).summaryStatistics().getAverage();
        
        System.out.println(x);
    }
}
