package hundreddaysofcode.command;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ElectronicDevice newDevice = TVRemote.getDevice();
        TurnTVOn onCommand = new TurnTVOn(newDevice);
        DeviceButton onPressed = new DeviceButton(onCommand);
        onPressed.press();

        /////////////////////////////////////////////////////

        TurnTVOff offCommand = new TurnTVOff(newDevice);
        onPressed = new DeviceButton(offCommand);
        onPressed.press();

        /////////////////////////////////////////////////////

        TurnTVUp volUpCommand = new TurnTVUp(newDevice);
        onPressed = new DeviceButton(volUpCommand);
        onPressed.press();
        onPressed.press();
        onPressed.press();

        /////////////////////////////////////////////////////

        Television theTV = new Television();
        Radio theRadio = new Radio();
        List<ElectronicDevice> allDevices = new ArrayList<>();
        allDevices.add(theTV);
        allDevices.add(theRadio);

        TurnItAllOff turnOffDevices = new TurnItAllOff(allDevices);
        DeviceButton turnThemOff = new DeviceButton(turnOffDevices);
        turnThemOff.press();

        /////////////////////////////////////////////////////

        turnThemOff.pressUndo();
    }
}
