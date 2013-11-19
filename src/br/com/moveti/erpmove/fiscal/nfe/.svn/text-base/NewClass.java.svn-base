/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe;

import java.net.*;
import java.io.*;

/**
 *
 * @author Henrique
 */
public class NewClass {

    public static void main(String[] args) {

        try {
            String xmldata = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>"
                    + "<USER>"
                    + "<LOGIN>move</LOGIN>"
                    + "<PASSWORD>move</PASSWORD>"
                    + "<FORCELOGIN>1</FORCELOGIN>"
                    + "</USER>";

            xmldata = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>"
                    + "<ITEM>"
                    + "<ID>2015</ID>"
                    + "</ITEM>";

            xmldata = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>"
                    + "<COURSES>"
                    + "<VEHICLES>"
                    + "<VEHICLE_ID>2015</VEHICLE_ID> "
                    + "</VEHICLES>"
                    + "<START>2013-07-01</START>"
                    + "<END>2013-07-05</END>"
                    + "</COURSES>";


//			xmldata = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
//					  	"<ITEM>"+
//					  		"<ID>111</ID>"+
//					  	"</ITEM>";
            // Create socket
            String hostname = "201.48.134.115";
            int port = 80;
            InetAddress addr = InetAddress.getByName(hostname);
            Socket sock = new Socket(addr, port);

            // Send header
            //http://201.48.134.115/scripts/arenawebservice555.dll
            //String path = "http://" + hostname + "/scripts/arenawebservice555.dll/login?WebBrokerSessionMac=00:1E:4C:4B:A9:C5";
            String path = "http://" + hostname + "/scripts/arenawebservice555.dll//mapcourses?WebBrokerSessionID=93eb36d851ead87e87632b428c4ad4b9";
            //path = "/scripts/arenawebservice555.dll/describeclient?WebBrokerSessionID=c81ac2b8e0ce25708cbb534f0be9b452";
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(), "utf-8"));
            // You can use "UTF8" for compatibility with the Microsoft virtual
            // machine.
            wr.write("POST " + path + " HTTP/1.0\r\n");
            wr.write("Host: " + hostname + "\r\n");
            wr.write("Content-Length: " + xmldata.length() + "\r\n");
            wr.write("Content-Type: application/xml; charset=\"utf-8\"\r\n");
            wr.write("\r\n");

            // Send data
            wr.write(xmldata);
            wr.flush();

            // Response
            BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String line;
            String S = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(new String(line.getBytes(), "ISO-8859-1"));
                S += new String(line.getBytes(), "ISO-8859-1");
            }
            String sessao = S.substring(401, 433);





            hostname = "201.48.134.115";
            port = 80;
            addr = InetAddress.getByName(hostname);
            sock = new Socket(addr, port);


            xmldata = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>"
                    + "<ITEM>"
                    + "<ID>2015</ID>"
                    + "</ITEM>";
            path = "http://" + hostname + "/scripts/arenawebservice555.dll/describevehicle?WebBrokerSessionID=" + sessao;
            System.out.println(path);
            //path = "/scripts/arenawebservice555.dll/describeclient?WebBrokerSessionID=c81ac2b8e0ce25708cbb534f0be9b452";
            wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(), "utf-8"));
            // You can use "UTF8" for compatibility with the Microsoft virtual
            // machine.
            wr.write("POST " + path + " HTTP/1.0\r\n");
            wr.write("Host: " + hostname + "\r\n");
            wr.write("Content-Length: " + xmldata.length() + "\r\n");
            wr.write("Content-Type: application/xml; charset=\"utf-8\"\r\n");
            wr.write("\r\n");

            // Send data
            wr.write(xmldata);
            wr.flush();

            // Response
            rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            while ((line = rd.readLine()) != null) {
                System.out.println("SQL");
                System.out.println(new String(line.getBytes(), "ISO-8859-1"));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
