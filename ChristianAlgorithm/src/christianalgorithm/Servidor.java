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
            PrintWriter out =  new PrintWriter(socket.getOutputStream(), true);
            DataOutputStream output = new DataOutputStream(socket.getOutputStream()); 
            
                    
            serv.enviaMsg(out);
        }
    
    
    }
    public void enviaMsg( PrintWriter out) throws IOException, InterruptedException{
        Random rand= new Random();
        Thread.sleep(rand.nextInt(1000));
        out.println(System.currentTimeMillis()+5000);

    }
}
