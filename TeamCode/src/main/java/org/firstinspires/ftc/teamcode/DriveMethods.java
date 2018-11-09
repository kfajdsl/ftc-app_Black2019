/**
 * Created by Sahan Reddy on 2018-11-4
 */

package org.firstinspires.ftc.teamcode;

public  class DriveMethods {

    public static void driveLeft(double speed) {
        Hardware.leftBackDrive.setPower(speed);
        Hardware.leftMidDrive.setPower(speed);
    }

    public static void driveRight(double speed) {
        Hardware.rightBackDrive.setPower(speed);
        Hardware.rightMidDrive.setPower(speed);
    }

    public static void drive(double speed) {
        driveLeft(speed);
        driveRight(speed);
    }

    public static void turnLeft(double speed) {
        driveLeft(-speed);
        driveRight(speed);
    }

    public static void turnRight(double speed) {
        driveLeft(speed);
        driveRight(-speed);
    }
}
