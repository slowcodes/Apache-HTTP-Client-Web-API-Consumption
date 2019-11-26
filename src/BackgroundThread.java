/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ezenna Charles
 */
public class BackgroundThread  extends Thread{
    
    @Override
    public void run(){
        System.out.println("Started background thread to post data");
        try {
                        
            PostRequest.sendpost();
            
        } catch (Exception ex) {
            Logger.getLogger(BackgroundThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}

