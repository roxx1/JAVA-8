
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;


public class Java8OptionalClass {

    public static void main(String[] args) {
        
    Optional<Student> op= Optional.of(new Student("Ram"));
    Consumer<Student> c=(s)->System.out.println(s.name=="shyam"); 
    op.ifPresent(c);
    
    op.map(x->x.name).ifPresent(y->System.out.println(y.equals("Ram")));
 
    }
}


class Student{
    String name;

    public Student(String name) {
        this.name = name;
    }
    
}