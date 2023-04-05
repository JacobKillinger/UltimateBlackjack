import java.beans.Visibility;

public class Main {
    public static void main(String[] args) {
        BlackjackController controller = new BlackjackController();
        BlackjackView view = new BlackjackView();
        //view.initializeView(view);
        controller.startView();
    }
}