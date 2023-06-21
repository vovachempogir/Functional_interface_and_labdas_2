import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");

        Predicate<Integer> number = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println(number.test(6));
        System.out.println(number.test(-2));
        System.out.println();

        Predicate<Integer> number1 = integer -> integer > 0;
        System.out.println(number1.test(5));
        System.out.println(number1.test(-1));
        System.out.println();

        System.out.println("Задание 2");

        Consumer<String> name = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет " + s);
            }
        };
        name.accept("Вова");

        Consumer<String> name1 = s -> System.out.println("Привет " + s);
        name1.accept("Вова");
        System.out.println();

        System.out.println("Задача 3");
        Function<Double,Long> number3 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(number3.apply(345.534534));

        Function<Double, Long> number4 = aDouble -> Math.round(aDouble);
        System.out.println(number4.apply(756.4223));
        System.out.println();

        System.out.println("Задача 4");
        Supplier<Integer> number5 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(100);
            }
        };
        System.out.println(number5.get());

        Supplier<Integer> number6 = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };
        System.out.println(number6.get());

        System.out.println("Задача 5");
        Predicate<Integer> integerPredicate = x -> x * 5 != 0;
        Function<Integer, Integer> integerFunction = x -> x + 1;
        Function<Integer, Integer> integerIntegerFunction = x -> x - 5;
        Function<Integer, Integer> result;
        result = ternaryOperator(integerPredicate, integerFunction, integerIntegerFunction);
        result.apply(1);

    }
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return s -> {
            U result = condition.test(s) ? ifTrue.apply(s) : ifFalse.apply(s);
            System.out.println(result);
            return result;
        };
    }
}