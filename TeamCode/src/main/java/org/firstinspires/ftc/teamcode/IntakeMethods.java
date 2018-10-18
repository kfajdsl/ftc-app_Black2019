package org.firstinspires.ftc.teamcode;

public class IntakeMethods extends Hardware {

    public static void intakeStop() {
        intakeLeft.setPower(0);
        intakeRight.setPower(0);
    }

    public static void intakeIn() {
        intakeLeft.setPower(0.8);
        intakeRight.setPower(0.8);
    }

    public static void intakeOut() {
        intakeLeft.setPower(-0.8);
        intakeRight.setPower(-0.8);
    }

}
