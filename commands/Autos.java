// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
//import frc.robot.subsystems.PWMDrivetrain;
import frc.robot.subsystems.CANDrivetrain;
 import frc.robot.subsystems.CANElevator;
 import frc.robot.commands.*;
 import frc.robot.subsystems.CANElevator;
 import frc.robot.subsystems.CANLauncher;
 import frc.robot.commands.LaunchNote;
 import frc.robot.subsystems.*;

public final class Autos {
  //  CANLauncher m_launcher;
  //  CANElevator m_Elevator;
  //  CANIntake m_Intake;
  //  CANDrivetrain m_drivebase;

  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(CANDrivetrain drivetrain,CANLauncher launcher, CANElevator elevator,CANIntake intake) {
   CANLauncher m_launcher;
   CANElevator m_Elevator;
   CANIntake m_Intake;
   CANDrivetrain m_drivebase;

    m_launcher= launcher;
    m_Elevator = elevator;
    m_Intake = intake;
    m_drivebase = drivetrain;

    
     * RunCommand is a helper class that creates a command from a single method, in this case we
     * pass it the arcadeDrive method to drive straight back at half power. We modify that command
     * with the .withTimeout(1) decorator to timeout after 1 second, and use the .andThen decorator
     * to stop the drivetrain after the first command times out
     
    return new RunCommand(() -> new SequentialCommandGroup(
      new ElevatorUp(m_Elevator, 0.3, 2).withTimeout(3),
      new LaunchNote(m_launcher,0.0,0.0).withTimeout(2.0),
      new ParallelCommandGroup(
        new LaunchNote(m_launcher,0.0,0.0).withTimeout(2.0),
        new FeedShoot(m_Intake, 0, 0).withTimeout(2.0)
      ),
      new ElevatorDown(m_Elevator, 0, 0).withTimeout(2.0),
      new AutoDrive(m_drivebase, 1).withTimeout(4)
      ),m_Elevator, m_Intake,m_drivebase,m_launcher); 
      
     
     
      return new RunCommand(() ->
        drivetrain.arcadeDrive(.5, 0), drivetrain)
          .withTimeout(4)
         .andThen(new RunCommand(() -> drivetrain.arcadeDrive(0, 0), drivetrain));
         
          
        
        
  }


  public Command elevatorAuto(CANDrivetrain drivetrain,CANLauncher launcher, CANElevator elevator){

    // new SequentialCommandGroup(
    //   new ElevatorUp(m_Elevator, 0.3, 2).withTimeout(3),
    //   new LaunchNote(m_launcher,0.0,0.0).withTimeout(2.0),
    //   new ParallelCommandGroup(
    //     new LaunchNote(m_launcher,0.0,0.0).withTimeout(2.0),
    //     new FeedShoot(m_Intake, 0, 0).withTimeout(2.0)
    //   ),
    //   new ElevatorDown(m_Elevator, 0, 0).withTimeout(2.0),
    //   new autoDrive(m_drivebase, 1).withTimeout(4)
    //   ));

    return null;
    }
  
 
    
    
      /*addCommands(new ParallelDeadlineGroup(
      new Auto_DriveForward(5,120).withTimeout(4),
      new LED_spark(.57),
      new Arm_Intake(-8000)
      )); */
  

  

  

  
       
      
  

 

  private void addCommands(SequentialCommandGroup sequentialCommandGroup) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addCommands'");
  }
  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
