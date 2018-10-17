package org.firstinspires.ftc.teamcode;


/**
 * Created by shrey on 2017-11-05.
 */

public class DriveMethods extends Hardware {

        public static void driveRight(double speed){
            rightDrive.setPower(speed);
        }

        public static void driveLeft(double speed){
            leftDrive.setPower(speed);
        }

    /*
     * This method is used to stop the drive motors in order for the robot to stop when in between
     * the two thresholds. It's important to do this so the robot will stop, safely
     */
        public static void stopRightMotors() { //always zero
            rightDrive.setPower(0);
        }

        public static void stopLeftMotors(){
            leftDrive.setPower(0);
        }
}
