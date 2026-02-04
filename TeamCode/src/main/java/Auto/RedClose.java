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

@Config
@Autonomous(name = "RedClose")
public class RedClose extends LinearOpMode {
    private MecanumDrive drive;
    private Pose2d initialPose;
    private Action trajectory;

    private void initialize() {
        initialPose = new Pose2d(-49, 49, Math.toRadians(125));
        drive = new MecanumDrive(hardwareMap, initialPose);

    }

    private void buildTrajectories() {
        TrajectoryActionBuilder trajectoryHolder = drive.actionBuilder(initialPose)
                .strafeToLinearHeading(new Vector2d(-35, 20), Math.toRadians(125))
                .waitSeconds(3)
                .strafeToLinearHeading(new Vector2d(-12, 27), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(-12, 50), Math.toRadians(270))
                .waitSeconds(0.5)

                .strafeToLinearHeading(new Vector2d(-35, 20), Math.toRadians(125))
                .waitSeconds(3)
                .strafeToLinearHeading(new Vector2d(12, 27), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(12, 55), Math.toRadians(270))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(12, 27), Math.toRadians(270))

                .strafeToLinearHeading(new Vector2d(-35, 20), Math.toRadians(125))
                .waitSeconds(3)
                .strafeToLinearHeading(new Vector2d(35, 27), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(35, 55), Math.toRadians(270))
                .waitSeconds(0.5)

                .strafeToLinearHeading(new Vector2d(-35, 20), Math.toRadians(125))
                .waitSeconds(3);


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
