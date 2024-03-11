package ForkJoinPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,2,1,2,2,3,2,1,2,3,21,23);
        Numberlist numberlist = new Numberlist(numbers);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
       Integer sum = forkJoinPool.invoke(numberlist);

        System.out.println(sum);

       }
    public static class Numberlist extends RecursiveTask<Integer> {
        private List<Integer> list;

        public Numberlist(List<Integer> list) {
            this.list = list;
        }

        @Override
        protected Integer compute() {

            if(list.size()<=1){
                return list.stream().reduce(0, (a,b) -> (a+b));

            }

            int size = list.size()/2;
          Numberlist right = new Numberlist(list.subList(0, size));
          Numberlist left = new Numberlist(list.subList(size, list.size()));

           right.fork();

        Integer leftResult =  left.compute();

            Integer rightresult = right.join();
          Integer result = leftResult + rightresult;

          return result;
        }

    }
}



