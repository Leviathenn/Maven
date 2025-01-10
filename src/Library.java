/**
 * @author Leviathenn
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.math.*;
import org.json.*;


public class Library{
    public static String name = "Maven";
    public static String version = "1.0.0";
    public static String author = "Leviathenn";
    public Library(){
        
    }
    public String getDependancies(String information){
        try {

            String packageID = (information.split(":").length > 1) ? information.split(":")[0] : null;
            String version = (information.split(":").length > 1) ? information.split(":")[2] : null;
            String name = (information.split(":").length > 1) ? information.split(":")[1] : null;
            String fileUrl = "https://repo1.maven.org/maven2/";
            if(packageID != null){
                fileUrl += packageID.replace(".", "/") + "/" + name + "/";
            }
            if(version != null){
                 fileUrl += version + "/" + name + "-" + version + ".pom";
            }else{
                HttpClient client = HttpClient.newHttpClient();
                String tmpUrl = "https://search.maven.org/solrsearch/select?q="+packageID+"&rows=20&wt=json";
        
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(tmpUrl)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if(response.statusCode() == 200){
                    JSONObject json = new JSONObject(response.body());
                    JSONArray docs = json.getJSONObject("response").getJSONArray("docs");
                    JSONObject doc = docs.getJSONObject(0);
                    
                    String latestVersion = doc.getString("latestVersion");
                    fileUrl += latestVersion + "/" + packageID + "-" + latestVersion + ".pom";
                }

            }
  
       
            try{
                URL url = new URL(fileUrl);
                System.out.println(fileUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                // Check for successful response code
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("Failed to download file: HTTP error code " + connection.getResponseCode());
                }

                try (InputStream inputStream = connection.getInputStream();
                    
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                int totalSize = connection.getContentLength();
                             
                try {
               
                 byte[] buffer = new byte[4096];
                 int bytesRead;
                    
                 while ((bytesRead = inputStream.read(buffer)) != -1) {
                     outputStream.write(buffer, 0, bytesRead);
                    
                
                 }
      
                } catch (Exception e) {
                    e.printStackTrace();
                };
                 return outputStream.toString(); // Return the byte array
             } finally {
                 connection.disconnect(); // Always disconnect
             }
             }catch(Exception e){
                 e.printStackTrace();
             }
            return null;
            
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
    public byte[] FetchFile(String information){
        try {

            String packageID = (information.split(":").length > 1) ? information.split(":")[0] : null;
            String version = (information.split(":").length > 1) ? information.split(":")[2] : null;
            String name = (information.split(":").length > 1) ? information.split(":")[1] : null;
            String fileUrl = "https://repo1.maven.org/maven2/";
            if(packageID != null){
                fileUrl += packageID.replace(".", "/") + "/" + name + "/";
            }
            if(version != null){
                 fileUrl += version + "/" + name + "-" + version + ".jar";
            }else{
                HttpClient client = HttpClient.newHttpClient();
                String tmpUrl = "https://search.maven.org/solrsearch/select?q="+packageID+"&rows=20&wt=json";
        
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(tmpUrl)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if(response.statusCode() == 200){
                    JSONObject json = new JSONObject(response.body());
                    JSONArray docs = json.getJSONObject("response").getJSONArray("docs");
                    JSONObject doc = docs.getJSONObject(0);
                    
                    String latestVersion = doc.getString("latestVersion");
                    fileUrl += latestVersion + "/" + packageID + "-" + latestVersion + ".jar";
                }

            }
  
       
            try{
                URL url = new URL(fileUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                // Check for successful response code
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("Failed to download file: HTTP error code " + connection.getResponseCode());
                }

                try (InputStream inputStream = connection.getInputStream();
                    
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                int totalSize = connection.getContentLength();
                             
                try {
               
                 byte[] buffer = new byte[4096];
                 int bytesRead;
                    
                 while ((bytesRead = inputStream.read(buffer)) != -1) {
                     outputStream.write(buffer, 0, bytesRead);
                    
                
                 }
      
                } catch (Exception e) {
                    e.printStackTrace();
                };
                 return outputStream.toByteArray(); // Return the byte array
             } finally {
                 connection.disconnect(); // Always disconnect
             }
             }catch(Exception e){
                 e.printStackTrace();
             }
            return null;
            
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
}