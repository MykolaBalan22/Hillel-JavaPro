package ListTester;

import java.util.*;
public class ListTester {
    /**
     * Метод countOccurance, що приймає на вхід рядковий список як параметр і довільний рядок.
     * Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
     * Метод рахує разів зустрічається переданий рядок як другий аргумент.
     **/
    public  static  int  countOccurance (List<String> words ,String regularEx){
        int counter=0;
        for (String word : words) {
            if(word.equalsIgnoreCase(regularEx.trim())==true){
                counter++;
            }
        }
        return counter;
    }
}
