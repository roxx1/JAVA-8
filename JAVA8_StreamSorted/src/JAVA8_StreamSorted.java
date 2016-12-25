import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student implements Comparable<Student>{
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public int compareTo(Student o) {
     return this.name.compareTo(o.name);
    }
}

public class JAVA8_StreamSorted {

    public static void main(String[] args) {
        List<Student> ls=Arrays.asList(new Student(22,"MAHESH",57),new Student(42,"RAM",17),new Student(20,"KUMAR",44),new Student(62,"LAXMAN",63));
        System.out.println("BEFORE COMPARING NAME-----"); 
        ls.stream().forEach(e->System.out.print(e.name+"  "));
        
       System.out.println("\nAfter COMPARING NAME-----");
       List<Student> nn= ls.stream().sorted().collect(Collectors.toList());
       nn.stream().forEach(e->System.out.print(e.name+"  "));
       
       System.out.println("\nAfter COMPARING NAME BUT WITH COMPARATOR-----");
       ls.stream().sorted(Comparator.comparing(Student::getAge)).forEach(e->System.out.print(e.name+"   "));
       
       
        System.out.println("\nMAP VALUES BEFORE SORTING");
       Map<Integer,Student> mm=new HashMap<>();
       mm.put(1,new Student(22,"MAHESH",57));
       mm.put(2,new Student(42,"RAM",17));
       mm.put(3,new Student(20,"KUMAR",44));
       mm.put(4,new Student(62,"LAXMAN",63));
       
        System.out.println("\nBEFORE MAP SORTING");
       mm.entrySet().stream().forEach(e->System.out.println(e.getKey()+"    "+e.getValue().getName()));
       
       System.out.println("\nAFTER DEFAULT SORTING IN MAP ");
       mm.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(e-> System.out.println(e.getKey()+"   "+e.getValue().getName()+"   "+e.getValue().getAge()));

       int[] a={9,8,7,6,5,4,3,2,1};
        System.out.println("\nARRAY---->");
        Arrays.stream(a).map(x->2*x).filter(z->z%2==0&&z/4==0).forEach(System.out::println);
 
      System.out.println("\nARRAY TO MAP---->");
      
      List<Employee> mp=Arrays.asList(new Employee(62,"laksh"),new Employee(92,"tinny"),new Employee(32,"jam"));
      Map<Integer,String> map=mp.stream().collect(Collectors.toMap(e->e.eid,e->e.name));
     
      map.entrySet().stream().forEach(e->System.out.println(e.getKey()+"   "+e.getValue()));

     
      
      
      
      
      
    }    
}

class Employee{

    int eid;
    String name;

    public Employee(int eid, String name) {
        this.eid = eid;
        this.name = name;
    }
    
}