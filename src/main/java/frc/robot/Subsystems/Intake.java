// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Timer;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;


public class Intake extends SubsystemBase {

  private static final double CURRENT_LIMIT_AMPS = 30.0;
  private Timer timerI;
  private final CANSparkMax intake1, intake2;
  public static final CANSparkLowLevel.MotorType kBrushed = MotorType.kBrushed;
  public static final CANSparkLowLevel.MotorType kBrushless = MotorType.kBrushless;
  

  // private final XboxController opController = new XboxController(1);

 
  

  public Intake(int FintakeID, int BintakeID) {

    FintakeID = 6;
    BintakeID = 5;

    intake1 = new CANSparkMax(6,kBrushed);
    intake2 = new CANSparkMax(5,kBrushed);
    timerI = new Timer();
   }


  public void setIntakeSpeed(double speed) {
    intake1.set(.7);
    intake2.set(.7);
  }
  public boolean isCurrentLimitExceeded() {
    return intake1.getOutputCurrent() > CURRENT_LIMIT_AMPS || intake2.getOutputCurrent() > CURRENT_LIMIT_AMPS;
  }
  public void startTimer() {
    timerI.start();
  }

 
  @Override
  public void periodic() {
 }
 public boolean isTimerExpired(double duration) {
  return timerI.hasElapsed(duration);
}

}
    
    


