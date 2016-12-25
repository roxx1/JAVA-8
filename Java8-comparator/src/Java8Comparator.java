import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Comparator {
    public static void main(String[] args) {
        
   List<Student> ls=Arrays.asList(new Student(31,"Ramu"),new Student(5,"Kaku"),new Student(71,"tinu"),new Student(2,"Anu"),new Student(11,"bablu"));
   ls.stream().sorted(Comparator.naturalOrder()).forEach(x->System.out.println(x));
   Comparator<Student> idComp=Comparator.comparing(x->x.id);
   Comparator<Student> nameComp=Comparator.naturalOrder();
   Comparator<Student> myComp=idComp.thenComparing(nameComp);
        
   Map<Integer,String> mp=ls.parallelStream().sorted(myComp).collect(Collectors.toMap(x->x.id,x->x.name));   
   mp.entrySet().stream().forEach(entry->System.out.println(entry.getKey()+"  "+entry.getValue()));
        
  }    
}

class Student implements Comparable<Student>{
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public int compareTo(Student o) {
     return name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + '}';
    }
}