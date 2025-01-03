
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class EditarNivelUsuario extends javax.swing.JFrame {

    Escalar escalar = new Escalar();
    private String userHome ="C:\\Users\\Cesia\\Desktop";
    public Usuario UsuarioActual;
    public ArrayList<Usuario> lista;
    public int indice=0;
    private Usuarios usuarios;
    
    public void setIndice(int ind){
        this.indice=ind;
    }
    
    public void setUsuario(Usuario usuario){
        UsuarioActual=new Usuario(usuario);
        lblUsuario.setText(UsuarioActual.getUsuario());
        lblID.setText(Integer.toString(UsuarioActual.getId()));
        lblEmail.setText(UsuarioActual.getCorreo());
        CBNivel.setSelectedItem(UsuarioActual.getNivel());
    }
    
    public void setlista(ArrayList<Usuario> aux){
        lista=aux;
    }
    
    public EditarNivelUsuario(Usuarios usuarios) {
        initComponents();
        setLocationRelativeTo(null);
        this.usuarios = usuarios; 
        escalar.escalarLabel(lblFotoUsuario, "\\imagenes\\usuario.png");
        escalar.escalarLabel(lblFondo, "\\imagenes\\fondo5.png");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new PanelRound();
        lblFotoUsuario = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        CBNivel = new javax.swing.JComboBox<>();
        BTGuardar = new javax.swing.JButton();
        BTCancelar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(255, 255, 255,50));
        panelRound2.setForeground(new java.awt.Color(204, 204, 204));
        panelRound2.setRoundBottomLeft(40);
        panelRound2.setRoundBottomRight(40);
        panelRound2.setRoundTopLeft(40);
        panelRound2.setRoundTopRight(40);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound2.add(lblFotoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 130, 120));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("ID           :");
        panelRound2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 110, 20));

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblID.setForeground(new java.awt.Color(51, 51, 51));
        lblID.setText("00001");
        panelRound2.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(25, 35, 60));
        panelRound2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 290, 10));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Usuario  :");
        panelRound2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 110, 20));

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblUsuario.setText("Usuario de prueba");
        panelRound2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Email      :");
        panelRound2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, 20));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(51, 51, 51));
        lblEmail.setText("prueba1@gmail.com");
        panelRound2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(25, 35, 60));
        panelRound2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 290, 10));

        CBNivel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CBNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nivel de Usuario", "base", "administrador" }));
        panelRound2.add(CBNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 210, 40));

        BTGuardar.setBackground(new java.awt.Color(255, 255, 255));
        BTGuardar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BTGuardar.setForeground(new java.awt.Color(102, 102, 102));
        BTGuardar.setText("Guardar");
        BTGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTGuardarActionPerformed(evt);
            }
        });
        panelRound2.add(BTGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        BTCancelar.setBackground(new java.awt.Color(255, 255, 255));
        BTCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTCancelar.setForeground(new java.awt.Color(102, 102, 102));
        BTCancelar.setText("Cancelar");
        BTCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCancelarActionPerformed(evt);
            }
        });
        panelRound2.add(BTCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        getContentPane().add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 470));

        lblFondo.setBackground(new java.awt.Color(255, 255, 255,100));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTGuardarActionPerformed
        lista.get(indice).setNivel((String) CBNivel.getSelectedItem());
        UsuarioActual.editarNivel(userHome, UsuarioActual,lista.get(indice));
        usuarios.setLista(lista);
        JOptionPane.showMessageDialog(null, "Nivel de usuario editado");
        this.dispose();
    }//GEN-LAST:event_BTGuardarActionPerformed

    private void BTCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BTCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarNivelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarNivelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarNivelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarNivelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Usuarios usuarios = new Usuarios(); 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarNivelUsuario(usuarios).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTCancelar;
    private javax.swing.JButton BTGuardar;
    private javax.swing.JComboBox<String> CBNivel;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private static javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFotoUsuario;
    private static javax.swing.JLabel lblID;
    private static javax.swing.JLabel lblUsuario;
    private PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
