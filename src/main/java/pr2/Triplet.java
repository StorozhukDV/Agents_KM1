package pr2;


import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Triplet {
    public Object[] data = new Object[5];
    public Triplet previous;
    public Triplet next;
    private int index = 0;

    public boolean add(Object e) {
        if (index + 1 > data.length) {
            return false;
        }
        data[index] = e;
        index++;
        return true;
    }
}

