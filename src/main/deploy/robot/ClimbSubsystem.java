// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {
   private final SparkMax climbArmMotor = new SparkMax(Constants.IdConstants.CLIMB_ARM_MOTOR_ID,MotorType.kBrushless);
  /** Creates a new ClimbSubsystem. */
  public ClimbSubsystem() {
    SparkBaseConfig config = new SparkMaxConfig();
     climbArmMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public Command climbCommand(){
    return runEnd(()->{
      climbArmMotor.set(Constants.SpeedConstants.CLIMB_ARM_MOTOR_SPEED);
    },() -> {
      climbArmMotor.stopMotor();
    });
  } 

  public Command climbBackCommand(){
    return runEnd(()->{
      climbArmMotor.set(Constants.SpeedConstants.CLIMB_BACK_MOTOR_SPEED);
    },() -> {
      climbArmMotor.stopMotor();
    });
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
