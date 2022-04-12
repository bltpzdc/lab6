package client.tools;

import server.tools.ServerAnswer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientReceiver {
    public void receive(DatagramSocket clientSocket) throws IOException {
        byte[] receiveArray = new byte[8096];
        DatagramPacket receivePacket = new DatagramPacket(receiveArray, receiveArray.length);
        clientSocket.receive(receivePacket);
        System.out.println("Answer from server received:");
        try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(receiveArray))){
            ServerAnswer serverAnswer = (ServerAnswer) ois.readObject();
            System.out.println(serverAnswer.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
