package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware {
    /* Public OpMode members. */
    //Drive
    public static DcMotor  leftMidDrive              = null;
    public static DcMotor  rightMidDrive             = null;
    public static DcMotor  leftBackDrive                = null;
    public static DcMotor  rightBackDrive               = null;
    //Arm
    public static DcMotor  lift                = null;
    public static DcMotor  arm                = null;
    //intake
    public static DcMotor  intake                       = null;
    /* local OpMode members. */
    com.qualcomm.robotcore.hardware.HardwareMap hwMap   =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(com.qualcomm.robotcore.hardware.HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;


        //for armMiddle lift and arm middle open, the using encoder and the direction is not final -- recheck needed


        // Define and Initialize Motors
        leftMidDrive  = hwMap.get(DcMotor.class, "left Middle Drive"); // short form
        rightMidDrive = hwMap.get(DcMotor.class, "right Middle Drive");
        leftBackDrive   = hwMap.get(DcMotor.class, "left Back Drive");
        rightBackDrive  = hwMap.get(DcMotor.class, "right Back Drive");
        lift = hwMap.get(DcMotor.class,"arm Middle Lift");
        arm = hwMap.get(DcMotor.class, "arm Middle Open");
        intake        = hwMap.get(DcMotor.class,"in Take");
        //need to change
        leftMidDrive.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        rightMidDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        lift.setDirection(DcMotor.Direction.FORWARD);
        arm.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        leftMidDrive.setPower(0);
        rightMidDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightBackDrive.setPower(0);
        lift.setPower(0);
        arm.setPower(0);
        intake.setPower(0);
        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftMidDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMidDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        // Color Sensor initialization
        //colorSense = hwMap.get(ColorSensor.class, "color_sense");
        //blink = hwMap.get(Blinker.class, "ledController");
    }
}