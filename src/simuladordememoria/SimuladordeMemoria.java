/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simuladordememoria;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author bran
 */
public class SimuladordeMemoria {

    /**
     * @param Nombre
     * @param hojas
     * @param i
     */
     List<ModeloProceso> procesos = new ArrayList<>();
     String memoria[] = new String[4];
     int contador=0;
     int numeroprocesos;
     
     
  
     public void InsertarProceso(String Nombre,int Hojas,int estado,int i){
       int numero=0;
       numeroprocesos=i;
         if(i<=10){
            ModeloProceso proceso = new ModeloProceso();
            proceso.setNombre(Nombre);
            proceso.setHojas(Hojas);
            proceso.setEstado(estado);
            procesos.add(proceso);
            //memoria();
         }
         
        // while(numero<i){
             
            
            // System.out.println("Datos Lista:"+procesos.get(numero).getNombre()+procesos.get(numero).getHojas()+procesos.get(numero).getEstado());
          // numero++;
        
         //}
    }
     
    
     public  List<ModeloProceso> ListProceso(){
         
         return (procesos);
     }
     
     public  String[] memoria(){
          
         //INICIALIZAMOS LA MEMORIA EN 0 
         if(contador ==0){
             memoria[0]="0";
             memoria[1]="0";
             memoria[2]="0";
             memoria[3]="0";
         }
         String nombre;
         int hojas;
         int estado;
         
         
         for(int i=0;i<numeroprocesos;i++){
             
                if(contador !=4){
                    
                    //LA MEMORIA AUN TIENE ESPACIO
                    nombre=procesos.get(i).getNombre();
                    hojas=procesos.get(i).getHojas();
                    estado=procesos.get(i).getEstado();
                    
                    
                    if(contador+hojas<=4){
                        //LA MEMORIA PUEDE GUARDAR AL PROCESO 
                        if(estado==0){
                            for(int l=0;l<hojas;l++){
                                for(int x=0;x<4;x++){
                                        
                                    if(memoria[x]=="0"){
                                        memoria[x]=nombre;
                                        contador++;          //sse incrementa el contador dado que ya fue utilizado un espacio de marco
                                        procesos.get(i).setEstado(3);
                                        x=4;
                                    }
                                }
                            
                            }
                           
                        }
                    
                    }
                }
             
             
                 //System.out.println("Datos Lista memoria:"+procesos.get(i).getNombre()+procesos.get(i).getHojas()+procesos.get(i).getEstado());
                 
         }
         
         return memoria;
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     public int eliminar(String nombreeliminar){
         
         int memorialibre=0;
         String nombre;
         int hojas;
         int estado;
         for(int i=0;i<numeroprocesos;i++){
             
     
                    //OTENEMOS DATOS
                    nombre=procesos.get(i).getNombre();
                    hojas=procesos.get(i).getHojas();
                    estado=procesos.get(i).getEstado();
                    
                    if(nombre.equals(nombreeliminar)){
                        
                         for(int x=0;x<4;x++){
                    
                             if(memoria[x].equals(nombreeliminar)){
                                      memoria[x]="0";
                                      contador=contador-1;
                                      memorialibre++;
                                     // JOptionPane.showMessageDialog(null,"Proceso eliminado de memoria");
                                      procesos.get(i).setEstado(2);   //cambiamos el estado del proceso
                                      memoria();
                                }
                         }
                        
                       
                    }
                  
               
           
         }
         
         
         
         //IGYUALAMOS AUXCONTADOR A CONTADOR YA QUE CONTADOR  TIENE EL NUMERO DE MARCOS DISPONIBLES PERO NO QUEREMOS MODIFICAR LA VARIABLE
         int auxcontador=contador;
         
         //cambiar de estado a de un proceso que tenga las hojas libres disponibles 
         for(int i=0;i<numeroprocesos;i++){
             
                     //OTENEMOS DATOS
                    nombre=procesos.get(i).getNombre();
                    hojas=procesos.get(i).getHojas();
                    estado=procesos.get(i).getEstado();
                  //aqui modificque  
                    if(hojas<=auxcontador+3 && estado==1 ){
                    
                            procesos.get(i).setEstado(0);
                            auxcontador=auxcontador+hojas;
                            memoria();
                            
                    
                    }
                  
                
         }
         
     
         return memorialibre; 
     }
     
     
     
     
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
