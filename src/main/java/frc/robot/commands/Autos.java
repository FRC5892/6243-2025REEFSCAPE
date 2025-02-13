// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(DriveSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  private Autos() {
    var speeds = new ChassisSpeeds(3.0,-2.0,Math.PI);
    throw new UnsupportedOperationException("This is a utility class!");
  } 

  ChassisSpeeds speeds = ChassisSpeeds.fromFieldRelativeSpeeds(
      2.0,2.0, Math.PI / 2.0, Rotation2d.fromDegrees(45));

}
