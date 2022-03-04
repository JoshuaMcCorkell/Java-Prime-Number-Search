import primes.PrimeFinder;

public class Main {
    public static void main(String[] args) {
        int n = 10000000;
        PrimeFinder finder = new PrimeFinder();

        long start = System.nanoTime();
        finder.find(n);
        long end = System.nanoTime();
        System.out.print("Highest Prime Found: ");
        System.out.println(finder.getPrimes()[n - 1]);
        System.out.print("Duration (ms): ");
        System.out.println((end - start)/1000000);
    }
}
