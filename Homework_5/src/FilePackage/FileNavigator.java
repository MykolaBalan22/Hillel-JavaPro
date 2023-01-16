package FilePackage;

import java.util.*;


public class FileNavigator {
    private HashMap<String,HashSet<FileData>> pathWithFiles;
    private HashSet<String>  d =new HashSet<>();

    public FileNavigator() {
        this.pathWithFiles = new HashMap<>();
    }
    public void add (FileData file){
        if (pathWithFiles.containsKey(file.getPath())==false) {
            pathWithFiles.put(file.getPath(),new HashSet<>());
        }
        pathWithFiles.get(file.getPath()).add(file);
    }
    public HashSet<FileData> find(String path){
        if (pathWithFiles.containsKey(path)) {
            return pathWithFiles.get(path);
        }else{
            System.out.println(path+"  -  This is path does not exist");
            return null;
        }
    }
    public HashSet<FileData> filterBySize (long size){
         HashSet<FileData> filesBySize = new HashSet<>();
        for( Map.Entry<String,HashSet<FileData>> node : pathWithFiles.entrySet()){
            for (FileData data : node.getValue()) {
                if ( data.getSizeOfFile()<size) {
                   filesBySize.add(data);
                }
            }
        }
        return filesBySize;
    }
    public void remove(String path){
        pathWithFiles.remove(path);
    }
   
    @Override
    public String toString() {
        return "FileNavigator{" +
                "filesInDirectory=" + pathWithFiles +
                '}';
    }
}
