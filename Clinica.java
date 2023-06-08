import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Clinica {
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static Scanner otroLeer = new Scanner(System.in);
    static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        
        String documento, nombre, sintoma, fechaSalida;
        int menu, pos;
        boolean enFuncionamiento = true;
        while(enFuncionamiento){
            menuPrincipal();
            menu = otroLeer.nextInt();
            switch(menu){
                case 1:
                    if(!listaPacientes.isEmpty()){
                        System.out.println("Ingrese el documento del paciente");
                        documento = leer.readLine();
                        System.out.println("Ingrese el nombre del paciente");
                        nombre = leer.readLine();
                        System.out.println("Ingrese los sintomas por el cual ingresa por urgencia");
                        sintoma = leer.readLine();
                        listaPacientes.add(new Paciente(documento, nombre, sintoma));
                    }else{
                        boolean enAtencion = false;
                        System.out.println("Ingrese el documento del paciente");
                        documento = leer.readLine();
                        for(int i = 0; i<listaPacientes.size(); i++){
                            if(listaPacientes.get(i).getDocumento().equals(documento) && listaPacientes.get(i).getFechaAlta() == null){
                                enAtencion = true;
                            }
                        }
                        if(!enAtencion){
                            System.out.println("Ingrese el nombre del paciente");
                            nombre = leer.readLine();
                            System.out.println("Ingrese los sintomas por el cual ingresa por urgencia");
                            sintoma = leer.readLine();
                            listaPacientes.add(new Paciente(documento, nombre, sintoma));
                        }else{
                            System.out.println("El paciente ya se encuentra en atencion");
                        }
                    }
                break;
                case 2:
                pos = -1;
                System.out.println("Ingrese el documento del paciente");
                documento = leer.readLine();
                for(int i = 0; i<listaPacientes.size(); i++){
                    if(listaPacientes.get(i).getDocumento().equals(documento) && listaPacientes.get(i).getFechaAlta() == null){
                        pos = i;
                    }
                }
                if(pos != -1){
                    listaPacientes.get(pos).setFechaAlta();
                    System.out.println("Paciente dado de alta");
                }else{
                    System.out.println("Paciente no encontrado");
                }
                break;
                case 3:
                    pos = -1;
                    System.out.println("Ingrese el documento del paciente");
                    documento = leer.readLine();
                    for(int i = 0; i<listaPacientes.size(); i++){
                        if(listaPacientes.get(i).getDocumento().equals(documento)){
                            pos = i;
                        }
                    }
                    fechaSalida= "En atencion";
                    if(pos != -1){
                        if(listaPacientes.get(pos).getFechaAlta()!=null){
                            fechaSalida = listaPacientes.get(pos).getFechaAlta();
                        }
                        System.out.println(listaPacientes.get(pos).getDocumento()+"\t"+listaPacientes.get(pos).getNombre()
                        +"\t"+listaPacientes.get(pos).getFechaIngreso()+"\t"+fechaSalida+"\t"+listaPacientes.get(pos).getSintoma());
                    }else{
                        System.out.println("Paciente no encontrado");
                    }
                break;
                case 4:
                    for(int i = 0; i<listaPacientes.size(); i++){
                        fechaSalida= "En atencion";
                        if(listaPacientes.get(i).getFechaAlta()!=null){
                            fechaSalida = listaPacientes.get(i).getFechaAlta();
                        }
                        System.out.println(listaPacientes.get(i).getDocumento()+"\t"+listaPacientes.get(i).getNombre()
                        +"\t"+listaPacientes.get(i).getFechaIngreso()+"\t"+fechaSalida);
                    }
                break;
                case 5:
                    boolean pendientes = false;
                    for(int i = 0; i<listaPacientes.size(); i++){
                        if(listaPacientes.get(i).getFechaAlta()==null){
                            pendientes = true;
                        }
                    }
                    if(!pendientes){
                        enFuncionamiento = false;
                        otroLeer.close();
                    }else{
                        System.out.println("Aún hay pacientes en atencion");
                    }
                break;
            }
        } 
        
    }
    public static void menuPrincipal() {
            System.out.println("Menu principal");
            System.out.println("1. Ingresar paciente");
            System.out.println("2. Alta paciente");
            System.out.println("3. Buscar paciente");
            System.out.println("4. Ver reporte");
            System.out.println("5. Salir");
    }
}
