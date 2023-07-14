import java.io.BufferedInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;


public class Problema569 {
    @SuppressWarnings("deprecation")
    public static void main(String args[]){
        
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
            while(sc.hasNextInt()){
                int numCasos = sc.nextInt();
                for (int i = 0; i < numCasos; i++) {
                    int partidas = 0;
                    int horasJuego = Integer.parseInt(sc.next());
                    
                    int numClases = Integer.parseInt(sc.next());
                    if (numClases>0){
                        String horaIniFull = sc.next();
                        Date date = pasarDate(horaIniFull);
                        
                        int horaIni =date.getHours();
                        int minIni = date.getMinutes();
                        

                        for (int j = 0; j < numClases -1 ; j++) {
                            int duracion=sc.nextInt();
                            
                            String horaFinFull = sc.next();
                            date = pasarDate(horaFinFull);
                            int horaFin =date.getHours();
                            int minFin = date.getMinutes();
                            
                            minIni += duracion;
                            if(minIni>=60){
                                horaIni+=minIni/60;
                                minIni=minIni%60; 
                            }

                            int libre = (horaFin -horaIni) * 60 +  (minFin - minIni);
                            if(libre>= horasJuego){
                                partidas += libre;
                            }

                            horaIni=horaFin;
                            minIni=minFin;

                        }
                        int duracion = sc.nextInt();
                        
                        minIni += duracion;
                        if(minIni>=60){
                            horaIni+=minIni/60;
                            minIni=minIni%60; 
                        }
                        int horaFin =14;
                        int minFin =0;
                        int libre = (horaFin -horaIni) * 60 +  (minFin - minIni);

                        if(libre>= horasJuego){
                            
                            partidas += libre;
                            
                        }
                    }
                    

                    System.out.println(partidas);
                }

                

                


            }
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            
        }
    }

    private static Date pasarDate(String a){
        DateFormat format = new SimpleDateFormat("h:mm");
        Date date = null;            
        try {
            date = format.parse(a);
        }catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
