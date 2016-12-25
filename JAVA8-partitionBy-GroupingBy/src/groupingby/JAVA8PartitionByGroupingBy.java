package groupingby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JAVA8PartitionByGroupingBy {
    public static void main(String[] args) {
             
   List<Student> ls=Arrays.asList(new Student(31,"Ramu"),new Student(5,"Kaku"),new Student(71,"tinu"),new Student(2,"Anu"),new Student(11,"bablu"));
   
   Map<Boolean,List<Student>> m=ls.parallelStream().collect(Collectors.partitioningBy(s->s.id>12));
   
   m.entrySet().stream().filter(x->x.getKey().toString().equals("true"))
           .forEach(entry->System.out.println(entry.getKey()+"<-->"+entry.getValue().stream().map(s->s.name)
           .collect(Collectors.joining(","))
           ));
              
   
   List<Student> lg=Arrays.asList(new Student(31,"Ramu"),new Student(35,"Kaku"),new Student(71,"tinu"),new Student(31,"Anu"),new Student(35,"bablu"),new Student(71,"kalu"),new Student(35,"chunu"),new Student(56,"kumar"));
   
   Map<Integer,List<Student>>  mm=lg.parallelStream().collect(Collectors.groupingBy(item->item.id));
   
   mm.entrySet().parallelStream().filter(k->!k.getKey().equals(56))
           .forEach(entry->System.out.println(entry.getKey()+"   "+entry.getValue().stream()
           .map(st->st.name)
           .collect(Collectors.joining(","))));
   
   
   
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