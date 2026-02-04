package mechanisms;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.lang.annotation.ElementType;

public class All {
    private Intake intake;
    private Shooter shooter;
    private Transfer transfer;
    private ElapsedTime timer;

    public All(HardwareMap hardwareMap, Telemetry telemetry) {
        intake = new Intake(hardwareMap, telemetry);
        shooter = new Shooter(hardwareMap, telemetry);
        transfer = new Transfer(hardwareMap, telemetry);
        timer = new ElapsedTime();
    }
    protected void autoShoot() {
        timer.reset();
        while (timer.seconds() < 0.11) {
            transfer.outtake();
        }
        transfer.rest();
        shooter.outtakeAuto();
        timer.reset();
        while (timer.seconds() < 0.5){}
        while (timer.seconds() < 0.63) {
            transfer.intake();
            intake.intake();
        }
        while (timer.seconds() < 1) transfer.rest();
        timer.reset();
        timer.reset();
        while (timer.seconds() < 0.11) {
            transfer.outtake();
        }
        transfer.rest();
        while (timer.seconds() < 0.45) {
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
        while (timer.seconds() < 0.5) {
            transfer.intake();
            intake.intake();
        }
        transfer.rest();
        shooter.rest();
        intake.rest();
    }

    protected void intake() {
        intake.intake();
        transfer.intake();
        shooter.intake();
    }
    protected void stop() {
        intake.rest();
        transfer.rest();
        shooter.rest();
    }

    public class AllAutoAction implements Action {
        All all;
        boolean shooting;
        boolean on;
        public AllAutoAction(HardwareMap hardwareMap, Telemetry telemetry, boolean shooting, boolean on) {
            all = new All(hardwareMap, telemetry);
            this.shooting = shooting;
            this.on = on;
        }
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (shooting) {
                all.autoShoot();
            }
            if (on) {
                intake();
            }
            else {
                stop();
            }
            return false;
        }
    }
    public Action runAllAutoAction(HardwareMap hardwareMap, Telemetry telemetry, boolean shooting, boolean on) {
        return new AllAutoAction(hardwareMap, telemetry, shooting, on);
    }
}
