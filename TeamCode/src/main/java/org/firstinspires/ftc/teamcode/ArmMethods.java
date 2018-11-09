/**
 * Created by Sahan Reddy on 2018-11-4
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public  class ArmMethods {

    public static void liftPower(double speed) {
        Hardware.lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.lift.setPower(speed);
    }

    public static void armPower(double speed) {
        Hardware.arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.arm.setPower(speed);
    }

    //FIXME replace target positions with correct values
    public static void raiseLift() throws InterruptedException{
        //Hardware.lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //might not need this
        Hardware.lift.setTargetPosition(0); //2 inches
        Hardware.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(Hardware.lift.isBusy()) {
            Thread.sleep(10);
        }
    }

    public static void raiseLiftMax() throws InterruptedException {
        //Hardware.lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //might not need this
        Hardware.lift.setTargetPosition(0); //4 inches
        Hardware.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(Hardware.lift.isBusy()) {
            Thread.sleep(10);
        }
    }

    public static void lowerLift() throws InterruptedException {
        Hardware.lift.setTargetPosition(0);
        Hardware.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(Hardware.lift.isBusy()) {
            Thread.sleep(10);
        }
    }

    public static void raiseArm() throws InterruptedException {
        //Hardware.arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //might not need this
        Hardware.arm.setTargetPosition(0); //135 degrees
        Hardware.arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(Hardware.arm.isBusy()) {
            Thread.sleep(10);
        }
    }

    public static void lowerArm() throws InterruptedException {
        Hardware.arm.setTargetPosition(0);
        Hardware.arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(Hardware.arm.isBusy()) {
            Thread.sleep(10);
        }
    }

    //FIXME enter right times etc
    public static void deHook() throws InterruptedException {
        raiseLiftMax();
        DriveMethods.drive(-1);
        Thread.sleep(250);
        DriveMethods.drive(0);
        lowerLift();
        DriveMethods.drive(0.5);
        Thread.sleep(500);
        DriveMethods.drive(0);
    }

    public static void marker() throws InterruptedException {
        raiseLift(); //lift lift
        raiseArm(); //raise arm
        lowerArm(); //lower arm
        lowerLift(); //lower lift
    }

}
