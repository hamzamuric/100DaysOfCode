package hundreddaysofcode.bridge;

public class TVDevice extends EntertainmentDevice {

    public TVDevice(int newDeviceState, int newMaxSetting) {
        deviceState = newDeviceState;
        maxSetting = newMaxSetting;
    }

    @Override
    public void buttonFivePressed() {
        System.out.println("Channel down");
        deviceState--;
    }

    @Override
    public void buttonSixPressed() {
        System.out.println("Channel up");
        deviceState++;
    }
}
