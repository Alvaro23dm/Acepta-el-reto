
import java.io.BufferedInputStream;
import java.util.Scanner;

public class Problema350{
    
    public static void main (String args[]){
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
            
                boolean a = true;
            while(a) {
                int pri = sc.nextInt();
                
                if (pri == 0){
                    break;
                }
                
                int seg = sc.nextInt();
                
                double resultado = formulaHeron(pri, seg);

                System.out.println(resultado);
                
            }       
            sc.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    private static double formulaHeron(int pri, int seg){
        return (float)(pri*seg)/2;
    }

}