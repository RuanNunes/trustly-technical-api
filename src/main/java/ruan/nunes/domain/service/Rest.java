package ruan.nunes.domain.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Rest {

    public static String GET(final String targetURL){
        try {
            //Create connection
            final URL url = new URL(targetURL);
            final HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestProperty("custom-Header", "XYZ");
//            connection.setRequestProperty("Content-Length", String.valueOf(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-BR");
            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

//            //Send request
//            final DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
//            wr.writeBytes (urlParameters);
//            wr.flush ();
//            wr.close ();

            //Get Response
            final InputStream is = connection.getInputStream();
            final BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            final StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String POST(final String targetURL, final String urlParameters){
        try {
            //Create connection
            final URL url = new URL(targetURL);
            final HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestProperty("custom-Header", "XYZ");
            connection.setRequestProperty("Content-Length", String.valueOf(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-BR");
            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            final DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
            wr.writeBytes (urlParameters);
            wr.flush ();
            wr.close ();

            //Get Response
            final InputStream is = connection.getInputStream();
            final BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            final StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
