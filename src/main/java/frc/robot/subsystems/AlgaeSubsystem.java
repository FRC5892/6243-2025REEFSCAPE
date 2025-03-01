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

public class AlgaeSubsystem extends SubsystemBase {
  private final SparkMax algaeMotorMove = new SparkMax(Constants.IdConstants.ALGAE_MOTOR_MOVE_ID,MotorType.kBrushed);
    private final SparkMax  algaeMotorShoot = new SparkMax(Constants.IdConstants.ALGAE_MOTOR_SHOOT_ID,MotorType.kBrushed);
  /** Creates a new AlgaeSubsystem. */
  public AlgaeSubsystem() {
     SparkBaseConfig config1 = new SparkMaxConfig();
     SparkBaseConfig config2 = new SparkMaxConfig();
        algaeMotorMove.configure(config1, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        algaeMotorShoot.configure(config2, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public Command algaeArmForwardCommand(){
    return runEnd(()->{
      algaeMotorMove.set(Constants.SpeedConstants.ALGAE_MOTOR_MOVE_SPEED);
    },() -> {
      algaeMotorMove.stopMotor();
    });
  } 

  public Command algaeArmBackwardCommand(){
    return runEnd(()->{
      algaeMotorMove.set(Constants.SpeedConstants.ALGAE_MOTOR_MOVE_BACK_SPEED);
    },() -> {
      algaeMotorMove.stopMotor();
    });
  } 
  public Command algaeIntakeCommand(){
    return runEnd(()->{
      algaeMotorShoot.set(Constants.SpeedConstants.ALGAE_MOTOR_INTAKE_SPEED);
    },() -> {
      algaeMotorShoot.stopMotor();
    });
  } 

  public Command algaeOuttakeCommand(){
    return runEnd(()->{
      algaeMotorShoot.set(Constants.SpeedConstants.ALGAE_MOTOR_OUTTAKE_SPEED);
    },() -> {
      algaeMotorShoot.stopMotor();
    });
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
