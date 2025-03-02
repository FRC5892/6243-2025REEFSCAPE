// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kCoDriverControllerPort = 2;
  }

  public static class IdConstants{
    public static final int LEFT_FRONT_MOTOR_ID = 19;
    public static final int RIGHT_FRONT_MOTOR_ID = 18;
    public static final int LEFT_BACK_MOTOR_ID = 16;
    public static final int RIGHT_BACK_MOTOR_ID = 15;
    public static final int CORAL_MOTOR_ID = 17;
    //public static final int ALGAE_MOTOR_MOVE_ID = 14;
    //public static final int ALGAE_MOTOR_SHOOT_ID = 13;
    public static final int CLIMB_ARM_MOTOR_ID = 12;
    }

  public static class SpeedConstants{
    public static final double CORAL_FORWARD_SPEED = 0.3;
    public static final double ALGAE_MOTOR_MOVE_SPEED = 0.3;
    public static final double ALGAE_MOTOR_MOVE_BACK_SPEED = -0.3;
    public static final double ALGAE_MOTOR_OUTTAKE_SPEED = 0.3;
    public static final double ALGAE_MOTOR_INTAKE_SPEED = -0.3;
    public static final double CLIMB_ARM_MOTOR_SPEED = 0.3;
    public static final double CLIMB_BACK_MOTOR_SPEED = -0.3;
  }
}
