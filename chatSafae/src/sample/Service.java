package sample;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote{
    public String getName() throws RemoteException;
    public void setName(String name) throws RemoteException;
    public String send(String msg) throws RemoteException;
    public void setClient(Service s)throws RemoteException;
    public Service getClient() throws RemoteException;
}
