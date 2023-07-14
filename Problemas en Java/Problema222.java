import java.util.Scanner;
import java.io.BufferedInputStream;

public class Problema222{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
            int result, varx, varn;
            while(sc.hasNextInt()){
                varx = sc.nextInt();
                varn = sc.nextInt();
                result = 1;
               

                for(int i = 0; i< varn; i++){
                    result = result *varx+1;
                    
                    result %= 1000007;
                }

                System.out.println(result);
            }
            

        }
    }
}