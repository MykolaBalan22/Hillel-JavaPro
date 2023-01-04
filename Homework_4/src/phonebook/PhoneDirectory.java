package phonebook;

import java.util.ArrayList;
import java.util.List;
public class PhoneDirectory<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object [] insideStorage =new Object[DEFAULT_CAPACITY] ;
    private int counterNewObjects =0;
    /**
     * Метод додає Запис до Телефонного Довідника.
     *
     * Примітка: Під одним прізвищем може зберігатися кілька телефонів, тому можлива наявність декількох записів**/
    public void add (T object){
        if(counterNewObjects <insideStorage.length){
            insideStorage[counterNewObjects]=object;
        }else{
            Object [] copyStorage =new Object[insideStorage.length+insideStorage.length/2];
            System.arraycopy(insideStorage,0,copyStorage,0,insideStorage.length);
            insideStorage =copyStorage;
            insideStorage[counterNewObjects]=object;
        }
        counterNewObjects++;
    }
    public int size(){
        return counterNewObjects;
    }
}
