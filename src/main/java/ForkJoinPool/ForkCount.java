package ForkJoinPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkCount {

    public static void main(String[] args) {
     List<String> words = Arrays.asList("Shiblee","Orthee","Jannat","Marca Rubio");
     CountingCow cow = new CountingCow(words);
        ForkJoinPool pool = new ForkJoinPool();
       long count = pool.invoke(cow);
        System.out.println(count);
    }
    public static class CountingCow extends RecursiveTask<Long>{
         private List<String>words;

        public CountingCow(List<String> words) {
            this.words = words;
        }
        @Override
        protected Long compute() {
            if(words.size() <=1) {
                return words.stream().count();
            }
            int size = words.size();
            int mid = size/2;
            CountingCow cow = new CountingCow(words.subList(0, mid));
            CountingCow counting = new CountingCow(words.subList(mid,size));
            cow.fork();
             Long num1 = counting.compute();
             Long num2 = cow.join();

             return num2 + num1;
        }
    }
}
