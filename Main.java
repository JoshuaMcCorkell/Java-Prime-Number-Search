import primes.PrimeFinder;

public class Main {
    public static void main(String[] args) {
        int n = 1000000;
        PrimeFinder finder = new PrimeFinder();


        long start = System.nanoTime();
        finder.find(n);
        long end = System.nanoTime();
        System.out.println("Highest Prime Found: " + finder.getPrimes()[n - 1]);
        System.out.println("\nTraditional Method:");
        System.out.println("Duration (ms): " + ((end - start)/1000000));


        System.out.println("\nList Filtering:");
        start = System.nanoTime();
        finder.findRange(finder.getPrimes()[n-1]);
        end = System.nanoTime();
        n = finder.getPrimes().length;
        System.out.println("Duration (ms): " + ((end - start)/1000000));
    }
}
