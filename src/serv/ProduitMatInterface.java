package serv;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ProduitMatInterface extends Remote 
{
 	 int[][] CalculProduitMat(int n,int[][] A, int[][] B,int minligne,int maxligne,int mincolonne,int maxcolonne)throws RemoteException;
}