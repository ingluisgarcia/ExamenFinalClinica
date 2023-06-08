import java.util.Calendar;

import java.text.SimpleDateFormat;

public class Paciente {
    private String documento, nombre, fechaIngreso, fechaAlta, sintomas;

    public Paciente(String documento, String nombre, String sintomas){
        this.documento = documento;
        this.nombre = nombre;
        this.sintomas = sintomas;
        fechaIngreso = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        fechaAlta = null;
    }

    public String getDocumento(){
        return documento;
    }

    public String getNombre(){
        return nombre;
    }

    public String getSintoma(){
        return sintomas;
    }

    public String getFechaIngreso(){
        return fechaIngreso;
    }

    public String getFechaAlta(){
        return fechaAlta;
    }

    public void setFechaAlta(){
        fechaAlta = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }


}
