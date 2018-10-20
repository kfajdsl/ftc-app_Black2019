package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class ArmMethods extends Hardware {
    static final int TICK_GOAL = 405 * 4; //180 is distance to move arm in degrees. * 4 because Tetrix motors have 1440 ticks.

    public static void raiseArm() {
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setTargetPosition(TICK_GOAL);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public static void lowerArm() {
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setTargetPosition(-TICK_GOAL);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public static void armPower(double speed) {
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setPower(speed);
    }
}
