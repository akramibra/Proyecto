import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* CLASE ENCARGADA DE LA CREACION INICIAL DE INSTRUCCIONES CON LOS DIFERENTES PATRONES DE COMPILACION
*/

public class factory {

    /** 
     * @param instructions
     * @return datos
     */
    public datos VariableCreator(String instructions) {
        //Case Insinsitive - identificador que acepten diferentes valores de tipo String
        Pattern patron = Pattern.compile("[ ]+[a-zA-Z0-9]+[ ]+", Pattern.CASE_INSENSITIVE); //
	    Matcher Emp = patron.matcher(instructions);
	    String namebar = ""; 
            if (Emp.find()) {
	        namebar = Emp.group();
                namebar = namebar.replaceAll(" ", "");
            //verifica si es un valor numerico o no
            patron = Pattern.compile("[ ]+[0-9]+[ ]*", Pattern.CASE_INSENSITIVE); //
            Emp = patron.matcher(instructions);
	        
            if (Emp.find()) { 
                //si es un valor de tipo int, regresa un valor del mismo tipo
	    	    return new datos<Integer>(Integer.parseInt(Emp.group().trim()), namebar);
            }
            patron = Pattern.compile("[ ]+['][a-zA-Z0-9]+['][ ]*", Pattern.CASE_INSENSITIVE); //
            Emp = patron.matcher(instructions);
            
            if (Emp.find()) { 
                String temp = Emp.group().trim();
                temp = temp.replaceAll("'", "");
                return new datos<String>(temp, namebar); 
            }
            }
            else{
                System.out.println("ERROR: Sintaxis invalida");
                return null;
            }
            return null;
    }
}