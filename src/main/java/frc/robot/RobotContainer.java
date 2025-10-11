// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Commands.Autos;
import frc.robot.subsystems.AlgaeSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

//AUTONOMUS Im not sure if it should be here.  
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_DriveSubsystem = new DriveSubsystem();
  private final CoralSubsystem m_CoralSubsystem = new CoralSubsystem();
  private final AlgaeSubsystem m_AlgaeSubsystem = new AlgaeSubsystem();
  private final ClimbSubsystem m_ClimbSubsystem = new ClimbSubsystem();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_codriverController =
      new CommandXboxController(OperatorConstants.kCoDriverControllerPort);

  /*
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   */

  public RobotContainer() {
    // Configure the trigger bindings
    SendableChooser<Command> autoChooser = new SendableChooser<>();
    autoChooser.addOption("None", Commands.none());
    autoChooser.addOption("Center One L1", Autos.OneCenterL1Auto(m_DriveSubsystem,m_CoralSubsystem));
    SmartDashboard.putData("Auto Chooser",autoChooser);
    configureBindings();
  }

  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    
    //Drive Controls
    m_DriveSubsystem.setDefaultCommand(m_DriveSubsystem.driveCommand(m_driverController::getLeftY, m_driverController::getLeftX));


    //Coral Controls
    m_codriverController.a().whileTrue(m_CoralSubsystem.coralForwardCommand());
    m_codriverController.x().whileTrue(m_CoralSubsystem.coralBackwardCommand());
    //Regular Climb Controls
    m_codriverController.rightTrigger().whileTrue(m_ClimbSubsystem.climbUpCommand());
    m_codriverController.leftTrigger().whileTrue(m_ClimbSubsystem.climbDownCommand());
    //Preset Climb Controls
    m_codriverController.start().onTrue(m_ClimbSubsystem.climbUpCommand().withTimeout(1));
    m_codriverController.back().onTrue(m_ClimbSubsystem.climbDownCommand().withTimeout(1.5));
    //Algae Controls
    m_codriverController.b().whileTrue(m_AlgaeSubsystem.algaeArmForwardCommand());
    m_codriverController.y().whileTrue(m_AlgaeSubsystem.algaeArmBackwardCommand());
    m_codriverController.rightBumper().whileTrue(m_AlgaeSubsystem.algaeIntakeCommand());
    m_codriverController.leftBumper().whileTrue(m_AlgaeSubsystem.algaeOuttakeCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
   
   public Command getAutonomousCommand() {
    return Autos.OneCenterL1Auto(m_DriveSubsystem,m_CoralSubsystem);
  }
}