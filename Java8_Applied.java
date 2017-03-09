import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class functionJava8 {
    public static void main(String[] args) {
 
//  ! --- Working With Functions --- !
    Function<String,String> getSecondLetter=(String s)->{
        return s==null?null:s.split(" ").length>1?s.split(" ")[1]:null;
    };
    
    Function<String,Integer> getLetterCount=(String s)->{
        return s.length();
    };
    
   // Integer count=getSecondLetter.andThen(getLetterCount).apply("");
   //System.out.println(count);
    
     Optional.ofNullable(getSecondLetter.apply("Jamia Millia")).map(getLetterCount).ifPresent(System.out::println);
      
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      Supplier<List<Integer>> listSupp=ArrayList<Integer>::new;
      List<Integer> ls=listSupp.get();
      
      ls.add(12);ls.add(33);ls.add(44);ls.add(32);ls.add(15);ls.add(62);ls.add(1);ls.add(2);
     
      //This is a Null Pointer Exception if List Object is Null and There is no Optional Class 
      //ls.stream().map(x->x/2).filter(y->y%2==0).forEach(System.out::print);
    
      
      Optional.ofNullable(ls.stream().map(x->x/2).filter(y->y%2==0)).get().forEach(entry->System.out.print(entry+"->"));
      
      //2nd Way Of Optional 
      List<Integer> ls1=null;
      Optional.ofNullable(ls1).orElseGet(ArrayList::new).stream().map(x->x/2).forEach(System.out::print);
      
      String str=null;
      //3rd way applying Optional to String Object
      String opt=Optional.ofNullable(str).orElseGet(String::new).concat("Hello Brother").toUpperCase();
      System.out.println("\n"+opt);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
    //   ! --  Working With Predicates  --  !
      Predicate<String> startsWithA = (String s) ->{
       return s.startsWith("A")?true:false;
      };
      
      Predicate<String> lengthMoreThan30=(String s)->{
          return s.length()>30?true:false;
      };
          
      Boolean knowMe=startsWithA.and(lengthMoreThan30.negate()).test("AmsterDam");
      System.out.println("\n"+knowMe);
        
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
      
// !--- Working With Consumer ----! 
      
      Consumer<String> getUpperCase=(String s)->System.out.println(s.toUpperCase());
      
      Consumer<String> getLength=(String s)->System.out.println(s.length());
      
      getUpperCase.andThen(getLength).accept("Jamia Millia Islamia");

 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      //!-- Using Grouping By    --!
      List<Employee> list;
         list = Arrays.asList(new Employee("Rahul","IT",6000),new Employee("Shyam","Admin",5000),new Employee("Kumar","IT",4400),new Employee("Jai","Admin",3300));
      
        Map<String, IntSummaryStatistics> collect = Optional.ofNullable(list).orElseGet(ArrayList::new).stream().
                collect(Collectors.groupingBy(emp->emp.getDept(),Collectors.summarizingInt(empl->empl.getSalary())));
      
        collect.forEach((k,v)->System.out.println(k+" -> "+v.getSum()));
      
        Map<String, Integer> collect1 = Optional.ofNullable(list).orElseGet(ArrayList::new).stream().
                collect(Collectors.groupingBy(emp->emp.getDept(),Collectors.summingInt(empl->empl.getSalary())));
      
        collect1.forEach((k,v)->System.out.println(k+" -> "+v));
    }
}
class Employee{
    
    private String name,dept;
    private Integer salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Employee(String name, String dept, Integer salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
    
}
