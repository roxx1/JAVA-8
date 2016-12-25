package java8.fun;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Java8Fun {

    static void printData(List<Person> ls,MyCondition condition){
              
    }
    
    public static void main(String[] args) {
        
        List<Person> ls=Arrays.asList(new Person(2,"Rakesh","Kumar"),new Person(22,"Raja","Mohan"),new Person(42,"Shiv","Gopal"));
        
        Collections.sort(ls,(p1,p2)->p1.lastName.compareTo(p2.lastName));
        
        ls.stream().forEach(x->System.out.println(x.id+"   "+x.firstName+"   "+x.lastName));
       
        printData(ls,()->true);
        
    }
    
}


class Person{
    int id;
    String firstName,lastName;

    Person(int id, String firstName, String lastName) {
       this.id=id;
       this.firstName=firstName;
       this.lastName=lastName;
    }
    
}