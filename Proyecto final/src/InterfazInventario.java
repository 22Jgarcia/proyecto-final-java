import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class InterfazInventario extends JFrame {
    public JPanel panel;
    public InterfazInventario(){
        this.setSize(500,500); //establecer el tamaño
        setTitle("Inventario");//titulo de la ventana
        componentes();
        setLocationRelativeTo(null);//centro de la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void componentes() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.blue);
        this.getContentPane().add(panel);
        JLabel etiqueta = new JLabel();
        etiqueta.setText("INVENTARIO PRODUCTOS");
        etiqueta.setBounds(170, 10, 300, 30);
        panel.add(etiqueta);
        JLabel etiqueta2= new JLabel();
        etiqueta2.setText("NOMBRE");
        etiqueta2.setBounds(10, 50, 300, 30);
        panel.add(etiqueta2);
        JLabel etiqueta3 = new JLabel();
        etiqueta3.setText("CODIGO");
        etiqueta3.setBounds(10, 100, 300, 30);
        panel.add(etiqueta3);

        JButton boton1= new JButton();
        boton1.setText("Gardar");
        boton1.setBounds(30, 400, 200, 40);
        panel.add(boton1);
        JButton boton2= new JButton();
        boton2.setText("Exportar TXT");
        boton2.setBounds(260, 400, 200, 40);
        panel.add(boton2);

        JTextField caja1= new JTextField();
        caja1.setBounds(150,50,200,30 );
        caja1.setColumns(1);
        panel.add(caja1);
        JTextField caja2= new JTextField();
        caja2.setBounds(150,100,200,30);
        panel.add(caja2);

        ActionListener nuevoProducto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conector conexion = new conector();
                conexion.addProduct(caja1.getText(), caja2.getText());
                JOptionPane.showMessageDialog(null, "Guardado en la base de datos ");
            }
        };
        boton1.addActionListener(nuevoProducto);

        ActionListener crearArchivo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conector conexion = new conector();
                conexion.export();
                JOptionPane.showMessageDialog(null, "se envio al archivo TXT");
            }
        };
        boton2.addActionListener(crearArchivo);
    }
}








