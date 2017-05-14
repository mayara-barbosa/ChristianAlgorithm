/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christianalgorithm;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author mayara.barbosa
 */
public class Cliente {
    
    public static void main(String args[]) throws UnknownHostException, IOException, InterruptedException{
    
        Cliente cli = new Cliente();
        Socket clientSocket = new Socket(InetAddress.getLocalHost(), 5555);
        PrintWriter out =  new PrintWriter(clientSocket.getOutputStream(), true);
        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader buf = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String clientTime = "21:49:22";
       
        
        
        long T0;
        long serverTime;
        long T1;
        long finalTime;                
        out.println(T0=System.currentTimeMillis());
        serverTime = Long.parseLong(in.readLine());
        T1 =System.currentTimeMillis();
        finalTime =  serverTime + (T1-T0)/2;
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
        System.out.println("Client Time: " + formatter.format(new Date(T1)));
        System.out.println("Server Time: " + formatter.format(new Date(serverTime)));
        System.out.println("Client Time after reset: " + formatter.format(new Date(finalTime)));
   
    
    }
    public void enviaMsg( DataOutputStream out, String msg) throws IOException, InterruptedException{
        Random rand= new Random();
        Thread.sleep(rand.nextInt(1000));
        out.writeUTF(msg);
    }
}
