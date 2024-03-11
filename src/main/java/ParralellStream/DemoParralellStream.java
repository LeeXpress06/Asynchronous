package ParralellStream;

import CompletableFuture.HelloWorldService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoParralellStream {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>(List.of("shiblee", "Orthee", "Jannat", "Mir"));
        ArrayList<String> strings = arrayList;
        strings.parallelStream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(strings);





    }





}
