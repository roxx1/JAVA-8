import java.util.StringJoiner;

public class Java8StringJoiner {

    public static void main(String[] args) {
    StringJoiner s1=new StringJoiner("--");
    
    s1.add("RAM").add("Shyam").add("Krishna");
    
    StringJoiner s2=new StringJoiner("<->");
    s2.add("HAPPY").add("DIWALI").add("!!!");
    
    StringJoiner f=s1.merge(s2);
    
    System.out.println(f);
           
    }
}
