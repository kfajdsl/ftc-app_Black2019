/**
 * Created by Sahan Reddy on 2018-11-4
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public  class DriveMethods {

    final static double TICKS_PER_INCH = 1440 / 10; //FIXME replace 10 with correct circumference
    final static double DEGREES_PER_TICK = 10; //FIXME replace with actual degree/tick number

    public static void driveLeft(double speed) {
        Hardware.leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.leftMidDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.leftBackDrive.setPower(speed);
        Hardware.leftMidDrive.setPower(speed);
    }

    public static void driveRight(double speed) {
        Hardware.rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.rightMidDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.rightBackDrive.setPower(speed);
        Hardware.rightMidDrive.setPower(speed);
    }

    public static void driveDist(double inches) throws InterruptedException {
        int target = (int) (inches * TICKS_PER_INCH);

        Hardware.rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware.rightMidDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware.leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware.leftMidDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Hardware.rightBackDrive.setTargetPosition(target);
        Hardware.rightMidDrive.setTargetPosition(target);
        Hardware.leftBackDrive.setTargetPosition(target);
        Hardware.leftMidDrive.setTargetPosition(target);

        Hardware.rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Hardware.rightMidDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Hardware.leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Hardware.leftMidDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //TODO explain why this exists in comments if this works. God knows I'll forget
        while (Hardware.rightBackDrive.isBusy() ||
                Hardware.rightMidDrive.isBusy() ||
                Hardware.leftBackDrive.isBusy() ||
                Hardware.leftMidDrive.isBusy()) {
            Thread.sleep(10);
        }
    }

    public static void turnLeft(int degrees) throws InterruptedException {
        int target = (int) (degrees * DEGREES_PER_TICK); //FIXME replace 10 with correct ticks-per-degree

        Hardware.rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware.rightMidDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware.leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware.leftMidDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Hardware.rightBackDrive.setTargetPosition(target);
        Hardware.rightMidDrive.setTargetPosition(target);
        Hardware.leftBackDrive.setTargetPosition(-1 * target);
        Hardware.leftMidDrive.setTargetPosition(-1 * target);

        Hardware.rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Hardware.rightMidDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Hardware.leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Hardware.leftMidDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //TODO explain why this exists in comments if this works. God knows I'll forget
        while (Hardware.rightBackDrive.isBusy() ||
                Hardware.rightMidDrive.isBusy() ||
                Hardware.leftBackDrive.isBusy() ||
                Hardware.leftMidDrive.isBusy()) {
            Thread.sleep(10);
        }
    }

    public static void turnRight(int degrees) throws InterruptedException {
        int target = (int) (degrees * DEGREES_PER_TICK); //FIXME replace 10 with correct ticks-per-degree

        Hardware.rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware.rightMidDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware.leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware.leftMidDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Hardware.rightBackDrive.setTargetPosition(-1 * target);
        Hardware.rightMidDrive.setTargetPosition(-1 * target);
        Hardware.leftBackDrive.setTargetPosition(target);
        Hardware.leftMidDrive.setTargetPosition(target);

        Hardware.rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Hardware.rightMidDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Hardware.leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Hardware.leftMidDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //TODO explain why this exists in comments if this works. God knows I'll forget
        while (Hardware.rightBackDrive.isBusy() ||
                Hardware.rightMidDrive.isBusy() ||
                Hardware.leftBackDrive.isBusy() ||
                Hardware.leftMidDrive.isBusy()) {
            Thread.sleep(10);
        }
    }
}
