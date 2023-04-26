import java.util.ArrayList;

/**
 * Encuestas que realiza el bot
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public abstract class Encuesta {
    
    /**
     * Preguntas de la encuesta
     */
    public ArrayList<Pregunta> preguntas;

    /**
     * Modo de la encuesta
     */
    public String modo;

    /**
     * Regresa la pregunta dado el numero de esta
     * @param numeroPregunta el numero de la pregunta
     * @return la pregunta asociada al numero
     */
    public Pregunta mostrarPregunta(int numeroPregunta);
}
