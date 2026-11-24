// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import static frc.robot.Constants.ElevatorConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;






//import frc.robot.subsystems.PWMLauncher;

import frc.robot.subsystems.CANElevator;


/*This is an example of creating a command as a class. The base Command class provides a set of methods that your command
 * will override.
 */
public class ElevatorUp extends Command {
 // PWMLauncher m_launcher;

  CANElevator m_elevator;
  RelativeEncoder m_ElevatorEncoder;
  double speed;
  /** Creates a new ElevatorUp. */
  public ElevatorUp(CANElevator elevator, double speed, double seconds) {
    // save the elevator system internally
   this.m_elevator = elevator;
    this.speed = speed;

    m_ElevatorEncoder = m_elevator.getEncoder();
    m_ElevatorEncoder.setPosition(0);

    // indicate that this command requires the elevator system
    addRequirements(m_elevator);
  }

  // The initialize method is called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Set the wheels to intaking speed
   while (m_ElevatorEncoder.getPosition() <= 45) {
    m_elevator.setElevator(kElevatorSpeed);
   }
    //m_elevator.setElevator(kElevatorSpeed);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // There is nothing we need this command to do on each iteration. You could remove this method
    // and the default blank method
    // of the base class will run.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_ElevatorEncoder.getPosition()>=45){
      return true;
    }
  
    // Always return false so the command never ends on it's own. In this project we use the
    // scheduler to end the command when the button is released.
    return false;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the wheels when the command ends.
    m_elevator.stop();
    
  }
}
