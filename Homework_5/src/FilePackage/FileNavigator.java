package FilePackage;

import java.util.*;

public class FileNavigator {
    private HashMap<String,HashSet<FileData>> pathWithFiles;
    public FileNavigator() {
        this.pathWithFiles = new HashMap<>();
    }
    public void add (FileData file){
        if (pathWithFiles.get(file.getPath())!=null) {
            pathWithFiles.get(file.getPath()).add(file);
        }else{
            System.out.println("This is path does not exist");
        }
    }
    public void addPath(String path){
        if (pathWithFiles.containsKey(path)==false) {
            pathWithFiles.put(path,new HashSet<>());
        }
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
    public TreeSet<FileData> sortBySize(){
        TreeSet<FileData> sortedFiles =new TreeSet<>((o1, o2) -> (int)(o1.getSizeOfFile()-o2.getSizeOfFile()));
        for (Map.Entry<String, HashSet<FileData>> node : pathWithFiles.entrySet()) {
            for (FileData data : node.getValue()) {
                sortedFiles.add(data);
            }
        }
        return sortedFiles;
    }
   
    @Override
    public String toString() {
        return "FileNavigator{" +
                "filesInDirectory=" + pathWithFiles +
                '}';
    }
}
