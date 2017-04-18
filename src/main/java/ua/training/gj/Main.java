package ua.training.gj;

/**
 * Created by andrew on 17.04.17.
 */
public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }


}
