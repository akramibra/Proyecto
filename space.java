import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* CLASE DDONDE SE MUESTRA EL ESPACION DE EJECUCION DEL PROGRAMA - SINGLETON
*/
public class space {
     
    factory factory = new factory();
    HashMap<String,datos> Hashvar = new HashMap<>();
    operadores operators = new operadores();

    private static space env;// variable predefinida
    private space(){
    
    }
    
    /** 
     * @return space
     */
    public synchronized static space getInstance() {
        if (env == null) {
            
            env = new space();
        }
        return env;
    }
    
     
     /** 
      * @param instructions
      */
     private synchronized void print(String instructions){
        instructions = instructions.replaceAll("print", "");
        Pattern patron = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE); 
	Matcher Emp = patron.matcher(instructions);
        if(Emp.find()){
            System.out.println(Emp.group().trim());
        }
        patron = Pattern.compile("['][a-z]+[']", Pattern.CASE_INSENSITIVE); 
        Emp = patron.matcher(instructions);
        if (Emp.find()) { 
                 String temp = Emp.group().trim();
                 temp = temp.replaceAll("'", "");
                 System.out.println(temp);
        }
        
        patron = Pattern.compile("[ ]+[a-z]+[ ]*", Pattern.CASE_INSENSITIVE); 
        Emp = patron.matcher(instructions);
        if(Emp.find()){
            if(Hashvar.containsKey(Emp.group().trim())){
                 System.out.println(Hashvar.get(Emp.group().trim()).getValue());
            }else{
                System.out.println((Emp.group().trim()) + "\t no esta definida");
            }
        }
        
    }
    /** 
     * @param instructions
     * @param result
     */
    public synchronized void ejecutar(String instructions, String result){
        if(result != null){
                    switch(result){
                        case "END":{
                            System.out.println("Saliendo del programa...");
                            System.exit(0);
                            
                        }break;
                        
                        case "PRINT":{
                            print(instructions);
                            
                        }break;
                        
                        case "NEWVAR":{
                            datos temp = factory.VariableCreator(instructions);
                            if(temp != null){
                            Hashvar.put(temp.nombre, temp);
                                System.out.println("Variable " + temp.nombre + " creada exitosamente.");
                            }
                        }break;
                        
                        case "SUM":{
                            operators.suma(instructions, Hashvar);
                        }break;
                        case "QUIT":{
                            operators.resta(instructions, Hashvar);
                        }break;
                        case "MUL" + "" :{
                            operators.multiplicacion(instructions, Hashvar);
                        }break;
                        case "DIV":{
                            operators.div(instructions, Hashvar);
                        }break;
                        
                    }
                }else{
                    System.out.println("ERROR: Instruccion no permitida");
                }
        }   
}