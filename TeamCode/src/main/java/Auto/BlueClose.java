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
@Autonomous(name = "BlueClose")
public class BlueClose extends LinearOpMode {
    private MecanumDrive drive;
    private Pose2d initialPose;
    private Action trajectory;
    private All all;

    private void initialize() {
        initialPose = new Pose2d(-49, -49, Math.toRadians(235));
        drive = new MecanumDrive(hardwareMap, initialPose);
        all = new All(hardwareMap, telemetry);
    }

    private void buildTrajectories() {
        TrajectoryActionBuilder trajectoryHolder = drive.actionBuilder(initialPose)
                .strafeToLinearHeading(new Vector2d(-35+1, -20+1), Math.toRadians(235))
                .waitSeconds(0)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, true, true))
                .waitSeconds(2.4)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, false, true))
                .strafeToLinearHeading(new Vector2d(-15, -19), Math.toRadians(90))
                .afterTime(0.81, all.runAllAutoAction(hardwareMap, telemetry, false, false))
                .strafeToLinearHeading(new Vector2d(-15, -50), Math.toRadians(90))

                .strafeToLinearHeading(new Vector2d(-35+2, -20+7), Math.toRadians(240))
                .waitSeconds(0)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, true, true))
                .waitSeconds(2.4)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, false, true))
                .strafeToLinearHeading(new Vector2d(7, -27+10), Math.toRadians(90))
                .afterTime(0.76, all.runAllAutoAction(hardwareMap, telemetry, false, false))
                .strafeToLinearHeading(new Vector2d(7, -55+8), Math.toRadians(90))
                .strafeToLinearHeading(new Vector2d(7, -27+10), Math.toRadians(90))

                .strafeToLinearHeading(new Vector2d(-35+2, -20+10), Math.toRadians(240))
                .waitSeconds(0)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, true, true))
                .waitSeconds(2.4)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, false, true))
                .strafeToLinearHeading(new Vector2d(28, -27+20), Math.toRadians(90))
                .afterTime(1.02, all.runAllAutoAction(hardwareMap, telemetry, false, false))
                .strafeToLinearHeading(new Vector2d(29, -55+10), Math.toRadians(90))

                .strafeToLinearHeading(new Vector2d(-33+2, -20+12), Math.toRadians(240))
                .waitSeconds(0)
                .afterTime(0, all.runAllAutoAction(hardwareMap, telemetry, true, true))
                .waitSeconds(2.4);


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
