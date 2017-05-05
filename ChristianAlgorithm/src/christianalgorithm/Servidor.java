/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christianalgorithm;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author mayara.barbosa
 */
public class Servidor {
    
    public static void main (String [] args) throws IOException{
        //horario fixo para cliente
        //pergunta pro server
        ServerSocket serverSocket = new ServerSocket(5555);
        
        while(true){
            Socket socket = serverSocket.accept();
            BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
            
        }
    
    
    }
    public void enviaMsg( DataOutputStream out, String msg) throws IOException, InterruptedException{
        Random rand= new Random();
        Thread.sleep(rand.nextInt(1000));
        out.writeUTF(msg);
    }
}
