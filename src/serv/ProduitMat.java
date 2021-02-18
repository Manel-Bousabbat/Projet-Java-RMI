package serv;


import java.rmi.*;
import java.rmi.server.*;
public class ProduitMat extends UnicastRemoteObject implements ProduitMatInterface {

       public ProduitMat() throws RemoteException
       {
	    super();
       }
       

   	public int[][] CalculProduitMat(int n,int[][] A, int[][] B,int minligne,int maxligne,int mincolonne,int maxcolonne)throws RemoteException{
  
    	int[][] prod=new int[n/2][n/2];
     
	     for (int i=0 ; i<maxligne-minligne ; i++){
	    	 for(int j=0;j<maxcolonne-mincolonne;j++)
	         {		prod[i][j] = 0;
	             for(int k=0; k<n/2 ;k++)
	             {
	                 prod[i][j] += A[i+minligne][k+mincolonne] * B[k+minligne][j+mincolonne];
	             }
	         }
                 
       
            }
     
   return prod ; 
     }}

