import java.awt.Color;
import javax.swing.border.LineBorder;

public class HolaMundoApp extends javax.swing.JFrame {

    private javax.swing.JLabel cartel_saludo;
    private javax.swing.JButton boton_saludo;
    
    public HolaMundoApp() {
        
        // el tamaño de la ventana se asigna en pixeles, primero el ahcho y luego el alto.
        setSize(500, 500);
        setTitle("Aplicacion");
        initComponents();
    }

    public void initComponents() {
        
        // el método "Listener" agrega al objeto "Aplicacion" un manejador de eventos de ventana "WindowAdapter".
        cartel_saludo = new javax.swing.JLabel();
        boton_saludo = new javax.swing.JButton();
        getContentPane().setLayout(null);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            
            // se define estrictamente lo que el manejador de eventos debe controlar cuando se quiere cerrar la ventana.
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        // definición de características de la etiqueta incluida en el contenedor JFrame:
        cartel_saludo.setText("etiqueta");
        cartel_saludo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartel_saludo.setFont(new java.awt.Font("Dialog", 1, 18));
        cartel_saludo.setBorder(new LineBorder(Color.BLACK));
        cartel_saludo.setBounds(50, 150, 400, 30);

        getContentPane().add(cartel_saludo);

        // definición de características del botón incluida en el contenedor JFrame:
        boton_saludo.setText("Haga click aquí");
        boton_saludo.setToolTipText("Botón de pulsación");
        boton_saludo.setMnemonic('c');
        boton_saludo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boton_saludo.setFont(new java.awt.Font("Dialog", 1, 18));
        boton_saludo.setBounds(100, 200, 200, 30);
        
        // definimos el comportamiento del botón al hacerse click sobre él.
        // primero invocamos al método escuchador, para el botón:
        boton_saludo.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                // la sobreescritura de "actionPerformed" implica la ejecución de "boton_saludo_ActionPerformed":
                boton_saludo_ActionPerformed(evt);
            }
        });

        getContentPane().add(boton_saludo);
    }

    // este será el método que se ejecutará la aplicación cuando se detecte un click sobre el botón:
    private void boton_saludo_ActionPerformed(java.awt.event.ActionEvent evt) {

        float rojo = (float)Math.random();
        float verde = (float)Math.random();
        float azul = (float)Math.random();

        // el botón producirá la impresión de "Hola Mundo!!!" en la etiqueta, así como también cambiará el color de fuente aleatoriamente.
        cartel_saludo.setForeground(new java.awt.Color(rojo, verde, azul));
        cartel_saludo.setText("Hola Mundo!!!");
    }

    private void exitForm(java.awt.event.WindowEvent evt) {
        
        // acción que debe ocurrir cuando se da el evento "cerrar ventana" (hacer click en la "X" del margen superior derecho).
        System.exit(0);
    }

    public static void main(String[] args) {
        
        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        } 
        catch (Exception e) {
            System.out.println("No se pudo establecer el aspecto desesado: " + e);
        }
        
        new HolaMundoApp().setVisible(true);
    }
}