import primes.PrimeFinder;

public class Main {
    public static void main(String[] args) {
        int n = 100000;
        PrimeFinder finder = new PrimeFinder();
        System.out.println("Traditional Method:\n");
        long start = System.nanoTime();
        finder.find(n);
        long end = System.nanoTime();
        System.out.println("Highest Prime Found: " + finder.getPrimes()[n - 1]);
        System.out.println("Duration (ms): " + ((end - start)/1000000));

        System.out.println("\nList Filtering:\n");
        start = System.nanoTime();
        finder.findRange(finder.getPrimes()[n-1]);
        end = System.nanoTime();
        n = finder.getPrimes().length;
        //System.out.println("Primes found: " + n);
        System.out.println("Highest Prime Found: " + finder.getPrimes()[n - 1]);
        System.out.println("Duration (ms): " + ((end - start)/1000000));
    }
}
