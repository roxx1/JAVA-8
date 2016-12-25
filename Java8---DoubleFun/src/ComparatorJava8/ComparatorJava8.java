package ComparatorJava8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person implements Comparable<Person>{
    private int id;
    private String name;
    
    @Override
    public int compareTo(Person p) {
    return this.getName().compareToIgnoreCase(p.getName());
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}

public class ComparatorJava8 {
    public static void main(String[] args) {
     
        List<Person> ls=new ArrayList<>();
        ls.add(new Person(12,"Madhur"));
        ls.add(new Person(64,"Champa"));
        ls.add(new Person(44,"KAPPU"));
        ls.add(new Person(15,"Tappu"));
        ls.add(new Person(72,"Rajiv"));
        
        Comparator<Person> comp1=Comparator.naturalOrder();
        Comparator<Person> comp2=comp1.thenComparing(x->x.getId());
        ls.stream().sorted(comp2).forEach(per->System.out.println(per.getId()+"   "+per.getName()));    
    }
}
