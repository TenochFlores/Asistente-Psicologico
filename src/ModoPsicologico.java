import java.util.Scanner;

/**
 * Modo Psicologico del bot
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class ModoPsicologico extends Modo {

    @Override
    public void mostrarIntroduccion() {
        
        System.out.println("\n******** HOLA Y BIENVENIDO AL MODO PSICOLOGICO ********\n");
        System.out.println("- En este modo analizaremos tu estatus actual psicologico :)\n\n");
    }

    @Override
    public void iniciarModo() {

        Scanner sc = new Scanner(System.in);
        String resp;
        
        System.out.println("Te voy a realizar la siguiente encuesta para analizar tu situacion, "+
        "no te preocupes, esto no es un examen\n");
        encuesta = new EncuestaPsicologica();   
        for(int i = 1; i<= encuesta.preguntas.length(); ++i){

            encuesta.mostrarPregunta(i);
            resp = sc.nextLine();


        }
    }

    @Override
    public void despedirse() {
        
        System.out.println("\n******** ESPERO TE HAYA SERVIDO MI INFORMACION, HASTA PRONTO!! ********\n");
    }
    
}
