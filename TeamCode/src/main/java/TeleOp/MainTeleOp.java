package TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import mechanisms.Drivetrain;
import mechanisms.Intake;
import mechanisms.Shooter;
import mechanisms.Transfer;


@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode {



    //DO NOT MODIFY THIS CLASS WHATSOEVER UNLESS AUTHORIZED-> MAKE A COPY
    private Drivetrain drivetrain;
    private Intake intake;
    private Transfer transfer;
    private Shooter shooter;
    private ElapsedTime timer;





    private void initialize() {
        drivetrain = new Drivetrain(hardwareMap, telemetry, gamepad1);
        intake = new Intake(hardwareMap, telemetry);
        transfer = new Transfer(hardwareMap, telemetry);
        shooter = new Shooter(hardwareMap, telemetry);
        timer = new ElapsedTime();
    }




    @Override
    public void runOpMode() {

        initialize();
        while (opModeInInit()) {
        }
        while (opModeIsActive()) {
            drivetrain.drive();
            if (gamepad1.b) {
                intake.intake();
                transfer.intake();
                shooter.intake();
            }
            else if (gamepad1.a) {
                //intake.outtake();
                transfer.outtake();
            }
            else if (gamepad1.y) {
                transfer.outtake();
            }
            else if (gamepad1.x) {
                transfer.intake();

            }
            else if (gamepad1.dpad_down) {
                timer.reset();
                while (timer.seconds() < 0.11) {
                    transfer.outtake();
                }
                transfer.rest();
                shooter.outtake();
                timer.reset();
                while (timer.seconds() < 0.5){}
                while (timer.seconds() < 0.63) {
                    transfer.intake();
                    intake.intake();
                }
                while (timer.seconds() < 1) transfer.rest();
                timer.reset();
                timer.reset();
                while (timer.seconds() < 0.067) {
                    transfer.outtake();
                }
                transfer.rest();
                while (timer.seconds() < 0.5) {
                    transfer.intake();
                    intake.intake();
                }
                while (timer.seconds() < 0.76) transfer.rest();
                timer.reset();
                timer.reset();
                while (timer.seconds() < 0.05) {
                    transfer.outtake();
                }
                transfer.rest();
                shooter.outtake2();
                while (timer.seconds() < 2.46) {
                    transfer.intake();
                    intake.intake();
                }
                transfer.rest();
                shooter.rest();
            }
            else if (gamepad1.dpad_up) {
                timer.reset();
                while (timer.seconds() < 1) {
                    shooter.outtake();
                }
                while(timer.seconds() < 1.15) {
                    transfer.intake();
                }
                transfer.rest();
                shooter.rest();
            }
            else if (gamepad1.dpad_left) {
                timer.reset();
                while (timer.seconds() < 0.5) {
                }
                timer.reset();
                while (timer.seconds() < 0.11) {
                    transfer.outtake();
                }
                transfer.rest();
                shooter.outtakeStronk();
                timer.reset();
                while (timer.seconds() < 0.5){}
                while (timer.seconds() < 0.63) {
                    transfer.intake();
                    intake.intake();
                }
                while (timer.seconds() < 1) transfer.rest();
                timer.reset();
                timer.reset();
                while (timer.seconds() < 0.067) {
                    transfer.outtake();
                }
                transfer.rest();
                while (timer.seconds() < 0.5) {
                    transfer.intake();
                    intake.intake();
                }
                while (timer.seconds() < 0.76) transfer.rest();
                timer.reset();
                timer.reset();
                while (timer.seconds() < 0.05) {
                    transfer.outtake();
                }
                transfer.rest();
                while (timer.seconds() < 2.46) {
                    transfer.intake();
                    intake.intake();
                }
                transfer.rest();
                shooter.rest();
            }
            else {
                intake.rest();
                transfer.rest();
                shooter.rest();
            }
        }

    }

}