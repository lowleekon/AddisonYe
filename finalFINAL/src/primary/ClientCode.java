package primary;

import Request_Response.*;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;
import java.net.InetAddress;

class ClientCode {
    static void clientStart(Client client, int tcpPort, String password){
        Kryo kryo = client.getKryo();
        kryo.register(java.util.ArrayList.class);
        kryo.register(chatLogRequest.class);
        kryo.register(chatLogResponse.class);
        kryo.register(passwordRequest.class);
        kryo.register(passwordResponse.class);
        kryo.register(idRequest.class);
        kryo.register(idResponse.class);
        InetAddress address = client.discoverHost(54878, 5000);
        try{
            client.start();
            client.connect(5000, address, tcpPort, 54878);
            clientPasswordRequest(client, password);
            idRequest(client);
        }catch(IOException e) {
            e.printStackTrace();
        }
        client.addListener(new Listener(){
            public void received (Connection connection, Object object) {
                if (object instanceof chatLogResponse){
                    chatLogResponse response = (chatLogResponse) object;
                    for (Controller controller : ControllerList.controllerList) {
                        controller.display = response.messageList;
                        controller.refreshList();
                    }
                }
                if (object instanceof passwordResponse){
                    passwordResponse response = (passwordResponse) object;
                    Controller controller = ControllerList.controllerList.get(0);
                    controller.kick(response.result);
                    if(response.result){
                        controller.refreshList();
                    }
                }
                if (object instanceof idResponse){
                    idResponse response = (idResponse) object;
                    for (Controller controller : ControllerList.controllerList) {
                        controller.id = response.n;
                    }
                }
            }
        });
    }

    static void clientChatRequest(Client client, String message){
        chatLogRequest request = new chatLogRequest();
        request.text = message;
        client.sendTCP(request);
    }

    private static void clientPasswordRequest(Client client, String password){
        passwordRequest request = new passwordRequest();
        request.text = password;
        client.sendTCP(request);

    }

    private static void idRequest(Client client){
        idRequest request = new idRequest();
        client.sendTCP(request);
    }
}
