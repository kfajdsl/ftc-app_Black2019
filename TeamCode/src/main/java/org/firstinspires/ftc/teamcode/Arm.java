package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Arm {
    public static void armSpeed(double speed) {
        Hardware.arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.arm.setPower(speed);
    }

    public static void extendSpeed(double speed) {
        Hardware.armExtend.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.armExtend.setPower(speed);
    }

    public static void lift(double speed) {
        Hardware.lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.lift.setPower(speed);
    }

    public static void intake(double speed) {
        Hardware.intake.setPower(speed);
    }
}
