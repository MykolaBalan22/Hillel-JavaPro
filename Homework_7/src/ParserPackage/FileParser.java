package ParserPackage;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileParser {
    private File fileForReading ;
    public File containsFile(String fileName){
        File bookFile = new File("src\\"+fileName);
        if (!bookFile.exists()) {
           throw new RuntimeException("Book is not found !");
        }
        fileForReading=bookFile;
        return bookFile;
    }
    public  List<String> clearningStrings (List<String> inputStringSequence){
        Pattern regularExpression =Pattern.compile("((^\\W*)([a-zA-Z]+\\'?\\-?[a-zA-Z]*)(\\W*$))");
        return inputStringSequence.stream()
               // .map(String::toLowerCase)
                .map(s->{
                    Matcher matcher =regularExpression.matcher(s);
                    return matcher.matches() ? matcher.group(3) :"";
                })
                .filter(s->!s.isEmpty())
                .collect(Collectors.toList());
    }
    public List<String> getStringsFromFile(){
        ArrayList<ArrayList<String>> internalStorage=new ArrayList<>();
        try ( BufferedReader fileStringReader = new BufferedReader(new FileReader(fileForReading))){
            String line;
            while ((line=fileStringReader.readLine())!=null) {
                ArrayList<String> nestedStringCollection = new ArrayList<>();
                nestedStringCollection.addAll(Arrays.asList(line.split(" ")));
                internalStorage.add(nestedStringCollection);
            }
        } catch (IOException e) {
            throw new RuntimeException("Some problem in reading");
        }
        return internalStorage.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
    public  List<Map.Entry<String, Integer>> getTenMostPopularWords(){
        Map<String,Integer> wordsCounter =new HashMap<>();
        clearningStrings(getStringsFromFile()).stream()
                .map(String::toLowerCase)
                .filter(s->s.length()>2)
                .forEach(s->{
                    if(!wordsCounter.containsKey(s)){
                        wordsCounter.put(s,1);
                    }else{
                        wordsCounter.put(s, wordsCounter.get(s)+1);
                    }
                });
       return  wordsCounter.entrySet().stream()
               .sorted((s1,s2)->s2.getValue()- s1.getValue())
               .limit(10)
               .collect(Collectors.toList());
    }
    public long countUniqueWords (){
       return clearningStrings(getStringsFromFile()).stream()
                .distinct()
                .count();
    }
    public void writeStatisticsToFile (){
        try(PrintWriter statisticWriter =new PrintWriter(new FileWriter(fileForReading.getName().replaceAll("\\.[a-z]+","")+"_statictic.txt"))) {
            statisticWriter.print("Ten most popular words over two characters :\n");
            for (Map.Entry<String, Integer> popularWord : getTenMostPopularWords()) {
                statisticWriter.printf("[%s] found {%d} times\n", popularWord.getKey(),popularWord.getValue());
            }
            statisticWriter.print("-------------------------------------\n");
            statisticWriter.print("Unique words :\n");
            statisticWriter.printf("Number of unique words [%d]\n",countUniqueWords());
            statisticWriter.print("-------------------------------------\n");
            statisticWriter.print("Unique words in symbols :\n");
            clearningStrings(getStringsFromFile()).stream()
                    .distinct()
                    .forEach(s-> statisticWriter.printf("[%s] -> {%d} symbols\n",s,s.length()));
            statisticWriter.print("-------------------------------------\n");
            statisticWriter.print("All words :\n");
            statisticWriter.printf("Number of words [%d]\n",clearningStrings(getStringsFromFile()).stream().count());
        } catch (IOException e) {
            throw new RuntimeException("Some problem in writing");
        }
    }
    public void printStatisticsOnConsole (){
        PrintStream statisticPrinter = new PrintStream(System.out);
        statisticPrinter.print("Ten most popular words over two characters :\n");
            for (Map.Entry<String, Integer> popularWord : getTenMostPopularWords()) {
                statisticPrinter.printf("[%s] found {%d} times\n", popularWord.getKey(), popularWord.getValue());
            }
        statisticPrinter.print("-------------------------------------\n");
        statisticPrinter.print("Unique words :\n");
        statisticPrinter.printf("Number of unique words [%d]\n", countUniqueWords());
        statisticPrinter.print("-------------------------------------\n");
        statisticPrinter.print("Unique words in symbols :\n");
            clearningStrings(getStringsFromFile()).stream()
                    .distinct()
                    .forEach(s -> statisticPrinter.printf("[%s] -> {%d} symbols\n", s, s.length()));
        statisticPrinter.print("-------------------------------------\n");
        statisticPrinter.print("All words :\n");
        statisticPrinter.printf("Number of words [%d]\n", clearningStrings(getStringsFromFile()).stream().count());

    }
}
