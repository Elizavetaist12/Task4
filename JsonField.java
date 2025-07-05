package Practice.Task6;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target(ElementType.FIELD) // Применяется только к полям
public @interface JsonField {
    String name(); // Обязательный параметр для имени поля в JSON
}