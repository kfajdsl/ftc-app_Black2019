package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TestingOp")
public class TestingOp extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing...");
        telemetry.update();
        Hardware.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        double strafeX = gamepad1.left_stick_x;
        double strafeY = gamepad1.left_stick_y;
        double rotation = gamepad1.right_stick_y;

        Mecanum.mecanumDrive_Cartesian(strafeX, strafeY, rotation);

        boolean armUp = gamepad1.dpad_up;
        boolean armDown = gamepad1.dpad_down;

        if (armDown) {
            Arm.armSpeed(-0.25);
        } else if (armUp) {
            Arm.armSpeed(0.25);
        } else {
            Arm.armSpeed(0);
        }

        boolean armExtend = gamepad1.right_trigger > 0.2;
        boolean armRetract = gamepad1.left_trigger > 0.2;
        
        if (armRetract) {
            Arm.extendSpeed(-0.5);
        } else if (armExtend) {
            Arm.extendSpeed(0.5);
        } else {
            Arm.extendSpeed(0);
        }

        boolean intakeIn = gamepad1.right_bumper;
        boolean intakeOut = gamepad1.left_bumper;

        if (intakeIn) {
            Arm.intake(1);
        } else if (intakeOut) {
            Arm.intake(-1);
        } else {
            Arm.intake(0);
        }

        boolean liftUp = gamepad1.dpad_right;
        boolean liftDown = gamepad1.dpad_left;

        if (liftDown) {
            Arm.lift(-0.5);
        } else if (liftUp) {
            Arm.lift(0.5);
        } else {
            Arm.lift(0);
        }

    }
}
