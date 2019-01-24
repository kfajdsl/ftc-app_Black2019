package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Arm {
    public static void armSpeed(double speed) {
        Hardware.arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Hardware.arm.setPower(speed);
    }

    public static void extendSpeed(double speed) {
        Hardware.extend.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.extend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Hardware.extend.setPower(speed);
    }

    public static void lift(double speed) {
        Hardware.lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Hardware.lift.setPower(speed);
    }

    public static void intake(double speed) {
        Hardware.intake.setPower(speed);
    }
}
