public class Conver extends javax.swing.JFrame {
    
    private javax.swing.JLabel cartel_gradosC;
    private javax.swing.JLabel cartel_gradosF;
    private javax.swing.JTextField caja_gradosC;
    private javax.swing.JTextField caja_gradosF;
    private javax.swing.JButton boton_conversor;
    private Object obj_caja;

    public Conver() {
        
        setSize(370, 220);
        setTitle("Conversión de temperaturas");
        initComponents();
    }

    public void initComponents() {

        cartel_gradosC = new javax.swing.JLabel();
        cartel_gradosF = new javax.swing.JLabel();
        caja_gradosC = new javax.swing.JTextField();
        caja_gradosF = new javax.swing.JTextField();
        boton_conversor = new javax.swing.JButton();

        // la siguiente línea genera la ventana de aplicación vacía, sin elementos:
        getContentPane().setLayout(null);

        // de izquierda a derecha y de arriba hacia abajo, primero situamos el cartel de "Grados centigrados":
        cartel_gradosC.setText("Grados centigrados");
        cartel_gradosC.setBounds(40, 28, 116, 16);

        getContentPane().add(cartel_gradosC);

        // a la derecha del cartel anterior va la caja de texto donde se visualizará la cantidad de grados centigrados:
        caja_gradosC.setText("0.0");
        caja_gradosC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        caja_gradosC.setBounds(180, 28, 144, 20);

        getContentPane().add(caja_gradosC);

        // abajo de la sección de grados centigrados, empezamos con la etiqueda de "Grados Fahrenheit":
        cartel_gradosF.setText("Grados fahrenheit");
        cartel_gradosF.setBounds(40, 75, 104, 24);

        getContentPane().add(cartel_gradosF);

        // a la derecha de la etiqueta situamos la caja de texto correspondiente a grados fahrenheit:
        caja_gradosF.setText("32.0");
        caja_gradosF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        caja_gradosF.setBounds(180, 75, 144, 20);

        getContentPane().add(caja_gradosF);

        // luego de los carteles y las cajas de texto para los grados, incluimos el botón para la conversión:
        boton_conversor.setText("Aceptar");
        boton_conversor.setToolTipText("Pulse aquí para realizar la conversión");
        boton_conversor.setMnemonic('a');
        getRootPane().setDefaultButton(boton_conversor);
        boton_conversor.setBounds(180, 120, 144, 20);

        getContentPane().add(boton_conversor);
        addWindowListener(new java.awt.event.WindowAdapter() {
            
            public void windowOpened(java.awt.event.WindowEvent evt) {
                
                formWindowOpened(evt);
            }
            
            // se define lo que el manejador de eventos debe controlar cuando se quiere cerrar la ventana.
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        // se asocia el método a ejecutar con el escuchador de acción que estará pendiente de que se oprima la tecla "Enter".
        java.awt.event.ActionListener al = new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                teclaEnter(evt);
            }
        };

        caja_gradosC.addActionListener(al);
        caja_gradosF.addActionListener(al);
        java.awt.event.KeyAdapter kl = new java.awt.event.KeyAdapter() {

            public void keyTyped(java.awt.event.KeyEvent evt) {
                
                teclaPresionadaCaja(evt);
            }
        };

        caja_gradosC.addKeyListener(kl);
        caja_gradosF.addKeyListener(kl);
        
        java.awt.event.FocusAdapter fl = new java.awt.event.FocusAdapter() {

            public void focusGained(java.awt.event.FocusEvent evt) {

                textoSeleccionadoCaja(evt);
            }
        };

        caja_gradosC.addFocusListener(fl);
        caja_gradosF.addFocusListener(fl);

        // definimos el comportamiento del botón al hacerse click sobre él:
        boton_conversor.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                boton_conversor_ActionPerformed(evt);
            }
        });
    }

    private void textoSeleccionadoCaja(java.awt.event.FocusEvent evt) {

        javax.swing.JTextField objEnfocado = (javax.swing.JTextField)evt.getSource();
        objEnfocado.selectAll();
    }

    private void teclaPresionadaCaja(java.awt.event.KeyEvent evt) {
        
        obj_caja = evt.getSource();
    }

    private void boton_conversor_ActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            double grados = 0.0;

            // en caso de que el usuario ingrese un dato en la caja de grados centígrados:
            if (obj_caja == caja_gradosC) {
                grados = (Double.parseDouble(caja_gradosC.getText()) * 9.0 / 5.0) + 32.0;
                String texto = String.format("%.2f", grados);
                caja_gradosF.setText(texto);
            }

            // en caso de que el usuario ingrese un dato en la caja de grados fahrenheit:
            if (obj_caja == caja_gradosF) {
                grados = (Double.parseDouble(caja_gradosF.getText()) - 32.0) * 5.0 / 9.0;
                String texto = String.format("%.2f", grados);
                caja_gradosC.setText(texto);
            }
        }
        catch (NumberFormatException e) {
            caja_gradosC.setText("0.0");
            caja_gradosF.setText("32.0");
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {

        caja_gradosC.requestFocus();
    }

    private void exitForm(java.awt.event.WindowEvent evt) {
        
        // acción que debe ocurrir cuando se da el evento "cerrar ventana" (hacer click en la "X" del margen superior derecho).
        System.exit(0);
    }

    private void teclaEnter(java.awt.event.ActionEvent evt) {

        try {
            double grados = 0.0;
            String sGrados = "";
            Object obj_caja = evt.getSource();
            
            // en caso de que el usuario ingrese un dato en la caja de grados centígrados:
            if (obj_caja == caja_gradosC) {
                sGrados = caja_gradosC.getText();
                if (sGrados.length() == 0) {
                    return;
                }
                grados = (Double.parseDouble(caja_gradosC.getText()) * 9.0 / 5.0) + 32.0;
                String texto = String.format("%.2f", grados);
                caja_gradosF.setText(texto);
            }

            // en caso de que el usuario ingrese un dato en la caja de grados fahrenheit:
            if (obj_caja == caja_gradosF) {
                sGrados = caja_gradosF.getText();
                if (sGrados.length() == 0) {
                    return;
                }
                grados = (Double.parseDouble(caja_gradosF.getText()) - 32.0) * 5.0 / 9.0;
                String texto = String.format("%.2f", grados);
                caja_gradosC.setText(texto);
            }
        }
        catch (NumberFormatException e) {
            caja_gradosC.setText("0.0");
            caja_gradosF.setText("32.0");
        }
    }
    public static void main(String[] args) {
        
        // definimos el L&F de la ventana de la aplicación:
        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        } 
        catch (Exception e) {
            System.out.println("No se pudo establecer el aspecto desesado: " + e);
        }
        
        // habilitamos la visualización de la ventana:
        new Conver().setVisible(true);
    }
}
