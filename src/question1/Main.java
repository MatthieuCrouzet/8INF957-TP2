package question1;

import question1.entities.World;
import question1.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        World w = new World(new UserInterface());

        w.run();
    }
}