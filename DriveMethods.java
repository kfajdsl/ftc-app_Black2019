package org.firstinspires.ftc.teamcode;


/**
 * Created by Kunal on 2018-10-15.
 */

public class DriveMethods extends Hardware {

    public static void driveRight(double speed){
        rightMidDrive.setPower(speed);
        rightBackDrive.setPower(speed);
    }

    public static void driveLeft(double speed){
        leftMidDrive.setPower(speed);
        leftBackDrive.setPower(speed);
    }


}