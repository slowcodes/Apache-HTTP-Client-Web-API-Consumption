

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ezenna Charles
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
//import ng.com.aezek.datatruck.database.models.Students;

public class PostRequest extends TimerTask{

    
    private static HttpURLConnection con;
    private static String url;
    private static String urlParameters;
    public static void sendpost() {

        Timer t1 = new Timer();
        t1.schedule(new PostRequest(), 0,90000);

        
    }

    @Override
    public void run() {
        
        url = "http://api.nevs.com.ng/students/users/";
        try {
            try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            
            
            //New updates starts here
            
            //con.setRequestMethod("GET");
            String userCredentials = "admin:1234";
            
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
            con.setRequestProperty("Authorization", basicAuth);
            
            String token = "xyz123wqe"; //Not working
            con.setRequestProperty("AuthToken", token); //Not working
            //Updates ends here
            
            
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Data Truck");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                   
            //Students student = new Students();
            //ResultSet rx = student.getAllStudents();
            //if(rx.next()){        
                
                System.out.print("Initiating new post request");
                
                urlParameters = "last_name='Ike'"
                   .concat("&first_name='Dubaku'")
                   .concat("&middle_name='Chiemela'")
                   .concat("&madien_name='Sobukwe'")
                   .concat("&home_town='Soweto'")
                   .concat("&religion='Christainity'")
                   .concat("&country_code='SA'")
                   .concat("&class_id='4'")
                   .concat("&department='Cultural Studies'")
                   .concat("&faculty='Physical Sciences'")
                   .concat("&lga_id='34'")
                   .concat("&state='Johansburg'")
                   .concat("&nok_name='Samuel'")
                   .concat("&nok_phone='+2790129202'")
                   .concat("&nok_email='nelson.bigheti@siliconvalley.com'")
                   .concat("&nok_address='No. 1 Hilbury way, Chimaroke'")
                   .concat("&matric_no='2009/290391'")     
                   .concat("&phone='+2790394022'")
                   .concat("&sex='Female'")
                   .concat("&email='simeon.wellson@soweto.com'")
                   .concat("&marrital_status='Married'")
                   .concat("&dob='29/10/1999'")
                   .concat("&nevsid='4'")
                   .concat("&address='17 Church road, Free Town, South Africa'");
                
                con.setRequestProperty("Content-Length", "" + urlParameters.getBytes().length);
                //System.out.print(""+Photo.get_photo(rx.getString("students.matric_no")));
                //get photo, login to ftp server and dump picture
                
                
                byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
                try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                    wr.write(postData);
                }

                StringBuilder content;

                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()))) {

                    String line;
                    content = new StringBuilder();

                    while ((line = in.readLine()) != null) {
                        content.append(line);
                        content.append(System.lineSeparator());
                    }
                }

                System.out.println(content.toString());
//            }

//        } catch (SQLException ex) {
//            Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
//        }   
        }
            catch (MalformedURLException ex) {
            Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            con.disconnect();
        }
                    
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
