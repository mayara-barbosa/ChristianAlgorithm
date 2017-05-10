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
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author mayara.barbosa
 */
public class Servidor {
    
    public static void main (String [] args) throws IOException, InterruptedException{
        //horario fixo para cliente
        //pergunta pro server
        ServerSocket serverSocket = new ServerSocket(5555);
        Servidor serv = new Servidor();
         
        while(true){
            Socket socket = serverSocket.accept();
            BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
            
            final long durationI;
            final long startTime = System.nanoTime();
            String msg = in.readUTF(); 
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            String serverTime = dateFormat.format(date);
            final long endTime = System.nanoTime();
            durationI = endTime - startTime;
                
            serv.enviaMsg(out, serverTime, durationI);
        }
    
    
    }
    public void enviaMsg( DataOutputStream out, String msg, long i) throws IOException, InterruptedException{
        Random rand= new Random();
        Thread.sleep(rand.nextInt(1000));
        out.writeUTF(msg);
        out.writeLong(i);
    }
}
