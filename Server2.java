import java.util.*;
import java.io.*;
import java.net.*;

class Server2
{
    public static void main(String A[]) throws Exception
    {
        System.out.println("Server is running...");
        ServerSocket ssobj = new ServerSocket(2100);
        System.out.println("Server is waiting at 2100");
        Socket sobj = ssobj.accept();
        System.out.println("Clients request arries and gets accepted by server");

        DataInputStream diobj = new DataInputStream(sobj.getInputStream());
        DataOutputStream doobj = new DataOutputStream(sobj.getOutputStream());

        
        
        try
        {
            int iNo1 = diobj.readInt();
            
            int iNo2 = diobj.readInt();

            int iSum = iNo1 + iNo2;

            doobj.writeInt(iSum);

            doobj.flush();
        }
        catch(Exception eobj1)
        {
            System.out.println("Client Disconnected");
        }


        sobj.close();
        ssobj.close();
        System.out.println("Server application terminated");
    }
}