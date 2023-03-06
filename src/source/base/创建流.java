package source.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class 创建流 {
    public static void main(String[] args) throws Exception {
        // 集合：使用 stream() 和 parallelStream() 方法
        System.out.println("create01======== start");
        create01();
        System.out.println("create01======== end");

        // 数组：使用 stream() 方法
        System.out.println("create02======== start");
        create02();
        System.out.println("create02======== end");

        // 使用Stream中的静态方法：of() iterate() generate()
        System.out.println("create03======== start");
        create03();
        System.out.println("create03======== end");

        // 文件：BufferedReader.lines()
        System.out.println("create04======== start");
        create04();
        System.out.println("create04======== end");

        // 字符串：Pattern.splitAsStream()
        System.out.println("create05======== start");
        create05();
        System.out.println("create05======== end");
    }

    private static void create05() {
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
        stringStream.forEach(System.out::println);
    }

    private static void create04() throws FileNotFoundException {
        File file = new File("src/source/base/test_stream.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Stream<String> lineStream = reader.lines();
        lineStream.forEach(System.out::println);
    }

    private static void create03() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        stream.forEach(System.out::println);

        // 0 2 4 6 8 10
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(6);
        stream2.forEach(System.out::println);

        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
        stream3.forEach(System.out::println);
    }

    private static void create02() {
        Integer[] nums = new Integer[10];
        Stream<Integer> stream = Arrays.stream(nums);
        stream.forEach(System.out::println);
    }

    private static void create01() {
        List<String> list = new ArrayList<>();

        // 获取一个顺序流
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

        // 获取一个并行流
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(System.out::println);
    }
}
