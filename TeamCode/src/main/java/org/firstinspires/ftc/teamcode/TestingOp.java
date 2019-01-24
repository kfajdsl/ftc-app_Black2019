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
        Hardware.init(hardwareMap);
        telemetry.update();

        telemetry.addData("Status", "Waiting for start");
    }

    @Override
    public void start() {
        telemetry.addData("Status", "Running");
    }

    @Override
    public void loop() {

        telemetry.addData("ABXY",gamepad1.a +" "+ gamepad1.b +" "+ gamepad1.x +" "+ gamepad1.y);
        telemetry.addData("LB RB", gamepad1.left_bumper +" "+ gamepad1.right_bumper);
        telemetry.addData("DPad UDLR", gamepad1.dpad_up+" "+gamepad1.dpad_down+" "+gamepad1.dpad_left+" "+gamepad1.dpad_right);
        telemetry.addData("LT RT", gamepad1.left_trigger +" "+ gamepad1.right_trigger);
        telemetry.addData("LStick XY", gamepad1.left_stick_x +" "+gamepad1.left_stick_y);
        telemetry.addData("RStick XY", gamepad1.right_stick_x +" "+ gamepad1.right_stick_y);

        final double THRESHOLD = 0.3;

        double LStickX = 0;
        double LStickY = 0;
        double RStickX = 0;

        if (gamepad1.left_stick_x > THRESHOLD || gamepad1.left_stick_x < -THRESHOLD) {
            LStickX = gamepad1.left_stick_x;
        }
        if (gamepad1.left_stick_y > THRESHOLD || gamepad1.left_stick_y < -THRESHOLD) {
            LStickY = gamepad1.left_stick_y;
        }
        if (gamepad1.right_stick_y > THRESHOLD || gamepad1.right_stick_y < -THRESHOLD) {
            RStickX = gamepad1.right_stick_y;
        }

        double speed = Math.hypot(LStickX, LStickY);
        double direction = Math.atan2(LStickY, LStickX) - Math.PI / 4;

        Mecanum.mecanumDrive(speed, direction, RStickX);


        boolean armUp = gamepad1.dpad_up;
        boolean armDown = gamepad1.dpad_down;

        if (armDown) {
            Arm.armSpeed(-1);
        } else if (armUp) {
            Arm.armSpeed(1);
        } else {
            Arm.armSpeed(0);
        }

        boolean armExtend = gamepad1.right_trigger > 0.4;
        boolean armRetract = gamepad1.left_trigger > 0.4;
        
        if (armRetract) {
            Arm.extendSpeed(-0.5);
        } else if (armExtend) {
            Arm.extendSpeed(0.5);
        } else {
            Arm.extendSpeed(0);
        }

        boolean intakeIn = gamepad1.right_bumper;
        boolean intakeOut = gamepad1.left_bumper;
        String intakeStat;

        if (intakeIn) {
            Arm.intake(1);
            intakeStat = "in";
        } else if (intakeOut) {
            Arm.intake(-1);
            intakeStat = "out";
        } else {
            Arm.intake(0);
            intakeStat = "none";
        }

        telemetry.addData("Intake", intakeStat);



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
