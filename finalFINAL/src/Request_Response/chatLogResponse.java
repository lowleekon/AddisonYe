package Request_Response;

import java.util.ArrayList;

public class chatLogResponse {
    public ArrayList<String> messageList = new ArrayList<>();

    @Override
    public String toString() {
        return messageList.toString();
    }
}
