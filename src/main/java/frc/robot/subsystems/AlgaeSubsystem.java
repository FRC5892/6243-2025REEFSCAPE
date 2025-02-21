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
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AlgaeSubsystem extends SubsystemBase {
   private final SparkMax algaeMotorMove = new SparkMax(Constants.IdConstants.ALGAE_MOTOR_MOVE_ID,MotorType.kBrushed);
   private final SparkMax algaeMotorShoot = new SparkMax(Constants.IdConstants.ALGAE_MOTOR_SHOOT_ID, MotorType.kBrushed);
  /** Creates a new CoralSubsystem. */
  /** Creates a new AlgaeSubsystem. */
  public AlgaeSubsystem() {
     SparkBaseConfig config = new SparkMaxConfig();
     SparkBaseConfig config2 = new SparkMaxConfig();
        algaeMotorMove.configure(config.inverted(true), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        algaeMotorShoot.configure(config2.inverted(true), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
      }

      public Command algaeForwardCommand (){
    return new RunCommand(()->{
         algaeMotorMove.set(Constants.SpeedConstants.ALGAE_MOTOR_MOVE_SPEED);
       },this);
     }

     public Command algaeBackCommand (){
      return new RunCommand(()->{
           algaeMotorMove.set(Constants.SpeedConstants.ALGAE_MOTOR_MOVE_BACK_SPEED);
         },this);
       }

       public Command algaeStopCommand (){
        return new RunCommand(()->{
             algaeMotorMove.set(0);
           },this);
         }

         public Command algaeOutakeCommand (){
          return new RunCommand(()->{
            algaeMotorShoot.set(Constants.SpeedConstants.ALGAE_MOTOR_OUTTAKE_SPEED);
             },this);
           }

           public Command algaeIntakeCommand (){
            return new RunCommand(()->{
              algaeMotorShoot.set(Constants.SpeedConstants.ALGAE_MOTOR_INTAKE_SPEED);
               },this);
             }
             public Command algaeStopShootingCommand (){
              return new RunCommand(()->{
                algaeMotorShoot.set(0);
                 },this);
               }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
