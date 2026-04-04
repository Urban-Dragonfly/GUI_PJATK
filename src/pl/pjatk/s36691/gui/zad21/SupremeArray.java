package pl.pjatk.s36691.gui.zad21;

import java.util.Arrays;
import java.util.Comparator;

public class SupremeArray<T> {

    private Object[] arr;

    public SupremeArray(){
        this.arr = new Object[0];
    }

    private SupremeArray(int size){
        this.arr = new Object[size];
    }

    public int getSize(){
        return this.arr.length;
    }

    public void add(T element) {
        int oldLength = arr.length;
        int newLength = oldLength + 1;
        Object[] newArr = new Object[newLength];
        for(int i = 0; i < oldLength; i++){
            newArr[i] = arr[i];
        }
        newArr[oldLength] = element;
        arr = newArr;
    }

    public void addAt(int index, T element) {
        int newLength = arr.length + 1;
        if(index < 0 || index > arr.length){
            System.out.println("Index out of range");
            return;
        }
        Object[] newArr = new Object[newLength];
        int i = 0;
        while(i < index){
            newArr[i] = arr[i];
            i++;
        }
        newArr[i] = element;
        i++;
        while(i < newLength){
            newArr[i] = arr[i - 1];
            i++;
        }
        arr = newArr;
    }

    public void remove() {
        if(arr.length == 0){
            System.out.println("Array is empty");
            return;
        }
        int newLength = arr.length - 1;
        Object[] newArr = new Object[newLength];
        for(int i = 0; i < newLength; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void removeAt(int index){
        if(index < 0 || index > arr.length - 1){
            System.out.println("Index out of range");
            return;
        }
        Object[] newArr = new Object[arr.length - 1];
        int i = 0;
        while(i < index){
            newArr[i] = arr[i++];
        }
        while( i < newArr.length){
            newArr[i] = arr[i++ + 1];
        }
        arr = newArr;
    }

    public void print() {
        for(int i = 0; i < arr.length; i++){
            System.out.println("(" + i + ") " + arr[i]);
        }
    }

    public void sort() {
        if (arr.length < 2) {
            return;
        }
        if (arr[0] instanceof Comparable) {
            Arrays.sort(arr);
        } else {
            System.out.println("Array elements are not comparable");
        }
    }

    public void sort(Comparator<? super T> comparator) {
        if (arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare((T) arr[i], (T) arr[j]) > 0) {
                    T temp = (T) arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

    }

}
