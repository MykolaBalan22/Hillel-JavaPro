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
    /**
     * Метод toList, що приймає на вхід цілісний масив довільної довжини.
     * Конвертувати масив у список відповідного типу даних та повернути з методу
     * **/
    public static List<?> toList (Object [] inputSequense){
        List<Object> outputArray = new ArrayList<>();
        for (Object o : inputSequense) {
            outputArray.add(o);
        }
        return outputArray ;
    }
    /**
     * Метод findUnique, що приймає на вхід числовий список, що складається з довільних значень,
     * які можуть повторюватися в необмеженій кількості.
     * Необхідно повернути новий числовий список, що містить тільки унікальні числа.
     * **/
    public static List<Number> findUnique(List<Number> inputSequense){
        List<Number> uniqueSequense =new LinkedList<>();
        Collection<Number> repeatSequense =new ArrayList<>();
        for (Number number : inputSequense) {
            if(uniqueSequense.contains(number)==false){
                uniqueSequense.add(number);
            }else{
                repeatSequense.add(number);
            }
        }
        uniqueSequense.removeAll(repeatSequense);
        return uniqueSequense;
    }
}
