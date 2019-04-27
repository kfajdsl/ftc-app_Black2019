package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "TeleOp", group = "HopeBot")
public class BlackTeleOp extends OpMode{

    Hardware robot = new Hardware();

    @Override
    public void init() { // ran once as soon as you initilze the robot
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Hello Driver", "Press Play Button");
    }

    @Override
    public void init_loop() { // looping from time initialize till start

    }

    @Override
    public void start() { // ran once when start button clicked
        telemetry.addData("Status","Started");
    }

    @Override
    public void loop() { // running until stopped

        final double FORWARD_THRES = 0.3;
        final double REVERSE_THRES = -0.3;
        final double DRIVE_SENS = 0.7;
        final double INTAKE_SENS = 0.4; // only forward bec range is 0 to 1

        boolean liftArm = gamepad1.dpad_up;
        boolean downArm = gamepad1.dpad_down;
        boolean armOpen = gamepad1.dpad_right;
        boolean armClose = gamepad1.dpad_left;
        float intakeIn = gamepad1.right_trigger;//  range of 0 to 1
        float outakeOut = gamepad1.left_trigger;//float
        double rightPower = -gamepad1.right_stick_y * DRIVE_SENS; //Y-axis of the joysticks is negative when pushed up, and positive when pushed down
        double leftPower = -gamepad1.left_stick_y * DRIVE_SENS; // range of -1 to 1
        boolean fullArm = gamepad1.y;
        /*
        If want to send encoder value back to Driver Station phone
            int position = --Name of motor--.getCurrentPosition();
            telemetry.addData("Encoder Position", position);
        Or if you want to reset the encoder to 0
            --Name of motor--.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            --Name of motor--.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         */
        // drive
        if (rightPower < FORWARD_THRES && rightPower > REVERSE_THRES) { // Right trigger is between -0.3 and 0.3 // no move
            DriveMethods.driveRight(0);
        } else if (rightPower > FORWARD_THRES){
            DriveMethods.driveRight(rightPower);
        } else {
            DriveMethods.driveRight(-rightPower);
        }
        if (leftPower < FORWARD_THRES && leftPower > REVERSE_THRES) {  // Left trigger is between -0.3 and 0.3 // no move
            DriveMethods.driveLeft(0);
        } else if (leftPower > FORWARD_THRES){
            DriveMethods.driveLeft(leftPower);
        } else {
            DriveMethods.driveLeft(-leftPower);
        }

        // lift arm (not open)
        if (!liftArm && !downArm) {
            ArmMethods.liftArm(0);
        } else if (liftArm && !downArm) {
            ArmMethods.liftArm(0.25); // Change if speed of arm needs to go faster/slower
        } else if (!liftArm && downArm) {
            ArmMethods.liftArm(-0.25);
        } else {
            ArmMethods.liftArm(0); // Change if speed of arm needs to go faster/slower
        }
        //Arm
        if (!armOpen && !armClose) {
            ArmMethods.openArm(0);
        } else if (armOpen && !armClose) {
            ArmMethods.openArm(0.5);
        } else if (!armOpen && armClose) {
            ArmMethods.openArm(-0.5);
        } else {
            ArmMethods.openArm(0);
        }
        // Inake
        if(intakeIn < INTAKE_SENS && outakeOut < INTAKE_SENS) {
            IntakeMethods.inTake(0);
        } else if (intakeIn < INTAKE_SENS && outakeOut > INTAKE_SENS) {
            IntakeMethods.inTake(1);//change if need to go slower or faster
        } else if (intakeIn > INTAKE_SENS && outakeOut < INTAKE_SENS) {
            IntakeMethods.inTake(-1);
        } else {
            IntakeMethods.inTake(0);
        }
        /*
        if(!fullArm) {

        }
        */
    }

    @Override
    public void stop() { // run when stop button clicked
        DriveMethods.driveRight(0);
        DriveMethods.driveLeft(0);
        ArmMethods.liftArm(0);
        IntakeMethods.inTake(0);
        IntakeMethods.outTake(0);
    }

}