package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="RevTest")
public class RevTest extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor lift; //lift

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing...");
        lift = hardwareMap.get(DcMotor.class, "tfil");
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Waiting for start");
    }

    @Override
    public void start() {
        telemetry.addData("Status", "Running");
    }

    @Override
    public void loop() {
        boolean liftUp = gamepad1.a;
        boolean liftDown = gamepad1.b;

        telemetry.addData("ABXY",liftUp +" "+ liftDown +" "+ gamepad1.x +" "+ gamepad1.y);
        telemetry.addData("LB RB", gamepad1.left_bumper +" "+ gamepad1.right_bumper);
        telemetry.addData("DPad UDLR", gamepad1.dpad_up+" "+gamepad1.dpad_down+" "+gamepad1.dpad_left+" "+gamepad1.dpad_right);
        telemetry.addData("LT RT", gamepad1.left_trigger +" "+ gamepad1.right_trigger);
        telemetry.addData("LStick XY", gamepad1.left_stick_x +" "+gamepad1.left_stick_y);
        telemetry.addData("RStick XY", gamepad1.right_stick_x +" "+ gamepad1.right_stick_y);

        if (liftDown) {
            lift.setPower(-0.5);
        } else if (liftUp) {
            lift.setPower(0.5);
        } else {
            lift.setPower(0);
        }

    }
}
