// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Rotation;

import java.util.function.DoubleSupplier;
import com.pathplanner.lib.auto.AutoBuilder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;
import com.pathplanner.lib.config.RobotConfig;
import com.pathplanner.lib.controllers.PPLTVController;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.estimator.PoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.AutoLogOutput;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.Odometry;
import com.pathplanner.lib.config.RobotConfig;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.estimator.DifferentialDrivePoseEstimator;
import edu.wpi.first.math.kinematics.DifferentialDriveModulePosition;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  
  private final SparkMax leftFrontMotor = new SparkMax(Constants.IdConstants.LEFT_FRONT_MOTOR_ID,MotorType.kBrushed);
  private final SparkMax rightFrontMotor = new SparkMax(Constants.IdConstants.RIGHT_FRONT_MOTOR_ID,MotorType.kBrushed);
  private final SparkMax leftBackMotor = new SparkMax(Constants.IdConstants.LEFT_BACK_MOTOR_ID,MotorType.kBrushed);
  private final SparkMax rightBackMotor = new SparkMax(Constants.IdConstants.RIGHT_BACK_MOTOR_ID,MotorType.kBrushed);
  private final DifferentialDrive differentialDrive;
  
  Encoder m_leftEncoder = new Encoder(0,1);
  Encoder m_rightEncoder = new Encoder(0,2);
  
  DifferentialDriveOdometry m_odometry = new DifferentialDriveOdometry(
    m_gyro.getRotation2d(),
    m_leftEncoder.getDistance(), m_rightEncoder.getDistance(),
    new Pose2d(5.0, 13.5, new Rotation2d())); 
    
    private DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(getModuleTranslations());
    private Rotation2d rawGyroRotation = new Rotation2d();
    private DifferentialDriveModulePosition[] lastModulePositions =
    new DifferentialDriveModulePosition[] {
      new DifferentialDriveModulePosition(),
      new DifferentialDriveModulePosition(),
      new DifferentialDriveModulePosition(),
      new DifferentialDriveModulePosition()
    };

    private DifferentialDrivePoseEstimator poseEstimator =
    new DiffentialDriveEstimator(kinematics, rawGyroRotation, lastModulePositions, new Pose2d());

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    SparkBaseConfig configer = new SparkMaxConfig();
    SparkBaseConfig config2 = new SparkMaxConfig(); 
    SparkBaseConfig config4 = new SparkMaxConfig();
    SparkBaseConfig config5 = new SparkMaxConfig();
        leftBackMotor.configure(configer.follow(leftFrontMotor), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightBackMotor.configure(config2.follow(rightFrontMotor), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftFrontMotor.configure(config4.inverted(false), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFrontMotor.configure(config5.inverted(true), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        differentialDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
        
        RobotConfig config;
        try{
          config = RobotConfig.fromGUISettings();
        } catch (Exception e) {
          e.printStackTrace(null);
        }
        
        AutoBuilder.configure(
          this::getPose,
          this::resetPose,
          this::RobotRelativeSpeeds,
          (speeds, feedforwards)->driveRobotRelative(speeds),
          new PPLTVController(0.02),
          config, () -> {
            var alliance = DriverStation.getAlliance();
            if(alliance.isPresent()) {
              return alliance.get() == DriverStation.Alliance.Red;
            }
            return false;
          },
          this
        );

      }
  
  public Command driveCommand(DoubleSupplier speed, DoubleSupplier rotation){
    return runEnd(()->{
      differentialDrive.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
    },() -> {
      differentialDrive.stopMotor();
    });
  } 
  private final double getHeading(){
    
  }

  @AutoLogOutput(key = "Odometry/Robot")
    public Pose2d getPose(){
      return poseEstimator.getEstimatedPosition();
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_odometry.update(
      Rotation2d.fromDegrees(getHeading()),
      m_leftEncoder.getDistance(),
      m_rightEncoder.getDistance());
      m_fieldSim.setRobotPose(getPose());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

 public Command exampleMethodCommand() {
//    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'exampleMethodCommand'");
 }
}
