package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
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
    public static DcMotor extend;
    public static DcMotor lift;

    public static BNO055IMU imu;

    public static void init(HardwareMap hwmap) {
        leftBackDrive  = hwmap.get(DcMotor.class, "LBD");
        leftFrontDrive   = hwmap.get(DcMotor.class, "LFD");
        rightBackDrive = hwmap.get(DcMotor.class, "RBD");
        rightFrontDrive  = hwmap.get(DcMotor.class, "RFD");

        intake    = hwmap.get(DcMotor.class, "intake");
        arm       = hwmap.get(DcMotor.class, "arm");
        extend = hwmap.get(DcMotor.class, "extend");
        lift      = hwmap.get(DcMotor.class, "lift");

        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);

        intake.setDirection(DcMotor.Direction.FORWARD);
        arm.setDirection(DcMotor.Direction.FORWARD);
        extend.setDirection(DcMotor.Direction.FORWARD);
        lift.setDirection(DcMotor.Direction.REVERSE);

        Hardware.intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled = false;

        imu = hwmap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

    }

}
