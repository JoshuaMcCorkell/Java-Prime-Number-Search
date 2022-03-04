package primes;
import java.util.ArrayList;
import java.util.List;

public class PrimeFinder {
    int[] primes;
    
    int found;

    public int[] getPrimes() {
        return this.primes;
    }

    public boolean test(int n) {
        int j = 2;
        int a = 1;
        int root = (int) Math.sqrt(n) + 1;
        while ((primes[j] < root) && a!= 0) {
            a = n % primes[j];
            j++;
        }
        return (a != 0);
    }

    /**
     * Finds the specified amount of prime numbers.
     * @param toFind  Must be a number more than 2.
     */
    public void find(int toFind) {
        primes = new int[toFind];
        primes[0] = 2; primes[1] = 3; primes[2] = 5;
        found = 3;
        int i = 7;
        while (found < toFind) {
            if (test(i)) {
                primes[found] = i;
                found++;
            }
            i += 2 + ((i + 1) % 6);
        }
    }

    public void findRange(int max) {
        List<Integer> primes1 = new ArrayList<>(max/2 + 1);
        List<Integer> primes2 = new ArrayList<>(max/2);
        
    //TODO make this loop add the prime numbers to a third list that will be the final list of primes.
        int root = (int) Math.sqrt(max) + 1;
        primes1.add(2);
        for (int i = 3; i < max; i++) {
            primes1.add(i);
        }
        int n = 0;
        while (n < root) {
            n = primes1.remove(0);
            primes2.add(n);
            for (int i : primes1) {
                if (i % n != 0) {
                    primes2.add(i);
                }
            }
        }
    }
}