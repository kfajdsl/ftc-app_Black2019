package org.firstinspires.ftc.teamcode;

public class IntakeMethods extends Hardware{
    public static void inTake (double speed){
        intake.setPower(speed);
    }
    public static void outTake (double speed){
        intake.setPower(speed); //declared in main teleop class
    }
}
