package org.firstinspires.ftc.teamcode;

public class SensorMethods extends Hardware {

    public static boolean isGold() { //FIXME calibrate color
        final int THRES = 10;
        if (Hardware.colorSensor.red() < Hardware.colorSensor.blue() + 150 &&
            Hardware.colorSensor.green() < Hardware.colorSensor.blue() + 150 &&
            Hardware.colorSensor.red() - Hardware.colorSensor.green() <= THRES) {
            return true;
        } else {
            return false;
        }
    }

}
