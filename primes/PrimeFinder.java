package primes;
public class PrimeFinder {
    int[] primes;
    int found;

    public int[] getPrimes() {
        return this.primes;
    }

    public boolean test(int n) {
        int j = 2;
        int a = 1;
        while ((primes[j] < (int) Math.sqrt(n) + 1) && a!= 0) {
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
}