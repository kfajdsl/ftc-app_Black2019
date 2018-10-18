package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "Tel", group = "Sensor")
public class TeleOpDrive extends LinearOpMode{

    Hardware robot = new Hardware();


    @Override
    public void runOpMode() throws InterruptedException {

        // Intialize the robot's hardware from HardwareMap amd allows you to run all this code within TeleOp
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.addData("Hello Driver", "Press Play Button");
        telemetry.update();



        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Drive constants
        final double FORWARD_THRES = 0.3;
        final double REVERSE_THRES = -0.3;
        final double DRIVE_SENS = 0.7;
        final double TURN_SENS = 0.5;

        //threshold (for trigger activation)
        final double TRIGGER_THRES = 0.3;

        double rightPower, leftPower;               //drive sticks
        boolean liftUp, liftDown ;                  //lift control buttons
        boolean armUp, armDown;                     //arm control buttons
        boolean autoLiftRaiseArm, autoLiftLowerArm; //auto raise and lower lift and arm button
        boolean intakeInBut, intakeOutBut;          //intake buttons

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Drive variables
            rightPower = gamepad1.right_stick_y * 0.8;
            leftPower = gamepad1.left_stick_y * 0.8;


            // Send calculated power to wheels
            // Drive system


            if (rightPower < FORWARD_THRES && rightPower > REVERSE_THRES && leftPower < FORWARD_THRES && leftPower > REVERSE_THRES) {
                DriveMethods.stopRightMotors();
                DriveMethods.stopLeftMotors();
            } else if (rightPower != 0.0 && leftPower != 0.0) {
                DriveMethods.driveRight(rightPower * DRIVE_SENS);
                DriveMethods.driveLeft(leftPower * DRIVE_SENS);
            } else if (rightPower != 0.0 && leftPower == 0.0) {
                DriveMethods.driveRight(rightPower * DRIVE_SENS);
            } else if (leftPower != 0.0 && rightPower == 0.0) {
                DriveMethods.driveLeft(leftPower * DRIVE_SENS);
            } else if (rightPower < REVERSE_THRES && leftPower > FORWARD_THRES) {
                DriveMethods.driveLeft(leftPower * TURN_SENS);
                DriveMethods.driveRight(rightPower * TURN_SENS);
            } else if (rightPower > FORWARD_THRES && leftPower < REVERSE_THRES) {
                DriveMethods.driveLeft(leftPower * TURN_SENS);
                DriveMethods.driveRight(rightPower * TURN_SENS);
            }

            // Lift System
            liftUp = gamepad1.dpad_right;
            liftDown = gamepad1.dpad_left;
            //raiseLiftBut = gamepad1.a;
            //lowerLiftBut = gamepad1.b;

            //  Manual control
            if ((liftUp && liftDown) || (!liftUp && !liftDown)) {
                LiftMethods.liftPower(0);
            } else if (liftUp) {
                LiftMethods.liftPower(0.25);
            } else if (liftDown) {
                LiftMethods.liftPower(-0.25);
            }

            /*
            //  Automatically raise and lower lift
            if (!liftUp && !liftDown && (raiseLiftBut ^ lowerLiftBut)) { //make sure armUp and armDown are not being pressed
                if (raiseLiftBut) {                                   // and make sure one of the ArmButs are being pressed
                    LiftMethods.raiseLift();
                }
                if (lowerLiftBut) {
                    LiftMethods.lowerLift();
                }
            }
            */

            // Arm System
            armUp = gamepad1.dpad_up;
            armDown = gamepad1.dpad_down;
            //raiseArmBut = gamepad1.x; //maybe instead just have one button that automatically raises and lowers arm.
            //lowerArmBut = gamepad1.y;

            //  Manual control
            if ((armUp && armDown) || (!armUp && armDown)) {
                ArmMethods.armPower(0);
            } else if (armUp) {
                ArmMethods.armPower(0.25);
            } else if (armDown) {
                ArmMethods.armPower(-0.25);
            }

            /*
            //  Automatically raise arm and lower arm
            if (!armUp && !armDown && !lowerArmBut && raiseArmBut) { //make sure armUp and armDown are not being pressed
                ArmMethods.raiseArm();

            }
            if (!armUp && !armDown && !raiseArmBut && lowerArmBut) { //make sure armUp and armDown are not being pressed
                ArmMethods.lowerArm();
            }
            */

            // Auto lift & arm
            autoLiftRaiseArm = gamepad1.left_bumper;
            autoLiftLowerArm = gamepad1.left_trigger > TRIGGER_THRES;
            if (!liftUp && !liftDown && !armUp && !armDown && !autoLiftLowerArm &&
                autoLiftRaiseArm) { //make sure no other arm or lift buttons are being pressed
                LiftMethods.raiseLift();
                ArmMethods.raiseArm();
            }

            if (!liftUp && !liftDown && !armUp && !armDown && !autoLiftRaiseArm &&
                autoLiftLowerArm) { //make sure no other arm or lift buttons are being pressed
                ArmMethods.lowerArm();
                LiftMethods.lowerLift();
            }

            // Intake
            intakeInBut = gamepad1.right_trigger > TRIGGER_THRES;
            intakeOutBut = gamepad1.right_bumper;

            if (!intakeInBut && !intakeOutBut) {
                IntakeMethods.intakeStop();
            }
            else if (intakeInBut && !intakeOutBut) {
                IntakeMethods.intakeIn();
            }
            else if (intakeOutBut && !intakeInBut) {
                IntakeMethods.intakeOut();
            }
        }
    }
}
