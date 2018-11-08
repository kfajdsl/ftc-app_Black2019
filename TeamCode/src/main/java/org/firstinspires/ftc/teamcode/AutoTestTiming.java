package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.disnodeteam.dogecv.detectors.roverrukus.SamplingOrderDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Autonomous Test")

public class AutoTestTiming extends LinearOpMode
{
    private SamplingOrderDetectorBasic detector;

    @Override
    public void runOpMode() throws InterruptedException {

        Hardware robot = new Hardware(hardwareMap);
        robot.init();

        detector = new SamplingOrderDetectorBasic();
        detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());
        detector.useDefaults();

        detector.downscale = 0.4; // How much to downscale the input frames

        // Optional Tuning
        detector.areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Can also be PERFECT_AREA
        //detector.perfectAreaScorer.perfectArea = 10000; // if using PERFECT_AREA scoring
        detector.maxAreaScorer.weight = 0.001;

        detector.ratioScorer.weight = 15;
        detector.ratioScorer.perfectRatio = 1.0;

        detector.enable();

        while(!isStarted()) {
            telemetry.addData("Current Order" , detector.getPosition().name());
        }

        detector.disable();

        telemetry.addData("Final Order Choice" , detector.getLastPosition().name());

        switch(detector.getLastPosition()) {
            case LEFT:
                DriveMethods.driveLeft(-1);
                DriveMethods.driveRight(1);
                Thread.sleep(500);
                DriveMethods.driveLeft(0);
                DriveMethods.driveRight(0);
                break;
            case RIGHT:
                DriveMethods.driveLeft(1);
                DriveMethods.driveRight(-1);
                Thread.sleep(500);
                DriveMethods.driveLeft(0);
                DriveMethods.driveRight(0);
                break;
            case MIDDLE:
                DriveMethods.driveLeft(1);
                DriveMethods.driveRight(1);
                Thread.sleep(500);
                DriveMethods.driveLeft(0);
                DriveMethods.driveRight(0);
                break;
        }

    }
}