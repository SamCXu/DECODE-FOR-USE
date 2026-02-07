package Auto;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

import mechanisms.All;

@Config
@Autonomous(name = "RedClose")
public class RedClose extends LinearOpMode {
    private MecanumDrive drive;
    private Pose2d initialPose;
    private Action trajectory;
    private All all;

    private void initialize() {
        initialPose = new Pose2d(-49, 49, Math.toRadians(145));
        drive = new MecanumDrive(hardwareMap, initialPose);
        all = new All(hardwareMap, telemetry);
    }

    private void buildTrajectories() {
        TrajectoryActionBuilder trajectoryHolder = drive.actionBuilder(initialPose)
                .strafeToLinearHeading(new Vector2d(-35+11, 20+1), Math.toRadians(143))
                .waitSeconds(0)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, true, true))
                .waitSeconds(2.32)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, false, true))
                .strafeToLinearHeading(new Vector2d(-8, 19), Math.toRadians(285))
                .afterTime(1.39, all.runAllAutoAction(hardwareMap, telemetry, false, false))
                .strafeToLinearHeading(new Vector2d(-15, 50+11), Math.toRadians(285))

                .strafeToLinearHeading(new Vector2d(-35+12, 20+7), Math.toRadians(145))
                .waitSeconds(0)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, true, true))
                .waitSeconds(2.32)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, false, true))
                .strafeToLinearHeading(new Vector2d(12, 27), Math.toRadians(285))
                .afterTime(1.351, all.runAllAutoAction(hardwareMap, telemetry, false, false))
                .strafeToLinearHeading(new Vector2d(6, 55+20), Math.toRadians(285))
                .strafeToLinearHeading(new Vector2d(5, 27), Math.toRadians(285))

                .strafeToLinearHeading(new Vector2d(-35+12, 20), Math.toRadians(145))
                .waitSeconds(0)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, true, true))
                .waitSeconds(2.32)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, false, true))
                .strafeToLinearHeading(new Vector2d(35, 27), Math.toRadians(285))
                .afterTime(1.42, all.runAllAutoAction(hardwareMap, telemetry, false, false))
                .strafeToLinearHeading(new  Vector2d(25, 55+20), Math.toRadians(285))

                .strafeToLinearHeading(new Vector2d(-33+12, 20), Math.toRadians(145))
                .waitSeconds(0)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, true, true))
                .waitSeconds(2.33);


        trajectory = trajectoryHolder.build();
    }

    @Override
    public void runOpMode() {
        initialize();
        buildTrajectories();

        waitForStart();

        Actions.runBlocking(
                new ParallelAction(
                        trajectory
                )
        );
    }

}
