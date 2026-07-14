import java.util.ArrayList;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EscanerRed {

    private String red;

    public EscanerRed(String red) throws Exception {

        this.red = red;

        System.out.println("La red recibida es: " + red);

        ArrayList<Equipo> equipos = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {

            String ipActual = red + "." + i;

            InetAddress ip = InetAddress.getByName(ipActual);

            if (ip.isReachable(1000)) {

                System.out.println("La IP " + ipActual + " está ACTIVA");

                String mac = obtenerMac(ipActual);

                Equipo pc = new Equipo(ipActual, mac, true);

                equipos.add(pc);

            } else {

                System.out.println("La IP " + ipActual + " no responde");

            }
        }

        System.out.println("\n===== EQUIPOS ENCONTRADOS =====");

        for (Equipo equipo : equipos) {

            System.out.println("IP: " + equipo.getIp());
            System.out.println("MAC: " + equipo.getMac());
            System.out.println("Activo: " + equipo.isActivo());
            System.out.println("-----------------------------");

        }

    }

    // Devuelve la dirección MAC de una IP usando "ip neigh"
    private String obtenerMac(String ipBuscada) throws Exception {

        Process proceso = new ProcessBuilder("ip", "neigh").start();

        BufferedReader lector = new BufferedReader(
                new InputStreamReader(proceso.getInputStream())
        );

        String linea;

        while ((linea = lector.readLine()) != null) {

            if (linea.startsWith(ipBuscada)) {

                String[] partes = linea.split(" ");

                for (int i = 0; i < partes.length; i++) {

                    if (partes[i].equals("lladdr")) {
                        return partes[i + 1];
                    }

                }

            }

        }

        return "DESCONOCIDA";

    }

}