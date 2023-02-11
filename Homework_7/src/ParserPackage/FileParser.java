package ParserPackage;

import java.io.File;

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
}
