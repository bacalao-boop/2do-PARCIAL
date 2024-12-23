
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Cesia
 */
public class EditarTareaCompletada extends javax.swing.JFrame {

    Escalar escalar = new Escalar();
    public Usuario usuario= new Usuario(0,null,null,null,null);
    public String userHome = "C:\\Users\\Cesia\\Desktop";
    private String direcTareas = userHome + "\\Taskflow\\Tareas\\Usuario";
    private String listaTareas = userHome + "\\Taskflow\\Tareas\\Usuario";
    private Usuario UsuarioActual = new Usuario();
    public ArrayList<Tarea> listaBuscar;
    public int indice=0;
    public Historial historial;
    
    public void listaTareas(ArrayList<Tarea> list){
        listaBuscar=new ArrayList<Tarea> (list);
    }
    
    public void setIndice(int i){
        indice=i;
        TareaActual();
    }
    
    public void TareaActual(){
        lblNombre.setText(listaBuscar.get(indice).getNombre());
        lblDescripcion.setText(listaBuscar.get(indice).getDescripcion());
        lblFecha.setText(listaBuscar.get(indice).getDia()+" "+listaBuscar.get(indice).getMes()+" "+listaBuscar.get(indice).getYear());
        CBEstado.setSelectedItem(listaBuscar.get(indice).getEstado());
        lblPrioridad.setText(listaBuscar.get(indice).getPrioridad());
    }
    public EditarTareaCompletada(Historial historial) {
        initComponents();
        
        setLocationRelativeTo(null);
        
        this.historial=historial;
        
        escalar.escalarLabel(lblFondo, "\\imagenes\\fondo5.png");
        UsuarioActual=UsuarioActual.obtenerUsuarioActual();
        
        direcTareas=userHome+"\\Taskflow\\Tareas\\Usuario"+UsuarioActual.getId();
        listaTareas=userHome + "\\Taskflow\\Tareas\\Usuario"+UsuarioActual.getId()+"\\listaTareas.txt";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PRDetalles = new PanelRound();
        jLabel12 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblPrioridad = new javax.swing.JLabel();
        BTGuardar = new javax.swing.JButton();
        CBEstado = new javax.swing.JComboBox<>();
        BT_Cancelar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PRDetalles.setBackground(new java.awt.Color(255, 255, 255, 100));
        PRDetalles.setRoundBottomLeft(35);
        PRDetalles.setRoundBottomRight(35);
        PRDetalles.setRoundTopLeft(35);
        PRDetalles.setRoundTopRight(35);
        PRDetalles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Fecha de Entrega :");
        PRDetalles.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 200, 30));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(51, 51, 51));
        lblFecha.setText("1 Enero");
        PRDetalles.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 270, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Nombre :");
        PRDetalles.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 120, 30));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(51, 51, 51));
        lblNombre.setText("Hacer un discurso");
        PRDetalles.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 390, 30));

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(51, 51, 51));
        lblDescripcion.setText("______________________");
        PRDetalles.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 390, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Descripcion :");
        PRDetalles.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 160, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Prioridad :");
        PRDetalles.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 130, 30));

        lblPrioridad.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPrioridad.setForeground(new java.awt.Color(51, 51, 51));
        lblPrioridad.setText("Media");
        PRDetalles.add(lblPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 290, 30));

        BTGuardar.setBackground(new java.awt.Color(255, 255, 255));
        BTGuardar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BTGuardar.setForeground(new java.awt.Color(102, 102, 102));
        BTGuardar.setText("Guardar");
        BTGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTGuardarActionPerformed(evt);
            }
        });
        PRDetalles.add(BTGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, -1));

        CBEstado.setBackground(new java.awt.Color(255, 255, 255));
        CBEstado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CBEstado.setForeground(new java.awt.Color(102, 102, 102));
        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "Por hacer", "En progreso", "Completada" }));
        CBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBEstadoActionPerformed(evt);
            }
        });
        PRDetalles.add(CBEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, 40));

        BT_Cancelar.setBackground(new java.awt.Color(255, 255, 255));
        BT_Cancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BT_Cancelar.setForeground(new java.awt.Color(102, 102, 102));
        BT_Cancelar.setText("Cancelar");
        BT_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CancelarActionPerformed(evt);
            }
        });
        PRDetalles.add(BT_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        getContentPane().add(PRDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 470));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTGuardarActionPerformed
        String estados = (String) CBEstado.getSelectedItem();

        if(!estados.isEmpty()){
            Tarea nuevaTarea = new Tarea(listaBuscar.get(indice));
            nuevaTarea.setEstado(estados);

            String direcTareaAct=direcTareas+"\\"+nuevaTarea.getNumeroTarea()+".txt";
            nuevaTarea.editarCualquierTarea(direcTareaAct,nuevaTarea,listaTareas,listaBuscar.get(indice),direcTareas);
            listaBuscar.set(indice, nuevaTarea);// Guardar en lista general
            historial.setLista();
            JOptionPane.showMessageDialog(null, "Tarea Editada");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese el estado de la tarea");
        }
    }//GEN-LAST:event_BTGuardarActionPerformed

    private void BT_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BT_CancelarActionPerformed

    private void CBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(EditarTareaCompletada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarTareaCompletada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarTareaCompletada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarTareaCompletada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        Historial historial= new Historial();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarTareaCompletada(historial).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTGuardar;
    private javax.swing.JButton BT_Cancelar;
    private javax.swing.JComboBox<String> CBEstado;
    private PanelRound PRDetalles;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private static javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrioridad;
    // End of variables declaration//GEN-END:variables
}
