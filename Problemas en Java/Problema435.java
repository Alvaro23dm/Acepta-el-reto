import java.util.Scanner;

public class Problema435 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                String x = sc.nextLine();
                int[] a = new int[10];
                boolean bool = true;
                for (int i = 0; i < x.length(); i++) {
                    int w = Character.getNumericValue(x.charAt(i));
                    if (w < 10) {
                        a[w]++;
                    }
                }

                int valor = a[0];
                for (int i = 1; i < a.length && bool; i++) {
                    if (a[i] != valor)
                        bool = false;
                }
                if (bool)
                    System.out.println("subnormal");
                else
                    System.out.println("no subnormal");
            }
        } catch (Exception e) {
            System.exit(1);
        }
    }
}