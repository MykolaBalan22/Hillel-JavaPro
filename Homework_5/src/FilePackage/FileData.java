package FilePackage;

import java.util.Objects;

public class FileData {
    private String fileName ;
    private long sizeOfFile;
    private String path;

    public FileData(String fileName, long sizeOfFile, String path) {
        this.fileName = fileName;
        this.sizeOfFile = sizeOfFile;
        this.path = path;
    }

    public FileData() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getSizeOfFile() {
        return sizeOfFile;
    }

    public void setSizeOfFile(long sizeOfFile) {
        this.sizeOfFile = sizeOfFile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return sizeOfFile == fileData.sizeOfFile && Objects.equals(fileName, fileData.fileName) && Objects.equals(path, fileData.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, sizeOfFile, path);
    }

    @Override
    public String toString() {
        return "FileData{" +
                "fileName='" + fileName + '\'' +
                ", sizeOfFile=" + sizeOfFile +
                ", path='" + path + '\'' +
                '}';
    }
}
