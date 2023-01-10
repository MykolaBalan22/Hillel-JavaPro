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
    /**
     *Метод calcOccurance, який приймає на вхід рядковий список як параметр.
     * Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
     * Обчислити скільки разів трапляється кожне слово. Результат вивести у консоль.
     * **/
    public static void calcOccurance(List<String> words){
        ArrayList<String> uniqueWords =new ArrayList<>();
        ArrayList<Integer> counter =new ArrayList<>();
        for (String word : words) {
            if(uniqueWords.contains(word)==false){
                uniqueWords.add(word);
                counter.add(1);
            }else{
                int indexOfRepeatWord = uniqueWords.indexOf(word);
                counter.set(indexOfRepeatWord,counter.get(indexOfRepeatWord)+1);
            }
        }
        Iterator<String> iterWords = uniqueWords.iterator();
        Iterator<Integer> iterCounts = counter.iterator();
        while(iterWords.hasNext() && iterCounts.hasNext()){
            System.out.printf("%s : %d \n", iterWords.next(),iterCounts.next());
        }
    }
    /**
     *  Метод findOccurance, що приймає на вхід рядковий список як параметр.
     *  Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
     *  Обчислити скільки разів трапляється кожне слово.
     *  Результат повернути у вигляді списку структур, що описують повторення кожного окремого взятого слова.
     * **/
    public static List<WordOccurance> findOccurance(List<String> words){
        ArrayList<WordOccurance> uniqueWords =new ArrayList<>();
        for (String word : words) {
            WordOccurance testWord =new WordOccurance(word);
            int localIndex =uniqueWords.indexOf(testWord);
            if (localIndex==-1) {
                uniqueWords.add(testWord);
            }else{
                uniqueWords.get(localIndex).setOccurance();
            }
        }
        return uniqueWords;
    }
}
