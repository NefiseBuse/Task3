
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;
public class Stream {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

        long count = numbers.stream()
                .filter(n -> n % 2 == 0 && n % 4 == 0)
                .count();
        System.out.println("1 ile 100 arasındaki sayılardan; " );
        System.out.println("Hem 2'ye hem de 4'e bölünebilen sayıların adedi: " + count);
        long oddCount = numbers.stream().filter(n -> n % 2 != 0).count();
        long oddSum = numbers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("Tek sayıların adedi: " + oddCount);
        System.out.println("Tek sayıların toplamı: " + oddSum);

        long evenCount = numbers.stream().filter(n -> n % 2 == 0).count();
        int evenSum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Çift sayıların adedi: " + evenCount);
        System.out.println("Çift sayıların toplamı: " + evenSum);

        List<Integer> divisibleByThreeReversed = numbers.stream()
                .filter(n -> n % 3 == 0)
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        boolean allDivisibleByThreeReversed = divisibleByThreeReversed.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList())
                .stream()
                .allMatch(n -> n % 3 == 0);



        System.out.println("3 e bölübilen sayıların tersten yazılışı "+divisibleByThreeReversed);
        System.out.println("3 ile bölünebilen sayılar tersten mi yazılmış? " + allDivisibleByThreeReversed);

    }
}