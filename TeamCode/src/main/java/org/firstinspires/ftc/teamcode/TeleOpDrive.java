package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "Tel", group = "Sensor")
public class TeleOpDrive extends LinearOpMode{

    HardwareBot robot = new HardwareBot();


    @Override
    public void runOpMode() throws InterruptedException {

        // Intialize the robot's hardware from HardwareMap amd allows you to run all this code within TeleOp
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.addData("Hello Driver", "Press Play Button");
        telemetry.update();



        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Drive constants
            final double FORWARD_THRES = 0.3;
            final double REVERSE_THRES = -0.3;
            final double DRIVE_SENS = 0.7;
            final double TURN_SENS = 0.5;

            // Drive variables
            double rightPower = gamepad1.right_stick_y * 0.8;
            double leftPower = gamepad1.left_stick_y * 0.8;


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


        }



    }
}
