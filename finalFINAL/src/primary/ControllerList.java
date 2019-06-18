package primary;

import java.util.ArrayList;

public class ControllerList {
    public static ArrayList<Controller> controllerList = new ArrayList<>();

    static void add(Controller controller){
        controllerList.add(controller);
    }

    public static void remove(Controller controller) {
        controllerList.remove(controller);
    }
}