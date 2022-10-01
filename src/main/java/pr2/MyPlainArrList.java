package pr2;

import lombok.Data;

import java.util.*;
@Data
public class MyPlainArrList<E> implements List<E> {
    List<Triplet> list = new ArrayList<>();
    private Triplet first;
    private Triplet last;

    private int counter;
    private int addfirstcounter;
    private int index = 0;


    public MyPlainArrList() {
        list.add(new Triplet());
        first = list.get(0);
    }


    public MyPlainArrList(int capacity) {
        for (int i=0;i<capacity;i++){
            Triplet triplet = new Triplet();
            list.add(triplet);
            if(i==0){
                first=triplet;
            }
            else{
                list.get(i).setPrevious(list.get(i-1));
                list.get(i-1).setNext(list.get(i));
            }
        }
        last = list.get(list.size()-1);
    }


    @Override
    public boolean add(E e) {
        boolean ad = list.get(index).add(e);
        if (!ad) {
            if (index + 1 == list.size()){
                growUpArray();
                counter = 0;
                index++;
                add(e);
            }
            else{
                index++;
                add(e);
            }
        }
        index=0;
        return true;
    }

    public void addFirst(E e) {
        if(addfirstcounter==0){
            Triplet first = new Triplet();
            first.data[4]=e;
            first.setNext(list.get(0));
            list.get(0).setPrevious(first);
            list.add(0,first);
            this.first = first;
            int index = first.getIndex();
            index++;
            first.setIndex(index);
            addfirstcounter=4;
        }
        else{
            addfirstcounter--;
            first.data[addfirstcounter] = e;
            int index = first.getIndex();
            index++;
            first.setIndex(index);
        }
    }

    public void addLast(E e){
        if(last.getIndex()!=5){
            last.data[last.getIndex()]=e;
            last.setIndex(last.getIndex()+1);
        }
        else{
            growUpArray();
            addLast(e);
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int nextIndex;

            @Override
            public boolean hasNext() {
                return nextIndex < (list.size()*5);
            }

            @Override
            public E next() {
                E t = get(nextIndex);
                nextIndex++;
                if(t!=null){
                    return t;
                }
                else{
                    return null;
                }
            }
        };
    }

    private void growUpArray(){
        if (list.size()==1){
            list.add(new Triplet());
            last = list.get(1);
            last.setPrevious(first);
            first.setNext(last);
        }
        else{
            Triplet triplet = new Triplet();
            list.add(triplet);
            last.setNext(triplet);
            triplet.setPrevious(last);
            this.last = triplet;
        }
    }


    @Override
    public E get(int index) {
        List<Object> m = new ArrayList<>();
        Object vivod = null;
        int indexOfTriplet = index/5;
        m = Arrays.asList(list.get(indexOfTriplet).getData());
        int indexOfObject = index - ((indexOfTriplet)*5);
        vivod = m.get(indexOfObject);
        if (vivod == null){
            return null;
        }
        return (E) vivod;
    }



    public boolean remove(Object object) {
        int index = indexOf(object);
        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }

    @Override
    public E remove(int index) {
        Triplet triplet = first;
        Object removedObject = get(index);
        int indexOfTriplet = index/5;
        int amount = list.size() - indexOfTriplet - 1;
        List copy = toArraylistss();
        if (index%5==0){
            this.last = list.get(indexOfTriplet-1);
            for (int i=0;i< amount+1;i++){
                list.remove(indexOfTriplet);
            }
            last.setNext(null);
            last.setIndex(5);
        }
        else{
            this.last = list.get(indexOfTriplet);
            for (int i=0;i< amount;i++){
                list.remove(indexOfTriplet+1);
            }
            last.setNext(null);
            last.setIndex(index - (indexOfTriplet)*5 );
        }
        for (int i =copy.indexOf(removedObject) +1;i<copy.size();i++){
            addLast((E) copy.get(i));

        }

        return (E) removedObject;
    }

    @Override
    public int size() {
        return list.size();
    }




    @Override
    public boolean isEmpty( ) {
        return list.size() == 0;
    }

    @Override
    public boolean contains (Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void clear() {
        list.clear();
    }


    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        for (Object o: a) {
            addLast((E) o);
        }
        return true;
    }

    /* implment methods above addFirst(), addLast()*/



    @Override
    public Object[] toArray() {
        Object[] vivod = new Object[list.size()];
        for (int j=0;j<vivod.length;j++){
                vivod[j] = Arrays.toString(Arrays.stream(list.get(j).getData()).toArray());
        }
        return vivod;
    }

    public List<E> toArraylistss() {
        List<E> vivod = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<5;j++){
                Object a = list.get(i).data[j];
                if (a!=null){
                    vivod.add((E) list.get(i).data[j]);
                }
            }
        }
        return vivod;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] objects = c.toArray();
        for (Object o: objects) {
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }




    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }


    @Override
    public int indexOf(Object o) {
        for(int i=0; i < list.size()*5; i++) {
            if(get(i)==null){
                i++;
            }
            else if (get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
