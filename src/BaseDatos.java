import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BaseDatos {

    private static final String URL = "jdbc:mariadb://localhost:3306/escaner_red";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    public static void guardarEquipo(Equipo equipo) {

        try {

            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);

            String sql = "INSERT INTO equipos (ip, mac, activo) VALUES (?, ?, ?)";

            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, equipo.getIp());
            sentencia.setString(2, equipo.getMac());
            sentencia.setBoolean(3, equipo.isActivo());

            sentencia.executeUpdate();

            conexion.close();

            System.out.println("Equipo guardado en la base de datos.");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}