package primes;
import java.util.Arrays;
import java.util.LinkedList;

public class PrimeFinder {
    int[] primes;
    int found;

    public int[] getPrimes() {
        return this.primes;
    }

    public boolean test(int n) {
        int j = 2;
        int a = 1;
        int root = (int) Math.sqrt(n);
        while ((primes[j] <= root) && a!= 0) {
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
    
    int k;
    public void findRange(int max) {
        primes = new int[max/3 + 2];
        primes[0] = 2; primes[1] = 3;
        int root = (int) Math.sqrt(max) + 1;
        int i = 5;
        int j = 2;
        while (i <= max) {
            primes[j++] = i;
            i += 2 + ((i + 1) % 6);
        }
        k = 2;
        while (primes[k] < root) {
            primes = Arrays.stream(primes).filter(x -> div(x, primes[k])).toArray();
            k++;
        }
    }

    private boolean div(int x, int div) {
        return (x%div) != 0 || x == div;
    }
}