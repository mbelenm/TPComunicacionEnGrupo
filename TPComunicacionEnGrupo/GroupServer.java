import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class GroupServer {

    public static void enableObject() throws RemoteException, MalformedURLException {
        var group = new RemoteGroup("1", "2", "3");
        Naming.rebind("nombreGrupo", (Remote) group);

        System.out.println("Group enabled");
    }
}
