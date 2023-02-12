package ParserPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
                .map(String::toLowerCase)
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
}
