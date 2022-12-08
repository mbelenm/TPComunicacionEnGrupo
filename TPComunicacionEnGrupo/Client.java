import java.io.IOException;
import java.rmi.NotBoundException;

public class Client {
    
    public static void main(String[] args) throws NotBoundException, IOException {
        var localhost = "128.0.0.0";
        var nombreGrupo = "nombreGrupo";
        
        var object = GroupClient.getObject("rmi://" + localhost + "/" + nombreGrupo);

        var remoteGroup = (RemoteGroup) object;

        var argsIp = new String[3];
        argsIp[0] = remoteGroup.PC1;
        argsIp[1] = remoteGroup.PC2;
        argsIp[2] = remoteGroup.PC3;

        Service.sendMessage(argsIp);
    }
}
