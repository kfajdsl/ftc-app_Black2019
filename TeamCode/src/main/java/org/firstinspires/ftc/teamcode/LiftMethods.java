package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class LiftMethods extends Hardware {
    static final double CIRCUM = 2.5133; //Circumference of pinion attached to liftMotor in inches. Diameter is 0.8in
    static final double DIST = 5; //Distance we want to raise lift in inches
    static final int TICK_GOAL = (int) (1440 / CIRCUM * DIST);

    public static void raiseLift() {
        lift.setTargetPosition(TICK_GOAL);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        /* old code. Keeping around in case the above code does not work as intended.
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setTargetPosition(TICK_GOAL);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        */
    }

    public static void lowerLift() {
        lift.setTargetPosition(0);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        /* old code. Keeping around in case the above code does not work as intended.
        lift.setTargetPosition(0);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        */
    }

    public static void liftPower(double speed) {
       lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       lift.setPower(speed);
    }

}
