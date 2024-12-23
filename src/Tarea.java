import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Tarea {
    public int numTarea;
    public String nombre;
    public String descripcion;
    public String prioridad;
    public String estado;
    public String comentario;
    public String usuarioAsignado;
    public int dia;
    public String mes;
    public int year;
    
    public Tarea(){
    }
    
    public Tarea(int NumeroTarea,String Nombre,String Descripcion,String Prioridad,String UsuarioAsignado,int dia,String mes,int year){
        numTarea=NumeroTarea;
        nombre=Nombre;
        descripcion=Descripcion;
        prioridad=Prioridad;
        estado="Por hacer";
        comentario=null;
        usuarioAsignado=UsuarioAsignado;
        this.dia=dia;
        this.mes=mes;
        this.year=year;
    }
    
    public Tarea(int NumeroTarea,String Nombre,String Descripcion,String Prioridad,String UsuarioAsignado,int dia,String mes){
        numTarea=NumeroTarea;
        nombre=Nombre;
        descripcion=Descripcion;
        prioridad=Prioridad;
        estado="Por hacer";
        comentario=null;
        usuarioAsignado=UsuarioAsignado;
        this.dia=dia;
        this.mes=mes;
    }
    
    public Tarea(int NumeroTarea,String Nombre,String Descripcion,String Prioridad,String Estado,String UsuarioAsignado,int dia,String mes){
        numTarea=NumeroTarea;
        nombre=Nombre;
        descripcion=Descripcion;
        prioridad=Prioridad;
        estado=Estado;
        comentario=null;
        usuarioAsignado=UsuarioAsignado;
        this.dia=dia;
        this.mes=mes;
    }
    public Tarea(Tarea aux){
        numTarea=aux.getNumeroTarea();
        nombre=aux.getNombre();
        descripcion=aux.getDescripcion();
        prioridad=aux.getPrioridad();
        estado=aux.getEstado();
        comentario=null;
        usuarioAsignado=aux.getUsuarioAsignado();
        this.dia=aux.getDia();
        this.mes=aux.getMes();
        this.year=aux.getYear();
    }

    public int getYear() {
        return year;
    }

    public int getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public int getNumeroTarea(){
        return numTarea;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public String getComentario() {
        return comentario;
    }

    public String getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setNumeroTarea(int numero) {
        this.numTarea = numero;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setUsuarioAsignado(String usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }
    
    public void setDia(int dia){
        this.dia=dia;
    }
    
    public void setMes(String mes){
        this.mes=mes;
    }
    
    public void setYear(int year){
        this.year=year;
    }
    
    public void eliminarTarea(String direccion, Tarea tarea, String listaTareas,String direc) {
        // Elimina la tarea de la lista de tareas
        File lista = new File(listaTareas);
        String lineaABorrar = tarea.getNumeroTarea() + "|" + tarea.getNombre();

        File archivoTemporal = new File(direc+ "\\auxiliar.txt");
        try {
            

            try (BufferedReader lector = new BufferedReader(new FileReader(lista));
                 BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal))) {
                String lineaActual;
                while ((lineaActual = lector.readLine()) != null) {
                    if (!lineaActual.equals(lineaABorrar)) {
                        if(!lineaActual.equals("") && !lineaActual.isEmpty()){
                            escritor.write(lineaActual);
                            escritor.newLine();
                        }
                    }
                }
            }

            
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar eliminar la tarea.");
            e.printStackTrace();
        }
        if (lista.delete()) {
                archivoTemporal.renameTo(lista);
                System.out.println("Tarea eliminada de la lista.");
            }else{
                System.out.println("No se pudo eliminar la Tarea"+tarea.getNumeroTarea()+" de la lista");
            }

            // Elimina el archivo de la tarea
            File archivo = new File(direccion);
            if (archivo.delete()) {
                System.out.println("Archivo de tarea eliminado.");
            }else{
                System.out.println("No se pudo eliminar la Tarea"+tarea.getNumeroTarea());
                System.out.println("Resultado de delete(): " + archivo.delete());
            }
    }
    
    public void CrearNuevaTarea (String direccion,Tarea act){
        File archivo =new File(direccion + "\\"+ act.getNumeroTarea()+".txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado en: " + archivo.getAbsolutePath());
            } else {
                System.out.println("El archivo ya existe en: " + archivo.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }
    
    public void guardarTarea (String direccion,Tarea act,String listaTareas){
        File archivo=new File(direccion+"\\"+act.getNumeroTarea()+".txt");
        FileWriter escribir;
        PrintWriter linea;
        File ListaTareas=new File(listaTareas);
        
        try{
            escribir = new FileWriter(ListaTareas,true);
            linea = new PrintWriter(escribir);
            if(ListaTareas.length() == 0)
                escribir.write(act.getNumeroTarea()+"|"+act.getNombre()+"\n");
            else
                escribir.write(act.getNumeroTarea()+"|"+act.getNombre()+"\n");
            linea.close();
        }catch(IOException exepcion){
            exepcion.printStackTrace(System.out);
        }
        
        try {
            escribir = new FileWriter(archivo,true);
            linea = new PrintWriter(escribir);
            escribir.write("NumeroTarea:"+act.getNumeroTarea()+"\n");
            escribir.write("Nombre:"+act.getNombre()+"\n");
            escribir.write("Descripcion:"+act.getDescripcion()+"\n");
            escribir.write("Prioridad:"+act.getPrioridad()+"\n");
            escribir.write("Estado:"+act.getEstado()+"\n");
            escribir.write("UsuarioAsignado:"+act.getUsuarioAsignado()+"\n");
            escribir.write("Comentario:"+act.getComentario()+"\n");
            escribir.write("Dia:"+act.getDia()+"\n");
            escribir.write("Mes:"+act.getMes()+"\n");
            escribir.write("Año:"+act.getYear()+"\n");
            linea.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar la partida en el archivo: " + e.getMessage());
        }
    }
    
    public Tarea DetallesTarea (String direccion,int NumeroTarea){
        File archivo=new File (direccion);
        String contenido=null;
        String nombre=null;
        String descripcion=null;
        String prioridad=null;
        String estado=null;
        String comentario=null;
        String usuarioAsignado=null;
        int dia=0;
        String mes= null;
        int year=0;
        
        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            contenido = lectura.readLine();
            while(contenido != null){
                if(contenido.contains("Nombre:")){
                    nombre=contenido.substring(7,contenido.length());
                }
                if(contenido.contains("Descripcion:")){
                    descripcion=contenido.substring(12,contenido.length());
                }
                if(contenido.contains("Prioridad:")){
                    prioridad=contenido.substring(10,contenido.length());
                }
                if(contenido.contains("Estado:")){
                    estado=contenido.substring(7,contenido.length());
                }
                if(contenido.contains("UsuarioAsignado:")){
                    usuarioAsignado=contenido.substring(16,contenido.length());
                }
                if(contenido.contains("Comentario:")){
                    comentario=contenido.substring(11,contenido.length());
                }
                if(contenido.contains("Dia:")){
                    String aux=contenido.substring(4,contenido.length());
                    dia=Integer.parseInt(aux);
                }
                if(contenido.contains("Mes:")){
                    mes=contenido.substring(4,contenido.length());
                }
                if(contenido.contains("Año:")){
                    String aux=contenido.substring(4,contenido.length());
                    year=Integer.parseInt(aux);
                }
                contenido = lectura.readLine();
            }
        } catch (IOException excepcion) {
            excepcion.printStackTrace();
        }
        Tarea nueva=new Tarea(NumeroTarea,nombre,descripcion,prioridad, estado,usuarioAsignado,dia,mes);
        nueva.setYear(year);
        return nueva;
    }
    
    public int numeroNuevaTarea(String direccion){
        int numero=0;
        File archivo=new File (direccion);
        String contenido="";
        Tarea aux=new Tarea();
        
        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            contenido = lectura.readLine();
            while(contenido != null){
                aux=aux.indiceTarea(contenido);
                numero=aux.getNumeroTarea();
                contenido = lectura.readLine();
            }
        } catch (IOException excepcion) {
            numero=0;
        }
        
        if(numero!=0)
            return numero+1;
        else
            return 1;
    }
    
    public int tareasTotal(String direccion){
        int numero=0;
        File archivo=new File (direccion);
        String contenido="";
        
        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            contenido = lectura.readLine();
            while(contenido != null){
                numero++;
                contenido = lectura.readLine();
            }
        } catch (IOException excepcion) {
            numero=0;
        }
        return numero;
    }
    
    public Tarea indiceTarea(String contenido){
        int aux=0;
        int n=0;
        for(char c: contenido.toCharArray()){
            if(c=='|'){
                aux=n;
            }
            n++;
        }
        String nombre=contenido.substring(aux+1,contenido.length());
        String numero=contenido.substring(0,aux);
        int num=Integer.parseInt(numero);
        Tarea act = new Tarea (num,nombre,null,null,null,0,null);
        return act;
    }
    
    
    //direccion=userHome/taskflow/Tareas/numTarea.txt
    public void editarTarea(String direccion,Tarea act, String listaTareas, Tarea ant){
        String userHome = "C:\\Users\\Cesia\\Desktop";
        File archivo=new File(direccion);
        FileWriter escribir;
        PrintWriter linea;
        File ListaTareas=new File(listaTareas);
        String lineaEditar= ant.getNumeroTarea()+"|"+ant.getNombre();
        
        try {
            File archivoTemporal = new File(userHome + "\\Taskflow\\Tareas\\auxiliar.txt");

            BufferedReader lector = new BufferedReader(new FileReader(ListaTareas));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String lineaActual;

            while ((lineaActual = lector.readLine()) != null) {
                if (!lineaActual.equals(lineaEditar)) {
                    escritor.write(lineaActual);
                    escritor.newLine();
                }else{
                    escritor.write(act.getNumeroTarea()+"|"+act.getNombre());
                    escritor.newLine();
                }
            }

            lector.close();
            escritor.close();
            //sacar del try sino funciona
            if (ListaTareas.delete()) {
                archivoTemporal.renameTo(ListaTareas);
                System.out.println("lista borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
            
            if (archivo.delete()) {
                System.out.println("Línea borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
            
            String direcTareas = userHome + "\\Taskflow\\Tareas";
            act.CrearNuevaTarea(direcTareas, act);
            
            try {
            escribir = new FileWriter(archivo,true);
            linea = new PrintWriter(escribir);
            escribir.write("NumeroTarea:"+act.getNumeroTarea()+"\n");
            escribir.write("Nombre:"+act.getNombre()+"\n");
            escribir.write("Descripcion:"+act.getDescripcion()+"\n");
            escribir.write("Prioridad:"+act.getPrioridad()+"\n");
            escribir.write("Estado:"+act.getEstado()+"\n");
            escribir.write("UsuarioAsignado:"+act.getUsuarioAsignado()+"\n");
            escribir.write("Comentario:"+act.getComentario()+"\n");
            escribir.write("Dia:"+act.getDia()+"\n");
            escribir.write("Mes:"+act.getMes()+"\n");
            escribir.write("Año:"+act.getYear()+"\n");
            linea.close();
            
            } catch (IOException e) {
                System.out.println("Ocurrió un error al guardar la tarea: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar borrar la línea.");
            e.printStackTrace();
        }
    }
    //direc= Taskflow\\Tareas  || Taskflow\\Tareas\\Usuario1
    //direccionTarea= Taskflow\\Tareas\\0.txt
    public void editarCualquierTarea(String direccionTarea,Tarea act, String listaTareas, Tarea ant, String direc){
        String userHome = "C:\\Users\\Cesia\\Desktop";
        File archivo=new File(direccionTarea);
        FileWriter escribir;
        PrintWriter linea;
        File ListaTareas=new File(listaTareas);
        String lineaEditar= ant.getNumeroTarea()+"|"+ant.getNombre();
        
        try {
            File archivoTemporal = new File(direc+"\\auxiliar.txt");

            BufferedReader lector = new BufferedReader(new FileReader(ListaTareas));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String lineaActual;

            while ((lineaActual = lector.readLine()) != null) {
                if (!lineaActual.equals(lineaEditar)) {
                    escritor.write(lineaActual);
                    escritor.newLine();
                }else{
                    escritor.write(act.getNumeroTarea()+"|"+act.getNombre());
                    escritor.newLine();
                }
            }

            lector.close();
            escritor.close();
            //sacar del try sino funciona
            if (ListaTareas.delete()) {
                archivoTemporal.renameTo(ListaTareas);
                System.out.println("Línea borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
            
            if (archivo.delete()) {
                System.out.println("Línea borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
            
            act.CrearNuevaTarea(direc, act);
            
            try {
            escribir = new FileWriter(archivo,true);
            linea = new PrintWriter(escribir);
            escribir.write("NumeroTarea:"+act.getNumeroTarea()+"\n");
            escribir.write("Nombre:"+act.getNombre()+"\n");
            escribir.write("Descripcion:"+act.getDescripcion()+"\n");
            escribir.write("Prioridad:"+act.getPrioridad()+"\n");
            escribir.write("Estado:"+act.getEstado()+"\n");
            escribir.write("UsuarioAsignado:"+act.getUsuarioAsignado()+"\n");
            escribir.write("Comentario:"+act.getComentario()+"\n");
            escribir.write("Dia:"+act.getDia()+"\n");
            escribir.write("Mes:"+act.getMes()+"\n");
            escribir.write("Año:"+act.getYear()+"\n");
            linea.close();
            
            } catch (IOException e) {
                System.out.println("Ocurrió un error al guardar la tarea: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar borrar la línea.");
            e.printStackTrace();
        }
    }
    
    
    //direc=userHome/taskflow/Tareas    para tareas admin
    //direc=userHome/taskflow/Tareas/Id+Usuario/  para mis tareas
    public ArrayList<Tarea> ListaTareas(String direc) {
        File archivo = new File(direc + "\\ListaTareas.txt");
        String contenido = "";
        ArrayList<Tarea> act = new ArrayList<>(); // Cambiado de arreglo a ArrayList
        Tarea aux = new Tarea();

        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            contenido = lectura.readLine();
            while (contenido != null) {
                act.add(aux.indiceTarea(contenido)); // Usar add() para agregar al ArrayList
                contenido = lectura.readLine();
            }
        } catch (IOException excepcion) {
            excepcion.printStackTrace();
        }

        for (int ind = 0; ind < act.size(); ind++) {
            String direccion = direc + "\\" + act.get(ind).getNumeroTarea() + ".txt";
            act.set(ind, aux.DetallesTarea(direccion, act.get(ind).getNumeroTarea())); // Usar set() para actualizar elementos
        }

        return act;
    }
    
    public Date getFechaEntrega() {
        // Si el year es 0, usamos el año actual
        int yearToUse = (year != 0) ? year : java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        String monthStr = mes;
        int month = convertirMesAMesNumero(monthStr);  // Convierte el nombre del mes al número (enero = 1, febrero = 2, etc.)

        // Crea un objeto Date con el año proporcionado (o el actual), mes y día
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(yearToUse, month - 1, dia);  // Ajustamos el mes (0 = enero)
        return cal.getTime();
    }

    // Método para convertir el nombre del mes a un número
    private int convertirMesAMesNumero(String mes) {
        switch (mes) {
            case "Enero": return 1;
            case "Febrero": return 2;
            case "Marzo": return 3;
            case "Abril": return 4;
            case "Mayo": return 5;
            case "Junio": return 6;
            case "Julio": return 7;
            case "Agosto": return 8;
            case "Septiembre": return 9;
            case "Octubre": return 10;
            case "Noviembre": return 11;
            case "Diciembre": return 12;
            default: return 1; // Si el mes no es válido, asignamos enero por defecto.
        }
    }
}
