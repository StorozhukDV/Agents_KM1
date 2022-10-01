import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pr2.MyPlainArrList;

import java.util.List;

public class MainTest {
    List ad = List.of("a","b","c","d","e","f","g","h","i","j");
    @Test
    public void add(){
        MyPlainArrList<String> list = new MyPlainArrList<>();
        for (int i=0;i< ad.size();i++){
            list.add((String) ad.get(i));
            Assertions.assertEquals(ad.get(i),list.get(i));
        }
    }

    @Test
    public void remove(){
        MyPlainArrList<String> list = new MyPlainArrList<>();
        for (int i=0;i< ad.size();i++) {
            list.add((String) ad.get(i));
        }
        list.remove("c");
        Assertions.assertFalse(list.contains("c"));
    }
    @Test
    public void clear(){
        MyPlainArrList<String> list = new MyPlainArrList<>();
        for (int i=0;i< ad.size();i++) {
            list.add((String) ad.get(i));
        }
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void iterator(){
        MyPlainArrList<String> list = new MyPlainArrList<>();
        for (int i=0;i< ad.size();i++) {
            list.add((String) ad.get(i));
        }
        int i=0;
        for(String str:list){
            Assertions.assertEquals(ad.get(i),str); //Непонятно как быть с null
            i++;
        }
    }
    @Test
    public void addfirst(){
        MyPlainArrList<String> list = new MyPlainArrList<>();
        for (int i=0;i< ad.size();i++) {
            list.add((String) ad.get(i));
        }
        list.addFirst("ONE");
        Assertions.assertEquals("ONE", list.get(4));
    }

    @Test
    public void addlst(){
        MyPlainArrList<String> list = new MyPlainArrList<>();
        for (int i=0;i< ad.size();i++) {
            list.add((String) ad.get(i));
        }
        list.addLast("LAST");
        Assertions.assertEquals("LAST",list.get((list.size()-1)*5+list.getLast().getIndex()-1));
    }

}
