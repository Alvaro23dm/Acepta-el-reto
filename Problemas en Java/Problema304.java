import java.io.BufferedInputStream;
import java.util.Scanner;

public class Problema304 {
     public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
            for(int casosPrueba = Integer.parseInt(sc.nextLine()); casosPrueba>0; casosPrueba--) {
                int dividendo = sc.nextInt();
                int divisor = sc.nextInt();
                int cociente = 0;
                int resto = 0;
                if(divisor == 0){
                    System.out.println("DIV0");
                } else {
                    cociente = dividendo / divisor;
                    if(dividendo % divisor == 0){
                        resto = 0;
                    }
                    else if(dividendo < 0 && divisor < 0) {
                        cociente++;
                        resto = dividendo - (cociente * divisor);
                    }
                    else if(dividendo < 0) {
                        cociente--;
                        resto = dividendo - (cociente * divisor);
                    }
                    else {
                        resto = dividendo - (cociente * divisor);
                    }
                    System.out.println(cociente + " " + Math.abs(resto));
                }
            }
        } catch(Exception e) {
            System.exit(1);
        }
    }
}