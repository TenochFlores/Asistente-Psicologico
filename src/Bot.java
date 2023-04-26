import java.util.Scanner;

/**
 * Clase del bot 
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class Bot {

    /** Usuario actual */
    private UsuarioProxy user;

    /** Objeto de la base de datos */
    private BDDUsuarios bdd = new BDDUsuarios();

    /**
     * Registra al usuario
     * @param args
     */
    public void registar(){

        Scanner s = new Scanner(System.in);
        String  nombre, edad, usuario, telefono, carrera;
        int age;
        long tel;

        

        System.out.println("- Escribe tu nombre: ");
        nombre = s.nextLine();
        System.out.println("- Escribe tu edad: ");
        while(true){

            try{
                edad = s.nextLine();
                age = Integer.parseInt(edad);
                break;

            }catch(NumberFormatException nfe){
                System.out.print("\nDigita un numero por favor:  ");
                continue;
            }

            if(age > 2 && age < 110)
                break;
            else 
                System.out.print("\nDigita una edad valida:  ");

        }

        System.out.println("- Escribe un nombre de usuario: ");
        usuario = s.nextLine();

        System.out.println("- Escribe tu telefono: ");
        while(true){

            try{
                telefono = s.nextLine();
                tel = Integer.parseInt(telefono);
                break;

            }catch(NumberFormatException nfe){
                System.out.print("\nDigita un numero por favor:  ");
                continue;
            }

        }

        System.out.println("- Escribe la carrera que estas estudiando:  ");
        carrera = s.nextLine();

        if(bdd.existeUsuario(nombre, edad, usuario, edad, telefono, carrera)){

            System.out.println("\n-> Parece que ya has sido registrado anteriormente, bienvenido de vuelta "+
            usuario+"\n");
            user = bdd.obtenerUsuario(usuario);
            
        }else{

            user = bdd.agregarUsuario(nombre, edad, usuario, edad, telefono, carrera);
            System.out.println("\n-> Usuario registrado correctamente!\n");
        }


    }

    public static void main(String[] args) {


        /* Si es con el bot de telegram hacer metodos de: escribirMensaje(String mensaje), 
            String leerMensaje() */
        
        /* Iniciando ejecucion */
        Bot bot = new Bot();
        Modo modo;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        boolean wrongOpc;
        String opcion;
        int opc;

        System.out.println("\n>>>>>>>> HOLA, SOY BUZZ, EL BOT QUE TE EVALUA ;^) <<<<<<<<");
        System.out.println("-- Espero mis servicios te sirvan :D --");
        System.out.println("-> Primero vamos a registrate:");
        bot.registar();
        

        System.out.println("-> Tengo dos modos para evaluar:");
        System.out.println("\t1. Modo Psicologico: Te evaluare para ver como te encuentras psicologicamente");
        System.out.println("\t2. Modo Recreativo: Escoge de mis varias evaluaciones divertidas que tengo "+
        "preprarado para ti!");


        do{

            while(true){
                
                try{

                    System.out.print("Opcion:  ");
                    opcion = sc.nextLine();
                    opc = Integer.parseInt(opcion);
                    break;
                }catch(NumberFormatException nfe){

                    System.out.println("Escribe una opcion valida por favor:  ");
                    System.out.println("\t1. Modo Psicologico: Te evaluare para ver como te encuentras psicologicamente");
                    System.out.println("\t2. Modo Recreativo: Escoge de mis varias evaluaciones divertidas que tengo "+
                    "preprarado para ti!");
                }

            }  
            
            switch(opc){

                case 1:
                    System.out.println("\nPasando al Modo Psicologico....\n");
                    modo = new ModoPsicologico();
                    modo.ejecutar();
                    wrongOpc = false;
                    break;

                case 2:
                    System.out.println("\nPasando al Modo Recreativo....\n");
                    modo = new ModoRecreativo();
                    modo.ejecutar();
                    wrongOpc = false;
                    break;

                default:
                    System.out.println("Escoge una opcion valida por favor:  ");
                    System.out.println("\t1. Modo Psicologico: Te evaluare para ver como te encuentras psicologicamente");
                    System.out.println("\t2. Modo Recreativo: Escoge de mis varias evaluaciones divertidas que tengo "+
                    "preprarado para ti!");
                    wrongOpc = true;
                    break;

            }

            if(wrongOpc)
                continue;

            System.out.print("\n¿Deseas terminar por hoy?[Si/No]:");
            String opcSalida;
            while(true){

                opcSalida = sc.nextLine();
                opcSalida = opcSalida.toLowerCase();
                if(opcSalida.equals("si") || opcSalida.equals("no"))
                    break;
                    
                System.out.println("\nPor favor escribe Si o No:  ");
            }

            if(opcSalida.equals("si")){
            
                System.out.println("\n********* HASTA LUEGO, ESPERO MIS SERVICIOS HAYAN SIDO DE UTILIDAD :D *********\n");
                salir = true;
            }else {

                System.out.println("De acuerdo!, escoge de nuevo el modo con el que quieras que te evalue:");
                System.out.println("\t1. Modo Psicologico: Te evaluare para ver como te encuentras psicologicamente");
                System.out.println("\t2. Modo Recreativo: Escoge de mis varias evaluaciones divertidas que tengo "+
                "preprarado para ti!");
            }


        }while(!salir);

    }
}
