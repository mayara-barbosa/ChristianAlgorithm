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
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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
        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader buf = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String clientTime = "21:49:22";
        final long t0 = System.nanoTime();
        
        cli.enviaMsg(out, "quero o horario certo");
        long rightTime = Long.parseLong(in.readUTF());
        long i = in.readLong();
        final long t1 = System.nanoTime();
        long d = t1 - t0 - i;
        
        long T = rightTime +  d;
        System.out.println(T);
   
    
    }
    public void enviaMsg( DataOutputStream out, String msg) throws IOException, InterruptedException{
        Random rand= new Random();
        Thread.sleep(rand.nextInt(1000));
        out.writeUTF(msg);
    }
}
