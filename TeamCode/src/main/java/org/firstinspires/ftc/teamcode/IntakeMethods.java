package org.firstinspires.ftc.teamcode;

public class IntakeMethods extends Hardware {


    public static void intakeStop() {
        //intakeLeft.setPower(-0.01); //this is this instead of 0 because the servo is janky.
        intakeRight.setPower(0);
    }

    public static void intakeIn() {
        //intakeLeft.setPower(1);
        intakeRight.setPower(1);
    }

    public static void intakeOut() {
        //intakeLeft.setPower(-1);
        intakeRight.setPower(-1);
    }

}
