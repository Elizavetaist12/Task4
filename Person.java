package Practice.Task6;

public class Person {
    @JsonField(name = "Name")
    public String name;

    @JsonField(name = "Age")
    private int age; // Приватное поле!

    @JsonField(name = "is_student")
    protected boolean isStudent;

    public Person(String name, int age, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }
}