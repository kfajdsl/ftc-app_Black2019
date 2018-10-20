package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;

import static java.lang.Thread.sleep;

/**
 * Created by shrey on 2017-11-05.
 * Modified by Sahan Reddy on 2018-10-16
 */

public class DriveMethods extends Hardware {

        public static void driveRight(double speed){
            rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightDrive.setPower(speed);
        }

        public static void driveLeft(double speed){
            leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftDrive.setPower(speed);
        }

    /*
     * This method is used to stop the drive motors in order for the robot to stop when in between
     * the two thresholds. It's important to do this so the robot will stop, safely
     */

        public static void stopRightMotors() { //always zero
            rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightDrive.setPower(0);
        }

        public static void stopLeftMotors(){
            rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftDrive.setPower(0);
        }

        //FIXME fill in wheel circumference here
        static final double WHEEL_CIRCUM = 0;
        static final int TICKS_PER_INCH = (int) (1440 / WHEEL_CIRCUM);

        public static void timeTurnRight(int seconds) throws InterruptedException {
            driveRight(-1);
            driveLeft(1);
            sleep(seconds * 1000);
            stopRightMotors();
            stopLeftMotors();
        }

        public static void timeTurnLeft(int seconds) throws InterruptedException {
            driveRight(1);
            driveLeft(-1);
            sleep(seconds * 1000);
            stopRightMotors();
            stopLeftMotors();
        }


        public static void driveDist(double inches) {
            rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            rightDrive.setTargetPosition((int) (inches * TICKS_PER_INCH));
            leftDrive.setTargetPosition((int) (inches * TICKS_PER_INCH));

            rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        //FIXME calibrate this (calculate ticks / degree). add degrees parameter.
        public static void turn() {
            rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            rightDrive.setTargetPosition(-960);
            leftDrive.setTargetPosition(960);

            //measure how much the robot turns with that, and calculate ticks per degree.
            //Ex. 2.3 ticks per degree
            // int tickGoal = (int) 2.3 * degree;
            //rightDrive.setTargetPosition(-1 * tickGoal);
            //leftDrive.setTargetPosition(tickGoal);

            rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

}
