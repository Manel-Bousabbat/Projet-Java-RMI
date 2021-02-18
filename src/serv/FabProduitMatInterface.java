package serv;

import java.rmi.*; 
public interface FabProduitMatInterface extends Remote{
   public ProduitMatInterface newProduitMat() throws RemoteException ;}	
