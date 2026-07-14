import java.util.ArrayList;
import java.net.InetAddress;

public class EscanerRed{

    private String red;

    public EscanerRed(String red) throws Exception {

        this.red = red;

        System.out.println("la red recibida es: " + red);

        ArrayList<String> ipsActivas = new ArrayList<>();

        for(int i = 1; i <= 20; i++){

            String ipActual = red + "." + i;

            InetAddress ip = InetAddress.getByName(ipActual);
            if(ip.isReachable(1000)){
                System.out.println("La ip " + ipActual + " esta ACTIVA");
                ipsActivas.add(ipActual);
            }else{
                System.out.println("La ip " + ipActual + " no responde");

            }

            

         


        }            System.out.println("\n===== IPs ACTIVAS ENCONTRADAS =====");

           for (String ip : ipsActivas) {
        System.out.println(ip);
                }
        }

    }
