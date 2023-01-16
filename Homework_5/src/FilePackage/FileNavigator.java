package FilePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class FileNavigator {
    private HashMap<String,HashSet<FileData>> filesInDirectory ;
    private HashSet<String>  d =new HashSet<>();

    public FileNavigator() {
        this.filesInDirectory = new HashMap<>();
    }
    public void add (FileData file){
        if (filesInDirectory.containsKey(file.getPath())==false) {
            filesInDirectory.put(file.getPath(),new HashSet<>());
        }
        filesInDirectory.get(file.getPath()).add(file);
    }
    public HashSet<FileData> find(String path){
        if (filesInDirectory.containsKey(path)) {
            return filesInDirectory.get(path);
        }else{
            System.out.println(path+"  -  This is path does not exist");
            return null;
        }
    }
    public HashSet<FileData> filterBySize (long size){
         HashSet<FileData> filesBySize = new HashSet<>();
        for( Map.Entry<String,HashSet<FileData>> node :filesInDirectory.entrySet()){
            for (FileData data : node.getValue()) {
                if ( data.getSizeOfFile()<size) {
                   filesBySize.add(data);
                }
            }
        }
        return filesBySize;
    }
    @Override
    public String toString() {
        return "FileNavigator{" +
                "filesInDirectory=" + filesInDirectory +
                '}';
    }
}
