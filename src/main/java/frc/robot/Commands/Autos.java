// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public final class Autos {
  
 public static Command TestCenterTwoPiece(DriveSubsystem drive,CoralSubsystem coral) {
    // this is like a joystick. But, the speed is always 1 (100% forward
    // and the rotation is always 0 (forward)
    return drive.driveCommand(()->-0.6, ()->0).withTimeout(5)
    .andThen(
      // outtake for 5 seconds 
      coral.coralForwardCommand().withTimeout(3))
    .andThen(
      drive.driveCommand(()->0.6, ()->0).withTimeout(2)
    )
    .andThen(
      drive.driveCommand(()->-0.6, ()->0.6).withTimeout(1)
      )
    .andThen(
      drive.driveCommand(()->-0.7, ()->0).withTimeout(7)
    )
    .andThen(
      drive.driveCommand(()->0.6, ()->0.6).withTimeout(1)
    )
    .andThen(
      drive.driveCommand(()->-0.6, ()->0).withTimeout(5.4)
    )
    .andThen(
      coral.coralForwardCommand().withTimeout(3)
    );
  }

  public static Command OneCenterL1Auto(DriveSubsystem drive,CoralSubsystem coral) {
    // this is like a joystick. But, the speed is always 1 (100% forward
    // and the rotation is always 0 (forward)
    return drive.driveCommand(()->-0.6, ()->0).withTimeout(5)
    .andThen(
      // outtake for 5 seconds 
      coral.coralForwardCommand().withTimeout(3));
  }   

  public static Command OneLeftL1Auto(DriveSubsystem drive,CoralSubsystem coral) {
    // this is like a joystick. But, the speed is always 1 (100% forward
    // and the rotation is always 0 (forward)
    return drive.driveCommand(()->-0.6, ()->0).withTimeout(5)
    .andThen(
      // outtake for 5 seconds 
      drive.driveCommand(()->0.6,()->1)
    )
    .andThen(
      drive.driveCommand(()->-0.6, ()->0).withTimeout(2)
    )
    .andThen(
      coral.coralForwardCommand().withTimeout(5)
    ) ; 
  } 

  public static Command OneRightL1Auto(DriveSubsystem drive,CoralSubsystem coral) {
    // this is like a joystick. But, the speed is always 1 (100% forward
    // and the rotation is always 0 (forward)
    return drive.driveCommand(()->-0.6, ()->0).withTimeout(5)
    .andThen(
      // outtake for 5 seconds 
      drive.driveCommand(()->0,()->-30)
    )
    .andThen(
      drive.driveCommand(()->-0.6, ()->0).withTimeout(2)
    )
    .andThen(
      coral.coralForwardCommand().withTimeout(5)
    ); 
  } 
  
  

  public static Command RightOneHalfAuto(DriveSubsystem drive,CoralSubsystem coral) {
    // this is like a joystick. But, the speed is always 1 (100% forward
    // and the rotation is always 0 (forward)
    return drive.driveCommand(()->-0.6, ()->0).withTimeout(5)
    .andThen(
      // outtake for 5 seconds 
      drive.driveCommand(()->0,()->0.30)
    )
    .andThen(
      drive.driveCommand(()->-0.6, ()->0).withTimeout(2)
    )
    .andThen(
      coral.coralForwardCommand().withTimeout(5)
    )
    .andThen(
      drive.driveCommand(()->0.6,()->0).withTimeout(2)
    )
    .andThen(
      drive.driveCommand(()->0,()->0.90).withTimeout(2)
    )
    .andThen(
      drive.driveCommand(()->-0.8, ()->0).withTimeout(2)
    )
    .andThen(
      drive.driveCommand(()->0,()->0.45).withTimeout(2)
    )
    .andThen(
      drive.driveCommand(()->-0.6, ()->0).withTimeout(0)
    );
  } 

  private Autos() {                                                                                                                                                                                                                                                                                                          
    throw new UnsupportedOperationException("This is a utility class!");
  }
}