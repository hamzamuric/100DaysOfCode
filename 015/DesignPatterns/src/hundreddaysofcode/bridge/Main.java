package hundreddaysofcode.bridge;

public class Main {

    public static void main(String[] args) {

        RemoteButton theTV1 = new TVRemoteMute(new TVDevice(1, 200));
        RemoteButton theTV2 = new TVRemotePause(new TVDevice(1, 200));

        System.out.println("Test TV with mute");

        theTV1.buttonFivePressed();
        theTV1.buttonSixPressed();
        theTV1.buttonNinePressed();

        System.out.println("Test TV with pause");

        theTV2.buttonFivePressed();
        theTV2.buttonSixPressed();
        theTV2.buttonSixPressed();
        theTV2.buttonSixPressed();
        theTV2.buttonSixPressed();
        theTV2.buttonNinePressed();
        theTV2.deviceFeedback();

    }
}
