public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Maquina da premio
    private boolean daPremio;
    //Número máximo de billetes
    private int numeroMaxBillete;
    
    private int billetesVendidos;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino,boolean premio,int maximo) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        daPremio = premio;
        billetesVendidos=0;
        numeroMaxBillete = maximo; 
    }
    
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(billetesVendidos >= numeroMaxBillete){
            
                System.out.println("Error, no hay billetes disponibles");
        

         }else{
                if(cantidadIntroducida > 0) {
			balanceClienteActual = balanceClienteActual + cantidadIntroducida;
		}else {
			System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
		}
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        if(billetesVendidos >= numeroMaxBillete ){
            System.out.println("Error, no hay billetes disponibles");
        }else{
            
            if(balanceClienteActual >= precioBillete ) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
                
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;    
                
                billetesVendidos=billetesVendidos+1;
                
                if (daPremio==true) {
                    //Simula la impresion de billete regalo
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("billete regalo");
                    System.out.println("##################");
                    System.out.println();
                    
                    billetesVendidos=billetesVendidos+1;
              }
              
            }  
            else {
                System.out.println("Necesitas introducir " + (precioBillete - balanceClienteActual) + " euros mas!");
            }
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero()
    {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    /**
     * Vacia la máquina si no hay una operacion en curso.
     */
    public int vaciarDineroDeLaMaquina(){
    int vaciarDineroDeLaMaquina = -1;
       
    if (balanceClienteActual == 0){
        vaciarDineroDeLaMaquina = totalDineroAcumulado;
        totalDineroAcumulado = 0;
        System.out.println("Devolución" + vaciarDineroDeLaMaquina);
    } else {
        System.out.println("Error, operación en curso");
    }
    return vaciarDineroDeLaMaquina;
   }
}
