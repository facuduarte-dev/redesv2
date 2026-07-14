import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BaseDatos {

    private static final String URL = "jdbc:mariadb://localhost:3306/escaner_red";
    private static final String USUARIO = "java";
    private static final String PASSWORD = "1234";

    public static void guardarEquipo(Equipo equipo) {

        String sql = """
                INSERT INTO equipos (ip, mac, activo)
                VALUES (?, ?, ?)
                ON DUPLICATE KEY UPDATE
                    mac = VALUES(mac),
                    activo = VALUES(activo)
                """;

        try (
                Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setString(1, equipo.getIp());
            sentencia.setString(2, equipo.getMac());
            sentencia.setBoolean(3, equipo.isActivo());

            sentencia.executeUpdate();

            System.out.println("Equipo guardado correctamente.");

        } catch (Exception e) {

            System.out.println("Error al guardar el equipo en la base de datos.");
            e.printStackTrace();

        }

    }

}