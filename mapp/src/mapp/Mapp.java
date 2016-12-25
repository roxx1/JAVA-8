package mapp;
import java.util.*;

public class Mapp {

    
    public static void main(String[] args) {
    
        Map<String,String> m=new HashMap<>();
        
        m.put("123","abc");
        m.put("456","def"); 
        m.put("789","ghi");
         m.put("111","dfg");
        
         Set<String> s=m.keySet();
         
         for(String pp:s)
         {
             System.out.println(m.get(pp));
             
         }
         
         Set<Map.Entry<String,String>> kk=m.entrySet();
         
         for(Map.Entry<String,String> mp:kk)
         {
             System.out.println(mp.getKey()+"  "+mp.getValue());
             
         }
         
         
    }
    
}
