package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by shrey on 2018-09-12.
 * Modified by Sahan Reddy on 2018-10-16
 */
public class Hardware {
    /* Public OpMode members. */
    public static DcMotor leftDrive = null;
    public static DcMotor rightDrive = null;
    public static DcMotor arm = null;
    public static DcMotor lift = null;

    public static CRServo intakeRight = null;
    public static CRServo intakeLeft = null;

    public static ColorSensor colorSensor = null;
    //public static ColorSensor colorSense    = null;
    //public static Blinker blink = null;

    /* local OpMode members. */
    HardwareMap hwMap  =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware(){

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


        // no idea if I got my directions right, this will probably change.
        leftDrive.setDirection(DcMotor.Direction.FORWARD); //Torquenado motors spin clockwise
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        arm.setDirection(DcMotor.Direction.FORWARD);
        lift.setDirection(DcMotor.Direction.FORWARD);

        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        arm.setPower(0);
        lift.setPower(0);

        // Set drive motors to run with encoders.
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Set arm motors to reset encoder to zero at current position
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Define and Initialize Servo(s)
        intakeRight = hwMap.get(CRServo.class, "intake_right");
        intakeLeft  = hwMap.get(CRServo.class, "intake_left");

        intakeRight.setDirection(CRServo.Direction.REVERSE);
        intakeLeft.setDirection(CRServo.Direction.FORWARD);
        intakeRight.setPower(0);
        intakeLeft.setPower(0);

        colorSensor = hwMap.get(ColorSensor.class, "color_sensor");

    }
 }

