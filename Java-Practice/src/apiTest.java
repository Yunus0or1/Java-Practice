import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.*;
import org.omg.CORBA.portable.InputStream;

public class apiTest {
    public static void main(String[] args) {
        try {

            String domainName = "http://dummyjson.com/products";

            URL url = new URL(domainName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() == 200) {
                // Scanner scan = new Scanner(url.openStream());
                // while (scan.hasNext()) {
                // String temp = scan.nextLine();
                // System.out.println(temp);
                // }
                ObjectMapper mapper = new ObjectMapper(); // just need one
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}