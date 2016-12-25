import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;

public class Java8Supplier {

    public static void main(String[] args) {        
        Item i1=new Item(true,123);
        IntSupplier is=()->10;
        
        IntSupplier is1=()->i1.getItem();
        System.out.println(is1.getAsInt()+"   "+is.getAsInt());
        
        BooleanSupplier bs=()->i1.getStatus();
        System.out.println(bs.getAsBoolean());
 
    }
}
class Item{
    private boolean status;
    private int item;

    public Item(boolean status, int item) {
        this.status = status;
        this.item = item;
    }

    public int getItem() {
        return item;
    }
  
    public boolean getStatus(){
        return status;
    }
     
}