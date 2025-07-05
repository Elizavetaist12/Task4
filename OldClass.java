package Practice.Task5;

@DeprecatedEx(message = "Используйте NewClass")
public class OldClass {

    @DeprecatedEx(message = "newMethod()")
    public void oldMethod() {}

    public void validMethod() {}

    @DeprecatedEx(message = "anotherNewMethod()")
    private void anotherOldMethod() {}
}
