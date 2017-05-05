/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christianalgorithm;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author mayara.barbosa
 */
public class Cliente {
    
    
    public void enviaMsg( DataOutputStream out, String msg) throws IOException, InterruptedException{
        Random rand= new Random();
        Thread.sleep(rand.nextInt(1000));
        out.writeUTF(msg);
    }
}
