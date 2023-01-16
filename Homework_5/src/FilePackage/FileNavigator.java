package FilePackage;

import java.util.HashMap;
import java.util.HashSet;


public class FileNavigator {
    private HashMap<String,HashSet<FileData>> filesInDirectory ;

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
    @Override
    public String toString() {
        return "FileNavigator{" +
                "filesInDirectory=" + filesInDirectory +
                '}';
    }
}
