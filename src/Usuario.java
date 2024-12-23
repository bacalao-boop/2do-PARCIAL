import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class Usuario {
    int id;
    String usuario;
    String contraseña;
    String fotoPerfil;
    String nivel;
    String correo;
    
    public Usuario(){
    
    };
    
    public Usuario (int id,String usuario,String contraseña, String correo){
        this.id=id;
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.fotoPerfil="\\imagenes\\usuario.png";
        this.nivel="base";
        this.correo = correo;
    }
    
    public Usuario (int id,String usuario,String contraseña, String nivel, String correo){
        this.id=id;
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.fotoPerfil="\\imagenes\\usuario.png";
        this.nivel=nivel;
        this.correo = correo;
    }
    
    public Usuario (Usuario aux){
        this.id=aux.getId();
        this.usuario=aux.getUsuario();
        this.contraseña=aux.getContraseña();
        this.fotoPerfil="\\imagenes\\usuario.png";
        this.nivel=aux.getNivel();
        this.correo = aux.getCorreo();
    }
    
    public Usuario (String usuario,String contraseña, String nivel, String correo){
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.fotoPerfil="\\imagenes\\usuario.png";
        this.nivel="base";
        this.correo = correo;
    }

    public int getId(){
        return id;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public String getNivel() {
        return nivel;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setId(int id){
        this.id=id;
    }
    
    public void setCorreo(String correo){
        this.correo=correo;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    
    public boolean Usuario_Existe(File archivo,String nombre) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(" ");  // Dividir el nombre y la contraseña
                String nombreAct = datos[1];
                
                // Comprobar si el nombre coincide
                if (nombre.equals(nombreAct)) {
                    return true;  // El usuario existe
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;  // El usuario no existe
    }
    
    public ArrayList<Usuario> listaUsuarios(File archivo) {
        ArrayList<Usuario> lista = new ArrayList<>();  // Cambiado de arreglo a ArrayList
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(" ");  // Dividir el nombre, contraseña y nivel
                int id = Integer.parseInt(datos[0]);

                lista.add(new Usuario(id, datos[1], datos[2], datos[3], datos[4]));  // Usar add() para agregar elementos a la lista
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return lista;
    }
    
    public void Registrar_Usuario(Usuario act,String direccion) {
        File direcUsuarios= new File(direccion);
        
        try (FileWriter writer = new FileWriter(direcUsuarios, true)) {
            writer.write(act.getId()+ " " +act.getUsuario() + " " + act.getContraseña() + " " + act.getNivel() + " " + act.getCorreo() + "\n");
            System.out.println("Usuario registrado correctamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public void eliminarUsuario(String userHome, Usuario act) {
        File archivoUsuarios = new File(userHome + "\\Taskflow\\Usuarios.txt");
        File archivoTemporal = new File(userHome + "\\Taskflow\\auxiliar.txt");
        File archivoTareas = new File(userHome + "\\Taskflow\\Tareas\\Usuario" + act.getId());

        // Primero eliminamos la carpeta de tareas del usuario
        if (!eliminarCarpeta(archivoTareas)) {
            System.out.println("No se pudo eliminar la carpeta de tareas del usuario.");
        }

        // Creamos archivo temporal para almacenar datos sin el usuario a eliminar
        try {
            if (archivoTemporal.createNewFile()) {
                // Archivo auxiliar creado con éxito
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo temporal.");
            e.printStackTrace();
        }

        // Eliminar usuario del archivo de usuarios
        String lineaABorrar = act.getId() + " " + act.getUsuario() + " " + act.getContraseña() + " " + act.getNivel() + " " + act.getCorreo();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoUsuarios));
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
        } catch (IOException e) {
            System.out.println("Error al intentar eliminar al usuario.");
            e.printStackTrace();
        }

        if (archivoUsuarios.delete()){
            archivoTemporal.renameTo(archivoUsuarios);
            System.out.println("Usuarios.txt eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo de usuarios.txt");
            System.out.println("Resultado de delete(): " + archivoUsuarios.delete());
        }
        // Eliminar tareas asociadas al usuario
        eliminarTareasDelUsuario(act, userHome);
    }

    public void editarNivel(String userHome, Usuario ant, Usuario act) {
        File archivoUsuarios = new File(userHome + "\\Taskflow\\Usuarios.txt");
        File archivoTemporal = new File(userHome + "\\Taskflow\\auxiliar.txt");

        // Creamos archivo temporal para almacenar datos sin el usuario a eliminar
        try {
            if (archivoTemporal.createNewFile()) {
                // Archivo auxiliar creado con éxito
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo temporal.");
            e.printStackTrace();
        }

        // Eliminar usuario del archivo de usuarios
        String lineaBuscar= ant.getId() + " " + ant.getUsuario() + " " + ant.getContraseña() + " " + ant.getNivel() + " " + ant.getCorreo();
        String lineaEditada= act.getId() + " " + act.getUsuario() + " " + act.getContraseña() + " " + act.getNivel() + " " + act.getCorreo();
        System.out.println("linea a editar: "+lineaBuscar);
        System.out.println("linea nueva: "+lineaEditada);
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoUsuarios));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String lineaActual;
            while ((lineaActual = lector.readLine()) != null) {
                if (!lineaActual.equals(lineaBuscar)) {
                    if(!lineaActual.equals("") && !lineaActual.isEmpty()){
                        escritor.write(lineaActual);
                        escritor.newLine();
                        System.out.println(lineaActual);
                    }
                }else{
                    if(!lineaActual.equals("") && !lineaActual.isEmpty()){
                        escritor.write(lineaEditada);
                        escritor.newLine();
                        System.out.println(lineaEditada);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al intentar editar al usuario.");
            e.printStackTrace();
        }

        if (archivoUsuarios.delete()){
            archivoTemporal.renameTo(archivoUsuarios);
            System.out.println("Usuarios.txt eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo de usuarios.txt");
            System.out.println("Resultado de delete(): " + archivoUsuarios.delete());
        }
    }
    private void eliminarTareasDelUsuario(Usuario usuario, String userHome) {
    String direcTareas = userHome + "\\Taskflow\\Tareas";
    ArrayList<Tarea> lista = new ArrayList<>(); // Cambiado de arreglo a ArrayList
    Tarea aux = new Tarea();
    
    // Usamos ArrayList en lugar de arreglo
    lista = aux.ListaTareas(direcTareas);
    String direc=direcTareas;
    direcTareas=direcTareas+"\\";

    // Usamos un bucle tradicional para recorrer el ArrayList
    for (int a = 0; a < lista.size(); a++) { // Cambio de lista.length a lista.size()
        if (lista.get(a).getUsuarioAsignado().equals(usuario.getUsuario())) { 
            String direcTarea = direcTareas + lista.get(a).getNumeroTarea() + ".txt";
            String listaTareas = direcTareas + "ListaTareas.txt";
            aux.eliminarTarea(direcTarea, lista.get(a), listaTareas,direc);
        }
    }
}
    
    public boolean eliminarCarpeta(File carpeta) {
        // Verificar si la carpeta existe y es un directorio
        if (carpeta.exists() && carpeta.isDirectory()) {
            // Obtener los archivos dentro de la carpeta
            String[] archivos = carpeta.list();

            // Eliminar los archivos dentro de la carpeta
            for (String archivo : archivos) {
                File archivoTemp = new File(carpeta, archivo);
                if (archivoTemp.isDirectory()) {
                    // Llamar recursivamente si es una subcarpeta
                    eliminarCarpeta(archivoTemp);
                } else {
                    // Eliminar archivo si es un archivo regular
                    archivoTemp.delete();
                }
            }
            // Ahora que la carpeta está vacía, eliminar la carpeta
            return carpeta.delete();  // Devuelve true si la carpeta se eliminó correctamente
        } else {
            System.out.println("La carpeta no existe o no es un directorio.");
            return false;
        }
    }
    
    public void editarUsuario(String direcUsuarios,String userHome,Usuario act,Usuario ant){
        File archivoUsuarios=new File(direcUsuarios);
        File archivoTemporal = new File(userHome+"\\Taskflow\\auxiliar.txt");
        
        try {
            if (archivoTemporal.createNewFile()) {
                
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
        
        FileWriter escribir;
        PrintWriter linea;
        String lineaEditar =ant.getId()+" "+ ant.getUsuario()+" "+ant.getContraseña()+" "+ant.getNivel()+" "+ant.getCorreo();
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoUsuarios));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String lineaActual;

            while ((lineaActual = lector.readLine()) != null) {
                if (!lineaActual.equals(lineaEditar)) {
                    escritor.write(lineaActual);
                    escritor.newLine();
                }else{
                    escritor.write(act.getId()+ " " +act.getUsuario() + " " + act.getContraseña() + " " + act.getNivel() + " " + act.getCorreo());
                    escritor.newLine();
                }
            }

            lector.close();
            escritor.close();

            if (archivoUsuarios.delete()) {
                archivoTemporal.renameTo(archivoUsuarios);
                System.out.println("Línea borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar la línea del archivo.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar borrar la línea.");
            e.printStackTrace();
        }
        
        String tareasDir = userHome + "\\Taskflow\\Tareas\\";
        Tarea aux = new Tarea();
        ArrayList<Tarea> lista = aux.ListaTareas(tareasDir);  // Cambiado de arreglo a ArrayList
        String listaTareasPath = tareasDir + "ListaTareas.txt";

        int totalTareas = aux.tareasTotal(listaTareasPath);

        // Iterar sobre las tareas y actualizar las asignaciones de usuario
        for (int a = 0; a < totalTareas; a++) {
            if (lista.get(a).getUsuarioAsignado().equals(ant.getUsuario())) {
                Tarea temporal = lista.get(a);
                temporal.setUsuarioAsignado(act.getUsuario());
                String direcTareas = tareasDir + temporal.getNumeroTarea() + ".txt";
                aux.editarTarea(direcTareas, temporal, listaTareasPath, lista.get(a));
            }
        }
    }
    
    public int IDUsuarioNuevo(String direccion){
        int numero=0;
        File archivo=new File (direccion);
        String contenido="";
        Usuario aux=new Usuario();
        
        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            contenido = lectura.readLine();
            while(contenido != null){
                String[] datos = contenido.split(" ");
                aux.setId(Integer.parseInt(datos[0]));
                numero=aux.getId();
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
    
    public void guardarUsuarioActual(Usuario act){
        String userHome = "C:\\Users\\Cesia\\Desktop";
        File usuarioAct = new File(userHome + "\\Taskflow\\UsuarioActual.txt");
        vaciarArchivo(userHome + "\\Taskflow\\UsuarioActual.txt");
        
        try (FileWriter writer = new FileWriter(usuarioAct, true)) {
            writer.write(act.getId()+ " " +act.getUsuario() + " " + act.getContraseña() + " " + act.getNivel() + " " + act.getCorreo() + "\n");
            System.out.println("Usuario registrado correctamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public void vaciarArchivo(String direc){
         try {
            FileWriter fileWriter = new FileWriter(direc);
            
            fileWriter.close(); 
            System.out.println("Archivo vaciado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Usuario obtenerUsuarioActual(){
        String userHome = "C:\\Users\\Cesia\\Desktop";
        File usuarioAct = new File(userHome + "\\Taskflow\\UsuarioActual.txt");
        
        Usuario act=new Usuario(0,null,null,null,null);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(usuarioAct))) {
            String linea= reader.readLine();
            
            String[] datos = linea.split(" ");
            int id = Integer.parseInt(datos[0]);
                
            act= new Usuario(id,datos[1], datos[2] , datos[3], datos[4]);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return act;
    }
}
