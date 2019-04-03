package hundreddaysofcode.bridge;

public abstract class RemoteButton {

    private EntertainmentDevice theDevice;

    public RemoteButton(EntertainmentDevice newDevice) {
        theDevice = newDevice;
    }

    public void buttonFivePressed() {
        theDevice.buttonFivePressed();
    }

    public void buttonSixPressed() {
        theDevice.buttonSixPressed();
    }

    public void deviceFeedback() {
        theDevice.deviceFeedback();
    }

    public abstract void buttonNinePressed();
}
