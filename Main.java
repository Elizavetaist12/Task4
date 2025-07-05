package Practice.Task6;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Alice", 30, true);
        JsonSerializer serializer = new JsonSerializer();
        System.out.println(serializer.serialize(person));
    }
}