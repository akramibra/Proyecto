public class datos<T> {
    private T datox;
    public String nombre;
    //le asigna nombres a las variables
    public datos(T datox, String nombre){
        this.datox = datox;
        this.nombre = nombre;
    }
    
    /** 
     * @return T
     */
    //Regresa datox
    public T getValue(){
        return datox;
    }
    
    
    /** 
     * @return Class
     */
    //Regresa el valor
    public Class datoxType(){
        return datox.getClass();
    
    }

}

