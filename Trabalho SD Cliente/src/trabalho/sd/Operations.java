/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho.sd;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme Ribeiro
 */
public class Operations {
        
    public String Create (String ip, int port, String name, String phone) {
        try {
            Socket socket = new Socket(ip, port);
            
            DataOutputStream paraServidor = new DataOutputStream(socket.getOutputStream());
            BufferedReader doServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            paraServidor.writeBytes("CREATE" + "\n");
            paraServidor.writeBytes(name + "\n");
            paraServidor.writeBytes(phone + "\n");
            
            String socketStr = doServidor.readLine();
            System.out.println("Cliente@ Resposta: " + socketStr);
            
            socket.close();
            
            return "Phone add.";
            
        } catch(UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String Update (String ip, int port, String name, String phone) {
        try {
            
            Socket socket = new Socket(ip, port);
            
            DataOutputStream paraServidor = new DataOutputStream(socket.getOutputStream());
            BufferedReader doServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            paraServidor.writeBytes("UPDATE" + "\n");
            paraServidor.writeBytes(name + "\n");
            paraServidor.writeBytes(phone + "\n");
            
            String socketStr = doServidor.readLine();
            System.out.println("Cliente@ Resposta: " + socketStr);
            
            socket.close();
            
            return "Phone " + name + "update: \n" + phone;
            
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String Read (String ip, int port, String name) {
        try {
            
            Socket socket = new Socket(ip, port);
            
            DataOutputStream paraServidor = new DataOutputStream(socket.getOutputStream());
            BufferedReader doServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            paraServidor.writeBytes("READ" + "\n");
            paraServidor.writeBytes(name + "\n");
                        
            String socketStr = doServidor.readLine();
            System.out.println("Cliente@ Resposta: " + socketStr);
                        
            socket.close();
            
            return socketStr;
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
           
    public String Remove (String ip, int port, String name) {
        try {
            
            Socket socket = new Socket(ip, port);
            
            DataOutputStream paraServidor = new DataOutputStream(socket.getOutputStream());
            BufferedReader doServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            paraServidor.writeBytes("REMOVE" + "\n");
            paraServidor.writeBytes(name + "\n");
                        
            String socketStr = doServidor.readLine();
            System.out.println("Cliente@ Resposta: " + socketStr);
            
            socket.close();
            
            return "Phone " + name + "delete.";
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    
}
