package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
@Autonomous(name = "Auto")
@Disabled
public class RedDuckAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
                .strafeRight(10)
                .forward(5)
                .build();

        TrajectorySequence myTrajectory1 = drive.trajectorySequenceBuilder(new Pose2d(-36, -66.75, Math.toRadians(180)))
                .lineTo(new Vector2d(-61.5, -66.75))
                .addTemporalMarker(1.4, () ->{
                    //run carousel for duck
                    //sleep(1000);
                })
//                                //TODO: add stop
//                                .addTemporalMarker(2, () ->{
//                                    //run carousel for duck off
//                                })
                .lineToSplineHeading(new Pose2d(-24, -36, Math.toRadians(45)))
                //TODO: add stop
                .addTemporalMarker(3.44/*plus whatever the time for stop is*/, () ->{
                    //lift pre loaded block into goal
                })

                .lineToSplineHeading(new Pose2d(12, -66.75, Math.toRadians(0)))
                .lineTo(new Vector2d(43.5, -66.75))
                .addTemporalMarker(6.78/*plus whatever the time for stop is*/, () ->{
                    //intake block
                })
                .lineTo(new Vector2d(12, -66.75))
//                                .lineToSplineHeading(new Pose2d(0, -36, Math.toRadians(135)))
                .addTemporalMarker(8.23/*plus whatever the time for stop is*/, () ->{
                    //lift block into high goal
                })
////                                .lineToSplineHeading(new Pose2d(12, -66.75, Math.toRadians(0)))
                .lineTo(new Vector2d(43.5, -66.75))
                .addTemporalMarker(9.68/*plus whatever the time for stop is*/, () ->{
                    //intake block
                })
                .lineTo(new Vector2d(12, -66.75))
////                                .lineToSplineHeading(new Pose2d(0, -36, Math.toRadians(135)))
                .addTemporalMarker(11.13/*plus whatever the time for stop is*/, () ->{
                    //lift block into high goal
                })
////                                .lineToSplineHeading(new Pose2d(12, -66.75, Math.toRadians(0)))

                .lineTo(new Vector2d(40, -66.75))
                .lineTo(new Vector2d(40, -38))
                .build();


        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(myTrajectory);
    }
}
