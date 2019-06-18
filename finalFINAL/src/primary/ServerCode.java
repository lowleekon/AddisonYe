package primary;

import Request_Response.*;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import javax.swing.*;
import java.io.IOException;

class ServerCode {
    static Server server;
    private static int id = 0;

    static void serverWork(int tcpPort, String password){
        Log.set(2);
        server = new Server();
        Kryo kryo = server.getKryo();
        kryo.register(java.util.ArrayList.class);
        kryo.register(chatLogRequest.class);
        kryo.register(chatLogResponse.class);
        kryo.register(passwordRequest.class);
        kryo.register(passwordResponse.class);
        kryo.register(idRequest.class);
        kryo.register(idResponse.class);
        try {
            server.start();
            server.bind(tcpPort, 54878);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "ERROR: Server ID is taken", "ERROR OCCURRED", JOptionPane.ERROR_MESSAGE);
        }
        chatLogResponse response = new chatLogResponse();
        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
            if (object instanceof chatLogRequest) {
                chatLogRequest request = (chatLogRequest)object;
                response.messageList.add(request.text);
                server.sendToAllTCP(response);
            }
            if (object instanceof passwordRequest){
                passwordRequest request = (passwordRequest)object;
                passwordResponse response = new passwordResponse();
                response.result = request.text.equals(password);
                connection.sendTCP(response);
            }
            if (object instanceof idRequest){
                idResponse response = new idResponse();
                id += 1;
                System.out.println(id);
                response.n = id;
                connection.sendTCP(response);
            }
            }
        });
    }
}
