package sort;

import entity.Flower;

import java.util.Comparator;

public class ComparatorFlowerById implements Comparator<Flower> {

    @Override
    public int compare(Flower o1, Flower o2) {
        if(o1.getId() > o2.getId()){
            return 1;
        }else if(o1.getId() == o2.getId()){
            return 0;
        }else {
            return -1;
        }
    }
}
