import java.util.Scanner;
import java.io.BufferedInputStream;

public class Problema224{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
            int casos, array[], aux, suma;
            
            while(sc.hasNextInt()){
                casos = sc.nextInt();
                
                if (casos != 0){
                    aux = 0;
                    array = new int[casos];
                    for (int i =0; i<casos; i++){
                        array[i]= sc.nextInt();
                        
                    }
                    suma =array[casos-1];
                    for(int i = casos-2; i>=0; i--){
                        if(suma == array[i]){
                            aux =i+1; 
                        }
                        suma += array[i]; 
                    }
                    if(aux== 0){
                        System.out.println("NO");
                    }
                    else{
                        System.out.println("SI " + aux);
                    }
                    
                }
            }
            

        }
    }
}