import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import primes.PrimeFinder;

public class Main {
    public static void perfTest(int repetitions) {
        Scanner consoleIn = new Scanner(System.in);
        System.out.print("How Many Primes?  ");
        int n = consoleIn.nextInt();
        PrimeFinder finder = new PrimeFinder();
        long start;
        long end;
        System.out.println("\nTraditional Method:");
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            finder.find(n);
            end = System.nanoTime();
            System.out.println("Duration (ms): " + ((end - start)/1000000));
        }
        System.out.println("\nList Filtering:");
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            finder.findRange(finder.getPrimes()[n-1]);
            end = System.nanoTime();
            System.out.println("Duration (ms): " + ((end - start)/1000000));
        }
        System.out.println("\nHighest: " + finder.getPrimes()[finder.getPrimes().length - 1]);
    }

    public static void writeCSV(File file, int[] values) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (int i : values) {
            writer.write(i + ",");
        }
        writer.close();
    }

    public static void writeTXT(File file, int[] values) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (int i : values) {
            writer.write(i + "\n");
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner consoleIn = new Scanner(System.in);
        System.out.print("How Many Primes?  ");
        int n = consoleIn.nextInt();
        PrimeFinder finder = new PrimeFinder();
        long start;
        long end;
        start = System.nanoTime();
        finder.find(n);
        end = System.nanoTime();
        System.out.println("Duration (ms): " + ((end - start)/1000000) + "\n");
        System.out.println("\nHighest: " + finder.getPrimes()[finder.getPrimes().length - 1]);
        System.out.println("Would you like to write to a File? Y/N");
        String answer;
        answer = consoleIn.next();
        if (answer.equals("Y")) {
            writeTXT(new File("C:\\Users\\joshu\\Desktop\\Primes.txt"), finder.getPrimes());
        } 
        
    }
}
