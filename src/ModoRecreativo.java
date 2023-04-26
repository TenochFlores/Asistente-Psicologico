import java.util.Scanner;
/**
 * Modo Recreativo del bot
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class ModoRecreativo extends Modo {

    @Override
    public void mostrarIntroduccion() {

        System.out.println("\n******** HOLA Y BIENVENIDO AL MODO RECREATIVO :D ********\n");
        System.out.println("- En este modo analizaremos tu estatus actual de una forma divertida :)\n\n");
        
    }

    @Override
    public void iniciarModo() {

        Scanner sc = new Scanner(System.in);
        String resp, opcTest;
        int test;
        boolean testEscogido = false;
        
        do{

            System.out.println("Escoge el test que quieras realizar: ");
            System.out.println("1. ¿Que tipo de tamal eres?....");
            System.out.println("2. ¿Que tipo de meme eres?....");
            System.out.println("3. ¿Que tipo de caricatura eres?....");
            System.out.println("4. ¿Que tipo de pan eres?....");
            System.out.println("5. ¿Que tipo de Facultad eres?....");
            
            while(true){

                try{
                    System.out.print("Opcion:  ");
                    opcTest = sc.nextLine();
                    test = Integer.parseInt(opcTest);
                    break;
                }catch(NumberFormatException nfe){

                    System.out.println("\nEscribe una opcion valida:");
                    System.out.println("1. ¿Que tipo de tamal eres?....");
                    System.out.println("2. ¿Que tipo de meme eres?....");
                    System.out.println("3. ¿Que tipo de caricatura eres?....");
                    System.out.println("4. ¿Que tipo de pan eres?....");
                    System.out.println("5. ¿Que tipo de Facultad eres?....");

                }

            }

            switch(test){

                case 1:
                    System.out.println("\nBien! Veamos que tipo de tamal eres....");
                    testEscogido = true;
                    encuesta = new EncuestaTamal();
                    break;

                case 2:
                    System.out.println("\nBien! Veamos que tipo de meme eres....");
                    testEscogido = true;
                    encuesta = new EncuestaMeme();
                    break;

                case 3:
                    System.out.println("\nBien! Veamos que tipo de caricatura eres....");
                    testEscogido = true;
                    encuesta = new EncuestaCaricatura();
                    break;

                case 4:
                    System.out.println("\nBien! Veamos que tipo de pan eres....");
                    testEscogido = true;
                    encuesta = new EncuestaPan();
                    break;

                case 5:
                    System.out.println("\nBien! Veamos que tipo de Facultad eres....");
                    testEscogido = true;
                    encuesta = new EncuestaFacultad();
                    break;

                default:
                    System.out.println("\n\nPor favor escoge una opcion valida:\n");
                    break;
            }

        }while(!testEscogido);

        System.out.println("Te voy a realizar la siguiente encuesta para analizar tu situacion, "+
        "tranquilo, no es un examen XD\n");

        for(int i = 1; i<= encuesta.preguntas.length(); ++i){

            encuesta.mostrarPregunta(i);
            resp = sc.nextLine();


        }

        /* Imprime conclusion en base a sus respuestas */
    }

    @Override
    public void despedirse() {

        System.out.println("\n******** ESPERO TE HAYAS DIVERTIDO EN EL TEST, HASTA PRONTO!! ********\n");
    }
    

}
