package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware {
    private ElapsedTime runtime = new ElapsedTime();

    public static DcMotor leftBackDrive;
    public static DcMotor leftFrontDrive;
    public static DcMotor rightBackDrive;
    public static DcMotor rightFrontDrive;

    public static DcMotor intake;
    public static DcMotor arm;
    public static DcMotor armExtend;
    public static DcMotor lift;

    public static void init(HardwareMap hwmap) {
        leftBackDrive  = hwmap.get(DcMotor.class, "LBD");
        leftFrontDrive   = hwmap.get(DcMotor.class, "LMD");
        rightBackDrive = hwmap.get(DcMotor.class, "RBD");
        rightFrontDrive  = hwmap.get(DcMotor.class, "RMD");

        intake    = hwmap.get(DcMotor.class, "intake");
        arm       = hwmap.get(DcMotor.class, "arm");
        armExtend = hwmap.get(DcMotor.class, "armExtend");
        lift      = hwmap.get(DcMotor.class, "lift");

        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);

        intake.setDirection(DcMotor.Direction.FORWARD);
        arm.setDirection(DcMotor.Direction.FORWARD);
        armExtend.setDirection(DcMotor.Direction.FORWARD);
        lift.setDirection(DcMotor.Direction.FORWARD);

        Hardware.intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

}
