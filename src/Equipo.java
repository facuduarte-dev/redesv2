public class Equipo{


    //declaro las variables
    private String ip;
    private String mac;
    private boolean activo;

    //constructor

    public Equipo(String ip, String mac, boolean activo){
        this.ip = ip;
        this.mac = mac;
        this.activo = activo;
    }

    public String getIp(){
        return ip;
    }

    public String getMac(){
        return mac;
    }

    public boolean isActivo(){
        return activo;
    }
}