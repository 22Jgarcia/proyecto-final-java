import javax.swing.*;
import java.sql.*;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class conector {
    String db = "jdbc:postgresql://localhost:5432/inventario";
    public void addProduct (String nombre, String codego) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(db, "postgres", "123456");
            PreparedStatement newStatement = connection.prepareStatement("insert into inventario values (?, ?)");
            newStatement.setString(1, nombre);
            newStatement.setString(2, codego);
            newStatement.executeQuery();
            JOptionPane.showMessageDialog(null, "se digito su producto");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }

    public void export () {
        try {
            FileWriter file = new FileWriter("C:/Users/Georg/Desktop/uni/PROGRA 2/proyecto final/inventario.txt");

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(db, "postgres", "123456");

            Statement createStatement = connection.createStatement();

            ResultSet results = createStatement.executeQuery ("select * from inventario");
            int i=0;
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (results.next())
            {
                file.write(i+1 + results.getString(1) + " " + results.getString(2) + "\n");
                i++;
            }
            file.close();// Se cierra la conexión con la base de datos.

            connection.close();
            JOptionPane.showMessageDialog(null, "Exportando en un archivo txt");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }
}

