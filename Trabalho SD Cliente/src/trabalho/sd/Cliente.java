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
 * @author Hugo
 */
public class Cliente {

    public static void main(String[] args) {
        
        Operations operations = new Operations();
        
        ClienteGUI cg = new ClienteGUI();
        cg.show();
        
/*
        try {
            //                      Experimento 1                             

            // Cria um socket para conectar ao ip/porta do servidor
            Socket socket = new Socket("localhost", 500);

            // Cria um stream de saída
            DataOutputStream paraServidor = new DataOutputStream(socket.getOutputStream());
            // e um de entrada, do socket
            BufferedReader doServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Envia mensagem digitada para o servidor.
            paraServidor.writeBytes("CREATE" + "\n");
            paraServidor.writeBytes("teste5" + "\n");
            paraServidor.writeBytes("xx55444" + "\n");

            // Recebe resposta do servidor
            String socketStr = doServidor.readLine();
            System.out.println("Cliente@ Resposta: " + socketStr);
            //socketStr = doServidor.readLine();
            //System.out.println("Cliente@ Resposta: " + socketStr);

            // Fecha o Socket
            socket.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
*/

    }
}
