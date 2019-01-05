package swing;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 05/01/2019 / 14:43
 * Class: Main
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class Main {

    public static void main(String[] args)
    {

    }

    public static void pause(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
