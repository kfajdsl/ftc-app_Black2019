package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by shrey on 2018-09-12.
 * Modified by Sahan Reddy on 2018-10-16
 */
public class HardwareBot {
    /* Public OpMode members. */
    public static DcMotor leftDrive  = null;
    public static DcMotor rightDrive = null;
    public static DcMotor arm        = null;
    public static DcMotor lift       = null;

    public static Servo   intake     = null;

    //public static ColorSensor colorSense    = null;
    //public static Blinker blink = null;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareBot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(com.qualcomm.robotcore.hardware.HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftDrive  = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        arm        = hwMap.get(DcMotor.class, "arm");
        lift       = hwMap.get(DcMotor.class, "lift");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        arm.setDirection(DcMotor.Direction.FORWARD);
        lift.setDirection(DcMotor.Direction.FORWARD);

        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        arm.setPower(0);
        lift.setPower(0);

        // Set all motors to run with encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Define and Initialize Servo(s)
        intake = hwMap.get(Servo.class, "intake");
        intake.setDirection(Servo.Direction.FORWARD);
        intake.setPosition(Servo.MIN_POSITION);
    }
 }

