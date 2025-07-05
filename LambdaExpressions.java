package Practice.Task4;

import java.util.function.Predicate;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.Random;
import java.util.function.Supplier;

@FunctionalInterface
interface Printable {
    void print();
}

class HeavyBox {
    private int weight;

    public HeavyBox(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

public class LambdaExpressions {
    public static void main(String[] args) {

        System.out.println("1");
        Printable printable = () -> System.out.println("Hello");
        printable.print();

        System.out.println("2");

        String str1 = "Привет";
        String str2 = null;
        String str3 = "";

        Predicate<String> isNotNull = Objects::nonNull;
        Predicate<String> isNotEmpty = str -> !str.isEmpty();
        Predicate<String> isValid = isNotNull.and(isNotEmpty);

        System.out.println("str1 не 0 и не пуста? " + isValid.test(str1)); // true
        System.out.println("str2 не 0 и не пуста? " + isValid.test(str2)); // false
        System.out.println("str3 не 0 и не пуста? " + isValid.test(str3)); // false

        System.out.println("\n3");

        Predicate<String> startsWithJorNAndEndsWithA = str -> {
            if (str == null || str.isEmpty()) return false;
            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);
            return (first == 'J' || first == 'N') && (last == 'A');
        };

        String[] tests = {"JAVA", "NINJA", "JAZZ", "NOVA", "ALPHA", "NJAVA", null, "", "Na"};
        for (String test : tests) {
            System.out.printf("Строка \"%s\" проходит проверку? %b%n", test, startsWithJorNAndEndsWithA.test(test));
        }

        System.out.println("\n4");

        HeavyBox box = new HeavyBox(42);
        Consumer<HeavyBox> shipment = b -> System.out.println("Отгрузили ящик с весом " + b.getWeight());
        Consumer<HeavyBox> sending = b -> System.out.println("Отправляем ящик с весом " + b.getWeight());
        Consumer<HeavyBox> fullProcess = shipment.andThen(sending);
        fullProcess.accept(box);


        System.out.println("\n5");

        Function<Integer, String> checkSign = number -> {
            if (number > 0) return "Положительное число";
            else if (number < 0) return "Отрицательное число";
            else return "Ноль";
        };

        int[] numbers = {10, -5, 0, 123, -999};
        for (int n : numbers) {
            System.out.printf("Число %d - %s%n", n, checkSign.apply(n));
        }

        System.out.println("\n6");
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(11);

        for (int i = 0; i < 5; i++) {
            System.out.println("Случайное число: " + randomSupplier.get());
        }
            }
}

