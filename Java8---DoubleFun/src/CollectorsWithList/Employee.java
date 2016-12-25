package CollectorsWithList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private String empname;
    private String deptName;

    public Employee(int id, String empname, String deptName) {
        this.id = id;
        this.empname = empname;
        this.deptName = deptName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }    
}


class Test{
    
    public static void main(String[] args) {
        
       ArrayList<Employee> ls=null;
       ls = new ArrayList<>(Arrays.asList(new Employee(12,"Kumar","Maths"),new Employee(22,"Madhur","Physics"),new Employee(44,"Champu","Chemistry")));
       
       Map<String,List<Employee>> map=ls.stream().collect(Collectors.groupingBy(Employee::getDeptName));
      
       map.entrySet().stream().forEach(entry->System.out.println(entry.getKey()+"   "+
               entry.getValue().stream()
                       .map(emp->emp.getEmpname()).collect(Collectors.joining("")) ));
       
    Map<String,Integer> mp=ls.stream().collect(Collectors.groupingBy(Employee::getEmpname,Collectors.summingInt(i->i.getId())));
       
    Map<Boolean,List<Employee>> newMap=ls.stream().collect(Collectors.partitioningBy(emp->emp.getId()>12));
    
    newMap.entrySet().stream().filter(entry->entry.getKey()==true).
            forEach(x->System.out.println("<-------->"+x.getValue().stream().map(y->y.getEmpname()).collect(Collectors.joining("-"))));
    
    }
    
    
}