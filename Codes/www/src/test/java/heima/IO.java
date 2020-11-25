package heima;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

import org.junit.jupiter.api.Test;

public class IO {

    public static final String url = "www.baidu.com";

    @Test
    void testInetAddress(){

        try {            
            System.out.println(InetAddress.getByName(url));
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    @Test
    void testReadByteStreamFromUrl(){
        try {
            URL url = new URL("http://www.baidu.com");            
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while((line = br.readLine()) != null){
                System.out.print(line);
            }
            br.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
