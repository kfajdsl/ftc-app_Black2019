/**
* Created by Sahan Reddy on 2018-11-4
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class TestingOp extends OpMode {

    @Override
    public void init() {
        Hardware robot = new Hardware(hardwareMap);
        robot.init();
    }

    @Override
    public void loop() {
        final double STICK_THRESH = 0.3;
        final double TIGGER_THRESH = 0.1;

        double leftDrive = gamepad1.left_stick_y;
        double rightDrive = gamepad1.right_stick_y;

        if (leftDrive > STICK_THRESH || leftDrive < -STICK_THRESH) {
            DriveMethods.driveLeft(leftDrive);
        }
        if (rightDrive > STICK_THRESH || rightDrive < -STICK_THRESH) {
            DriveMethods.driveRight(rightDrive);
        }

        boolean armUp = gamepad1.dpad_up;
        boolean armDown = gamepad1.dpad_down;
        boolean liftUp = gamepad1.dpad_right;
        boolean liftDown = gamepad1.dpad_left;

        if (armUp && !armDown) {
            Hardware.arm.setPower(0.2);
        }
        if (armDown && !armUp) {
            Hardware.arm.setPower(-0.2);
        }
        if (!armDown && !armUp) {
            Hardware.arm.setPower(0);
        }

        if (liftUp && !liftDown) {
            Hardware.lift.setPower(0.2);
        }
        if (liftDown && !liftUp) {
            Hardware.lift.setPower(-0.2);
        }
        if (!liftDown && !liftUp) {
            Hardware.lift.setPower(0);
        }

        boolean intake = gamepad1.right_bumper;
        boolean intakeRev = gamepad1.left_bumper;

        if (intake && !intakeRev) {
            Hardware.intake.setPower(1);
        }
        if (intakeRev && !intake) {
            Hardware.intake.setPower(-1);
        }
        if (!intake && !intakeRev) {
            Hardware.intake.setPower(0);
        }

        boolean toggleLift =

    }
}
