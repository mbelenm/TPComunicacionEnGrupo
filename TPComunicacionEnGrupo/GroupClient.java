import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GroupClient {
    
    public static Object getObject(String url) throws MalformedURLException, RemoteException, NotBoundException {
        var object= Naming.lookup(url);
        System.out.println("Success");

        return object;
    }
}
