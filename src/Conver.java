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

        // definición de parámetros de la etiqueta que identifica la caja de grados centígrados:
        cartel_gradosC.setText("Grados centigrados");
        cartel_gradosC.setBounds(40, 28, 116, 16);
        // agregado de la etiqueta para grados centígrados:
        getContentPane().add(cartel_gradosC);

        // definición de parámetros de la caja de texto para grados centígrados:
        caja_gradosC.setText("0.0");
        caja_gradosC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        caja_gradosC.setBounds(180, 28, 144, 20);
        // agregado de la caja de texto para grados centígrados:
        getContentPane().add(caja_gradosC);

        // definición de parámetros de la etiqueta que identifica la caja de grados fahrenheit:
        cartel_gradosF.setText("Grados fahrenheit");
        cartel_gradosF.setBounds(40, 75, 104, 24);
        // agregado de la etiqueta para grados fahrenheit:
        getContentPane().add(cartel_gradosF);

        // definición de parámetros de la caja de texto para grados fahrenheit:
        caja_gradosF.setText("32.0");
        caja_gradosF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        caja_gradosF.setBounds(180, 75, 144, 20);
        // agregado de la caja de texto para grados fahrenheit:
        getContentPane().add(caja_gradosF);

        // definición de parámetros del botón que permitirá realizar la conversión entre medidas de temperatura:
        boton_conversor.setText("Convertir");
        boton_conversor.setToolTipText("Pulse aquí para realizar la conversión");
        boton_conversor.setMnemonic('a');
        getRootPane().setDefaultButton(boton_conversor);
        boton_conversor.setBounds(180, 120, 144, 20);
        // agregado del botón:
        getContentPane().add(boton_conversor);
        
        // definición del escuchador de ventana, que permite manipular la interfaz de eventos a nivel ventana:
        addWindowListener(new java.awt.event.WindowAdapter() {
            
            // reescritura del método "windowOpened" para incluir la ejecución de nuestro método "formWindowOpened":
            public void windowOpened(java.awt.event.WindowEvent evt) {
                
                formWindowOpened(evt);
            }
            
            // reescritura del método "windowClosing" para incluir la ejecución de nuestro método "exitForm":
            public void windowClosing(java.awt.event.WindowEvent evt) {
                
                exitForm(evt);
            }
        });

        // definición del escuchador de acciones, que permite responder con métodos específicos a eventos de acción sobre componentes:
        java.awt.event.ActionListener al = new java.awt.event.ActionListener() {

            // reescritura del método "actionPerformed" para incluir la ejecución del método propio "teclaEnter":
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                teclaEnter(evt);
            }
        };
        // vinculación del escuchador con las cajas de texto, aquellos componenetes que responderán al presionado de la tecla "Enter":
        caja_gradosC.addActionListener(al);
        caja_gradosF.addActionListener(al);

        // definición del escuchador de teclas, que permite responder a los mensajes vinculados al presionado de teclas:
        java.awt.event.KeyAdapter kl = new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {

                teclaPresionada(evt);
            }
            
            // reescritura del método "KeyTyped" para incluir la ejecución del método propio "teclaPresionada":
            public void keyTyped(java.awt.event.KeyEvent evt) {
                
                teclaPresionada(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {

                teclaLiberada(evt);
            }
        };
        // vinculación del escuchador con las cajas de texto, aquellos componenetes que responderán al presionado de la teclas:
        caja_gradosC.addKeyListener(kl);
        caja_gradosF.addKeyListener(kl);
        
        java.awt.event.FocusAdapter fl = new java.awt.event.FocusAdapter() {

            public void focusGained(java.awt.event.FocusEvent evt) {

                textoSeleccionadoCaja(evt);
            }
        };

        caja_gradosC.addFocusListener(fl);
        caja_gradosF.addFocusListener(fl);

        
        boton_conversor.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                boton_conversor_ActionPerformed(evt);
            }
        });
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

    private void teclaLiberada(java.awt.event.KeyEvent evt) {

        javax.swing.JTextField objJTF = (javax.swing.JTextField)evt.getSource();
        String str = objJTF.getText();
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        int j = 0;
        boolean error = false;
        
        for (int i = 0; i < fuente.length; i++) {
            if (fuente[i] >= '0' && fuente[i] <= '9' || fuente[i] == '.' || fuente[i] == '+' || fuente[i] == '-') {
                resultado[j++] = fuente[i];
            }
            else {
                error = true;
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        }
        if (error) {
            objJTF.setText(new String(resultado, 0, j));
        }
    }

    private void textoSeleccionadoCaja(java.awt.event.FocusEvent evt) {

        javax.swing.JTextField objEnfocado = (javax.swing.JTextField)evt.getSource();
        objEnfocado.selectAll();
    }

    private void teclaPresionada(java.awt.event.KeyEvent evt) {
        
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
