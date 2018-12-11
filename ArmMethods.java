package org.firstinspires.ftc.teamcode;

public class ArmMethods extends Hardware {
    public static void liftArm (double speed){
        lift.setPower(speed);
    }
    public static void openArm (double speed){
        arm.setPower(speed);
    }
    /*
    public static void fullLiftArm(double speed){
        armMiddleLift.setPower(speed);
        armMiddleOpen.setPower(speed);
        armMiddleLift.set
    }
    */
}
