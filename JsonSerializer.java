package Practice.Task6;

import java.lang.reflect.Field;
import java.util.StringJoiner;

public class JsonSerializer {

    public String serialize(Object object) throws IllegalAccessException {
        StringJoiner json = new StringJoiner(", ", "{", "}");
        Class<?> cls = object.getClass();

        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                // Ключевое исправление: получаем доступ к приватному полю
                field.setAccessible(true); // Разрешаем доступ к приватным полям

                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonName = annotation.name();
                Object value = field.get(object); // Теперь доступ разрешен

                json.add("\"" + jsonName + "\": " + formatValue(value));
            }
        }

        return json.toString();
    }

    private String formatValue(Object value) {
        if (value == null) return "null";
        if (value instanceof String) return "\"" + value + "\"";
        if (value instanceof Character) return "\"" + value + "\"";
        return value.toString();
    }
}