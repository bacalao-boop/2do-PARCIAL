import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import raven_cell.*;

public class Usuarios extends javax.swing.JFrame {

    Escalar escalar = new Escalar();
    private String userHome = "C:\\Users\\Cesia\\Desktop";
    private String fileUsuarios = userHome + "\\Taskflow\\Usuarios.txt";
    public ArrayList<Usuario> lista;
    private Usuario UsuarioActual=new Usuario();
    public int indice=0;
    private String usuario="";
    public int cont=0;
    /**
     * Creates new form Usuarios
     */
    public Usuarios() {
        initComponents();
        
        setLocationRelativeTo(null);
        escalar.escalarLabel(jLabel1, "\\imagenes\\logo.png");
        escalar.escalarLabel(ImagenUsuario, "\\imagenes\\usuario.png");
        escalar.escalarLabel(lblInicio, "\\imagenes\\Inicio.png");
        escalar.escalarLabel(lblPerfil, "\\imagenes\\Perfil.png");
        escalar.escalarLabel(lblUsuarios, "\\imagenes\\Usuarios.png");
        escalar.escalarLabel(lblTareasActuales, "\\imagenes\\TareasActuales.png");
        escalar.escalarLabel(lblMisTareas, "\\imagenes\\MisTareas.png");
        escalar.escalarLabel(lblHistorial, "\\imagenes\\Historial.png");
        escalar.escalarLabel(lblSalir, "\\imagenes\\Salir.png");
        escalar.escalarLabel(lblEsq, "\\imagenes\\esquina1.png");
        
        UsuarioActual=UsuarioActual.obtenerUsuarioActual();
        lblNombreUsuario.setText(UsuarioActual.getUsuario());
        
        Usuario aux= new Usuario();
        File direcUsuarios = new File(fileUsuarios);
        lista=aux.listaUsuarios(direcUsuarios);
        cont=lista.size();
        rellenarTabla(lista);
    }

