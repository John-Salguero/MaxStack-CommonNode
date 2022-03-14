package MyStack;

import java.util.ArrayList;
import java.util.Comparator;

public class MyStack<T> {

    ArrayList<T> elements;
    ArrayList<T> maxValues;
    Comparator<T> comparator;

    public MyStack(Comparator<T> comparator){
        this.comparator = comparator;
        elements = new ArrayList<>();
        maxValues = new ArrayList<>();
    }

    public void push(T newElement){
        elements.add(newElement);
        if(maxValues.isEmpty())
            maxValues.add(newElement);
        else if(comparator.compare(max(), newElement) <= 0)
            maxValues.add(newElement);
    }

    public T pop() throws IllegalStateException {
        if(elements.size() == 0)
            throw new IllegalStateException("Stack has no elements");

        T retVal = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        if(comparator.compare(maxValues.get(maxValues.size() - 1), retVal) == 0)
            maxValues.remove(maxValues.size() -1);

        return retVal;
    }

    public T max() throws IllegalStateException{
        if(elements.size() == 0)
            throw new IllegalStateException("Stack has no elements");

        return maxValues.get(maxValues.size() - 1);
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }
}
