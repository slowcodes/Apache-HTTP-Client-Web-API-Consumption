
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ezenna Charles
 */
public class Agent extends Thread {
    
    public static void main(String[] args){
        BackgroundThread bgthread = new BackgroundThread();
        bgthread.start();
    }
    
    @Override
    public void run(){
        System.out.println("Started background thread to post data");
        try {
                        
            PostRequest.sendpost();
            
        } catch (Exception ex) {
            Logger.getLogger(Agent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

