import java.util.Scanner;

public class Problema373 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
            {
                 long x = sc.nextInt();
                 //System.out.println(Math.pow(x, 3)-Math.pow((x-2), 3));
                 System.out.println(x*x*x - (x-2)*(x-2)*(x-2));
            }
        } catch (Exception e) {
            System.exit(1);
        }
    }
}