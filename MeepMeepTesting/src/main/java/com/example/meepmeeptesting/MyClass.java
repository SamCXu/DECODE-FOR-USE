package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MyClass {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-49, 49, Math.toRadians(125)))

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
                .waitSeconds(3)
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}