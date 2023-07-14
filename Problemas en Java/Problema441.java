import java.io.BufferedInputStream;
import java.util.Scanner;

public class Problema441 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
            while(sc.hasNextLine()){
                String sec = sc.nextLine();
                int tam = sec.length();
                boolean found = false;
                Character[] array = new Character[tam];
                for(int i = 0; i < sec.length(); i++){
                    array[i] = sec.charAt(i);
                }
                for(int i = tam-1; i >= 0 && !found; i--){
                    if(array[i] != '.'){
                        if(array[i] != '9'){
                            int value = Character.getNumericValue(array[i]);
                            value++;
                            value = value + 48;
                            array[i] = (char) value;
                            found = true;
                        } else {
                            array[i] = (char) 48;
                        }
                    } 
                }
                if(!found){
                    System.out.print('1');
                }
                if(array.length % 4 == 3 && !found){
                    System.out.print('.');
                }
                for(int i = 0; i < array.length; i++){
                    System.out.print(array[i]);
                }
                System.out.println("");
            }
        } catch (Exception e) {
            System.exit(1);
        } 
    }
    
}
