package phonebook;

import java.util.Objects;
public class Note {
    private String name;
    private String phoneNumber;

    public Note(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public Note() {
    }

    @Override
    public boolean equals(Object line) {
        return this.name.equals(line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Note{" + "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' + '}';
    }
}
