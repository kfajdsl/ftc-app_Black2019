package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import java.util.Locale;

@Autonomous(name="TestAuto")
public class TestAuto extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    Orientation angles;
    Acceleration gravity;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initializing");
        Hardware.init(hardwareMap);
        telemetry.update();

        while (!isStopRequested() && !Hardware.imu.isGyroCalibrated()) {
            sleep(50);
            idle();
        }

        telemetry.addData("Status", "Waiting for start");
        telemetry.addData("IMU Calib Status", Hardware.imu.getCalibrationStatus().toString());
        telemetry.update();

        waitForStart();

        telemetry.addData("Status", "Running");

    }

}