    private void buscarUsuario() {
        vaciarTabla();
        for (int aux = 0; aux < lista.size(); aux++) {
                // Verificar si el usuario actual coincide con el usuario de la lista
            if (lista.get(aux).getUsuario().equals(usuario)) {
                // Crear un nuevo objeto de fila para la tabla con los datos del usuario
                Object[] newRow = new Object[] { lista.get(aux).getId(), lista.get(aux).getUsuario(), lista.get(aux).getCorreo(), null };
                addRowWithActionButtons(newRow);  // Llamar a la función para agregar la fila
            }
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        if(rowCount==0){
            JOptionPane.showMessageDialog(null, "No existen este usuario");
            rellenarTabla(lista);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new PanelRound();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ImagenUsuario = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        PR_Perfil = new PanelRound();
        lblPerfil = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PR_Usuarios = new PanelRound();
        lblUsuarios = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PR_TareasActuales = new PanelRound();
        lblTareasActuales = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PR_MisTareas = new PanelRound();
        lblMisTareas = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PR_Salir = new PanelRound();
        lblSalir = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PR_Inicio = new PanelRound();
        lblInicio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PR_Historial = new PanelRound();
        lblHistorial = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Pantalla = new PanelRound();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        PRUsuarios = new PanelRound();
        BTBuscar = new PanelRound();
        jLabel3 = new javax.swing.JLabel();
        lblEsq = new javax.swing.JLabel();
        TF_Buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        BTReiniciar = new PanelRound();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(25, 35, 60));
        Menu.setRoundBottomLeft(50);
        Menu.setRoundBottomRight(50);
        Menu.setRoundTopLeft(50);
        Menu.setRoundTopRight(50);
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Menu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, 10));
        Menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 120, 90));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TASKFLOW");
        Menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 110, 40));
        Menu.add(ImagenUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 50, 50));

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Usuario");
        Menu.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 100, 30));

        PR_Perfil.setBackground(new java.awt.Color(25, 35, 60));
        PR_Perfil.setRoundBottomLeft(25);
        PR_Perfil.setRoundBottomRight(25);
        PR_Perfil.setRoundTopLeft(25);
        PR_Perfil.setRoundTopRight(25);
        PR_Perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_PerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_PerfilMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_PerfilMousePressed(evt);
            }
        });
        PR_Perfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPerfil.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                lblPerfilComponentHidden(evt);
            }
        });
        PR_Perfil.add(lblPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Perfil");
        PR_Perfil.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 50));

        Menu.add(PR_Perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, 50));

        PR_Usuarios.setBackground(new java.awt.Color(25, 35, 60));
        PR_Usuarios.setRoundBottomLeft(25);
        PR_Usuarios.setRoundBottomRight(25);
        PR_Usuarios.setRoundTopLeft(25);
        PR_Usuarios.setRoundTopRight(25);
        PR_Usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_UsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_UsuariosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_UsuariosMousePressed(evt);
            }
        });
        PR_Usuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_Usuarios.add(lblUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuarios");
        PR_Usuarios.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 50));

        Menu.add(PR_Usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 50));

        PR_TareasActuales.setBackground(new java.awt.Color(25, 35, 60));
        PR_TareasActuales.setRoundBottomLeft(25);
        PR_TareasActuales.setRoundBottomRight(25);
        PR_TareasActuales.setRoundTopLeft(25);
        PR_TareasActuales.setRoundTopRight(25);
        PR_TareasActuales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_TareasActualesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_TareasActualesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_TareasActualesMousePressed(evt);
            }
        });
        PR_TareasActuales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_TareasActuales.add(lblTareasActuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tareas actuales");
        PR_TareasActuales.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 140, 50));

        Menu.add(PR_TareasActuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, 50));

        PR_MisTareas.setBackground(new java.awt.Color(25, 35, 60));
        PR_MisTareas.setRoundBottomLeft(25);
        PR_MisTareas.setRoundBottomRight(25);
        PR_MisTareas.setRoundTopLeft(25);
        PR_MisTareas.setRoundTopRight(25);
        PR_MisTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_MisTareasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_MisTareasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_MisTareasMousePressed(evt);
            }
        });
        PR_MisTareas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_MisTareas.add(lblMisTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mis Tareas");
        PR_MisTareas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 90, 50));

        Menu.add(PR_MisTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 200, 50));

        PR_Salir.setBackground(new java.awt.Color(237, 181, 94));
        PR_Salir.setRoundBottomLeft(25);
        PR_Salir.setRoundBottomRight(25);
        PR_Salir.setRoundTopLeft(25);
        PR_Salir.setRoundTopRight(25);
        PR_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_SalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_SalirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_SalirMousePressed(evt);
            }
        });
        PR_Salir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_Salir.add(lblSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Salir");
        PR_Salir.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        Menu.add(PR_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 110, 50));

        PR_Inicio.setBackground(new java.awt.Color(25, 35, 60));
        PR_Inicio.setRoundBottomLeft(25);
        PR_Inicio.setRoundBottomRight(25);
        PR_Inicio.setRoundTopLeft(25);
        PR_Inicio.setRoundTopRight(25);
        PR_Inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_InicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_InicioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_InicioMousePressed(evt);
            }
        });
        PR_Inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_Inicio.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Inicio");
        PR_Inicio.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 50));

        Menu.add(PR_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 50));

        PR_Historial.setBackground(new java.awt.Color(25, 35, 60));
        PR_Historial.setRoundBottomLeft(25);
        PR_Historial.setRoundBottomRight(25);
        PR_Historial.setRoundTopLeft(25);
        PR_Historial.setRoundTopRight(25);
        PR_Historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_HistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_HistorialMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_HistorialMousePressed(evt);
            }
        });
        PR_Historial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_Historial.add(lblHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Historial");
        PR_Historial.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 90, 50));

        Menu.add(PR_Historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 200, 50));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        Pantalla.setBackground(new java.awt.Color(255, 255, 255));
        Pantalla.setRoundBottomRight(50);
        Pantalla.setRoundTopRight(50);
        Pantalla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setForeground(new java.awt.Color(25, 35, 60));
        Pantalla.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 690, 10));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(25, 35, 60));
        jLabel17.setText("Usuarios");
        Pantalla.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        PRUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        PRUsuarios.setRoundBottomLeft(35);
        PRUsuarios.setRoundBottomRight(35);
        PRUsuarios.setRoundTopLeft(35);
        PRUsuarios.setRoundTopRight(35);
        PRUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTBuscar.setBackground(new java.awt.Color(237, 181, 94));
        BTBuscar.setRoundBottomRight(25);
        BTBuscar.setRoundTopRight(25);
        BTBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTBuscarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTBuscarMousePressed(evt);
            }
        });
        BTBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buscar");
        BTBuscar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        PRUsuarios.add(BTBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 110, 40));
        PRUsuarios.add(lblEsq, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 50, 40));

        TF_Buscar.setBackground(new java.awt.Color(237, 181, 94));
        TF_Buscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TF_Buscar.setForeground(new java.awt.Color(255, 255, 255));
        TF_Buscar.setText("Buscar usuario");
        TF_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TF_BuscarMousePressed(evt);
            }
        });
        PRUsuarios.add(TF_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 560, 40));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Correo", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(40);
        jScrollPane1.setViewportView(table);

        PRUsuarios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 650, 350));

        BTReiniciar.setBackground(new java.awt.Color(237, 181, 94));
        BTReiniciar.setRoundBottomLeft(25);
        BTReiniciar.setRoundBottomRight(25);
        BTReiniciar.setRoundTopLeft(25);
        BTReiniciar.setRoundTopRight(25);
        BTReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTReiniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTReiniciarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTReiniciarMousePressed(evt);
            }
        });
        BTReiniciar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Reiniciar");
        BTReiniciar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        PRUsuarios.add(BTReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 110, 40));

        Pantalla.add(PRUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 690, 500));

        getContentPane().add(Pantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 870, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TF_BuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TF_BuscarMousePressed
        if(TF_Buscar.getText().equals("Buscar usuario")){
            TF_Buscar.setText("");
        }
    }//GEN-LAST:event_TF_BuscarMousePressed

    private void lblPerfilComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_lblPerfilComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPerfilComponentHidden

    private void PR_PerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_PerfilMouseEntered
        Color color = new Color(237,181,94);
        PR_Perfil.setBackground(color);
    }//GEN-LAST:event_PR_PerfilMouseEntered

    private void PR_PerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_PerfilMouseExited
        Color color = new Color(25,35,60);
        PR_Perfil.setBackground(color);
    }//GEN-LAST:event_PR_PerfilMouseExited

    private void PR_PerfilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_PerfilMousePressed
        Perfil ventana = new Perfil();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_PerfilMousePressed

    private void PR_UsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_UsuariosMouseEntered
        Color color = new Color(237,181,94);
        PR_Usuarios.setBackground(color);
    }//GEN-LAST:event_PR_UsuariosMouseEntered

    private void PR_UsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_UsuariosMouseExited
        Color color = new Color(25,35,60);
        PR_Usuarios.setBackground(color);
    }//GEN-LAST:event_PR_UsuariosMouseExited

    private void PR_UsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_UsuariosMousePressed
        Usuarios ventana = new Usuarios();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_UsuariosMousePressed

    private void PR_TareasActualesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_TareasActualesMouseEntered
        Color color = new Color(237,181,94);
        PR_TareasActuales.setBackground(color);
    }//GEN-LAST:event_PR_TareasActualesMouseEntered

    private void PR_TareasActualesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_TareasActualesMouseExited
        Color color = new Color(25,35,60);
        PR_TareasActuales.setBackground(color);
    }//GEN-LAST:event_PR_TareasActualesMouseExited

    private void PR_TareasActualesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_TareasActualesMousePressed
        TareasActuales ventana = new TareasActuales();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_TareasActualesMousePressed

    private void PR_MisTareasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_MisTareasMouseEntered
        Color color = new Color(237,181,94);
        PR_MisTareas.setBackground(color);
    }//GEN-LAST:event_PR_MisTareasMouseEntered

    private void PR_MisTareasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_MisTareasMouseExited
        Color color = new Color(25,35,60);
        PR_MisTareas.setBackground(color);
    }//GEN-LAST:event_PR_MisTareasMouseExited

    private void PR_MisTareasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_MisTareasMousePressed
        MisTareas ventana = new MisTareas();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_MisTareasMousePressed

    private void PR_SalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_SalirMouseEntered
        Color color = new Color(214,80,68);
        PR_Salir.setBackground(color);
    }//GEN-LAST:event_PR_SalirMouseEntered

    private void PR_SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_SalirMouseExited
        Color color = new Color(237,181,94);
        PR_Salir.setBackground(color);
    }//GEN-LAST:event_PR_SalirMouseExited

    private void PR_SalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_SalirMousePressed
        Login ventana = new Login();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_SalirMousePressed

    private void PR_InicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_InicioMouseEntered
        Color color = new Color(237,181,94);
        PR_Inicio.setBackground(color);
    }//GEN-LAST:event_PR_InicioMouseEntered

    private void PR_InicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_InicioMouseExited
        Color color = new Color(25,35,60);
        PR_Inicio.setBackground(color);
    }//GEN-LAST:event_PR_InicioMouseExited

    private void PR_InicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_InicioMousePressed
        Inicio ventana = new Inicio();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_InicioMousePressed

    private void PR_HistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_HistorialMouseEntered
        Color color = new Color(237,181,94);
        PR_Historial.setBackground(color);
    }//GEN-LAST:event_PR_HistorialMouseEntered

    private void PR_HistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_HistorialMouseExited
        Color color = new Color(25,35,60);
        PR_Historial.setBackground(color);
    }//GEN-LAST:event_PR_HistorialMouseExited

    private void PR_HistorialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_HistorialMousePressed
        Historial ventana = new Historial();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_HistorialMousePressed

    private void BTBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTBuscarMouseEntered
        Color color = new Color(214,80,68);
        BTBuscar.setBackground(color);
    }//GEN-LAST:event_BTBuscarMouseEntered

    private void BTBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTBuscarMouseExited
        Color color = new Color(237,181,94);
        BTBuscar.setBackground(color);
    }//GEN-LAST:event_BTBuscarMouseExited

    private void BTBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTBuscarMousePressed
        if(!TF_Buscar.getText().equals(null) && !TF_Buscar.getText().equals("Buscar usuario")){
            usuario=TF_Buscar.getText();
            buscarUsuario();
        }
    }//GEN-LAST:event_BTBuscarMousePressed

    private void BTReiniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTReiniciarMouseEntered
        Color color = new Color(214,80,68);
        BTReiniciar.setBackground(color);
    }//GEN-LAST:event_BTReiniciarMouseEntered

    private void BTReiniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTReiniciarMouseExited
        Color color = new Color(237,181,94);
        BTReiniciar.setBackground(color);
    }//GEN-LAST:event_BTReiniciarMouseExited

    private void BTReiniciarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTReiniciarMousePressed
        vaciarTabla();
        rellenarTabla(lista);
        TF_Buscar.setText("Buscar usuario");
    }//GEN-LAST:event_BTReiniciarMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }
    
    private void addRowWithActionButtons(Object[] rowData) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
    
        // Aquí agregamos la fila con los datos regulares
        model.addRow(rowData);
    
         // Ahora configuramos el editor y el renderer para la columna de acciones, para que contenga los botones
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int columnCount = model.getColumnCount();
                    Object[] rowData = new Object[columnCount];

                    System.out.println("\n Usuarios datos");
                    for (int col = 0; col < columnCount; col++) {
                        rowData[col] = model.getValueAt(selectedRow, col);
                        System.out.println(rowData[col]);
                    }

                    Integer value = (Integer) rowData[0];
                    int intValue = value.intValue();
                    // los valores de la fila en el arreglo rowData
                    //System.out.println(Arrays.toString(rowData));
                    Usuario editar=new Usuario();
                    
                    // Ahora tienes todos los valores de la fila en el arreglo rowData
                    editar.setId(intValue);
                    editar.setUsuario((String) rowData[1]);
                    editar=obtenerUsuario(editar);
                    System.out.println(Arrays.toString(rowData));
                    
                    EditarNivelUsuario ventana= new EditarNivelUsuario(Usuarios.this);
                    ventana.setUsuario(editar);
                    ventana.setIndice(indice);
                    ventana.setlista(lista);
                    ventana.setVisible(true);
                }
            }

            @Override
            public void onDelete(int row) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int columnCount = model.getColumnCount();
                    Object[] rowData = new Object[columnCount];

                    //Usuarios datos
                    for (int col = 0; col < columnCount; col++) {
                        rowData[col] = model.getValueAt(selectedRow, col);
                    }

                    Integer value = (Integer) rowData[0];
                    int intValue = value.intValue();
                    // los valores de la fila en el arreglo rowData
                    //System.out.println(Arrays.toString(rowData));
                    Usuario borrar=new Usuario();
                    
                    borrar.setId(intValue);
                    borrar.setUsuario((String) rowData[1]);
                    borrar=obtenerUsuario(borrar);
                    borrar.eliminarUsuario(userHome, borrar);
                    
                    Usuario aux= new Usuario();
                    File direcUsuarios = new File(fileUsuarios);
                    lista=aux.listaUsuarios(direcUsuarios);
                }
                
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
                JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            }

            @Override
            public void onView(int row) {
                System.out.println("View row : " + row);
                
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int columnCount = model.getColumnCount();
                    Object[] rowData = new Object[columnCount];

                    //Usuarios datos
                    for (int col = 0; col < columnCount; col++) {
                        rowData[col] = model.getValueAt(selectedRow, col);
                    }

                    Integer value = (Integer) rowData[0];
                    int intValue = value.intValue();
                    // los valores de la fila en el arreglo rowData
                    //System.out.println(Arrays.toString(rowData));
                    Usuario mostrar=new Usuario();
                    
                    mostrar.setId(intValue);
                    mostrar.setUsuario((String) rowData[1]);
                    mostrar=obtenerUsuario(mostrar);
                    PerfilView ventana=new PerfilView();
                    ventana.setUsuario(mostrar);
                    ventana.setVisible(true);
                }
            }
        };

         // Asignar el editor y renderer a la columna de acciones (en este caso, columna índice 3)
        table.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
    }
    public void setLista(ArrayList<Usuario> aux){
        lista=aux;
        
        vaciarTabla();
        
        if(usuario.isEmpty())
            rellenarTabla(lista);
        else
            buscarUsuario();
    }
    
    private Usuario obtenerUsuario(Usuario buscar){
        Usuario act=new Usuario();
        for (int ind = 0; ind < lista.size(); ind++) {
            if(buscar.getId()==lista.get(ind).getId() && buscar.getUsuario().equals(lista.get(ind).getUsuario())){
                act=lista.get(ind);
                indice=ind;
            }
        }
        return act;
    }
    
    public void vaciarTabla(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        if(rowCount>0){
            // Eliminar filas desde la última hacia la primera
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
        }
    }
    private void rellenarTabla(ArrayList<Usuario> lista) {
    // Iteramos sobre el ArrayList usando su tamaño (size())
        for (int aux = 0; aux < lista.size(); aux++) {
            // Accedemos al usuario actual usando lista.get(aux)
            Object[] newRow = new Object[] {
                lista.get(aux).getId(),     // Obtener el ID del usuario
                lista.get(aux).getUsuario(), // Obtener el nombre de usuario
                lista.get(aux).getCorreo(),  // Obtener el correo del usuario
                null                         // Campo adicional (puede ser un botón u otro dato)
            };

            // Llamamos al método para agregar la fila con acción (posiblemente un botón)
            addRowWithActionButtons(newRow);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PanelRound BTBuscar;
    private PanelRound BTReiniciar;
    private javax.swing.JLabel ImagenUsuario;
    private PanelRound Menu;
    private PanelRound PRUsuarios;
    private PanelRound PR_Historial;
    private PanelRound PR_Inicio;
    private PanelRound PR_MisTareas;
    private PanelRound PR_Perfil;
    private PanelRound PR_Salir;
    private PanelRound PR_TareasActuales;
    private PanelRound PR_Usuarios;
    private PanelRound Pantalla;
    private javax.swing.JTextField TF_Buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEsq;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblMisTareas;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblTareasActuales;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
