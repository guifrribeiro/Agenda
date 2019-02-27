/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.sd.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Hugo
 */
public class Servidor {

    public Persistence persistence;

    public Servidor() {
        persistence = new Persistence();
        try {

            //Crie uma instancia da class SocketServer, especializada para servidores (listen embutido)
            ServerSocket socket = new ServerSocket(500);

            while (true) {
                //Espera uma conexão
                Socket socketConectado = socket.accept();

                BufferedReader doClienteBF = new BufferedReader(new InputStreamReader(socketConectado.getInputStream()));
                DataOutputStream paraCliente = new DataOutputStream(socketConectado.getOutputStream());

                String lidoDoCliente = doClienteBF.readLine();
                System.out.println("Servidor@ Mensagem recebida: " + lidoDoCliente);
                switch (OperationTypes.valueOf(lidoDoCliente)) {
                    case CREATE:
                        Integer saveAgenda;
                        saveAgenda = persistence.saveAgenda(new Agenda(doClienteBF.readLine(), doClienteBF.readLine()));
                        paraCliente.writeBytes(saveAgenda + "\n");
                        break;
                    case READ:
                        Agenda agenda;
                        //String name = doClienteBF.readLine();
                        agenda = persistence.findByName(doClienteBF.readLine());
                        paraCliente.writeBytes(agenda.getName() + " ----------- " + agenda.getPhone() + "\n");
                        //paraCliente.writeBytes(agenda.getPhone() + "\n");
                        break;
                    case UPDATE:
                        Integer updateAgenda;
                        updateAgenda = persistence.updateAgenda(new Agenda(doClienteBF.readLine(), doClienteBF.readLine()));
                        paraCliente.writeBytes(updateAgenda + "\n");
                        break;
                    case REMOVE:
                        Integer removeAgenda;
                        removeAgenda = persistence.deleteAgenda(doClienteBF.readLine());
                        paraCliente.writeBytes(removeAgenda + "\n");
                        break;
                }

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
