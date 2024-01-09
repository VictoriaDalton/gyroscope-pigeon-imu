// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU.CalibrationMode;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Gyro extends SubsystemBase {
  
  //create a pigeonIMU gyro check the constants if a problem occurs with the port
//TalonSRX _talon2 = new TalonSRX(Constants.gyroPort); 
private NetworkTableEntry m_networkTableEntry;

private ShuffleboardTab m_ShuffleboardTab = Shuffleboard.getTab("gyro info");
private GenericEntry gyroPlease;
WPI_PigeonIMU m_gyro = new WPI_PigeonIMU(Constants.gyroPort); 
private double[] gyroData = {0.0,0.0,0.0};
public Gyro(){
               //gets the general status VI
              PigeonIMU.GeneralStatus genStatus = new PigeonIMU.GeneralStatus();
              m_gyro.getGeneralStatus(genStatus);

              //sets the yaw,Pitch,Roll and the fuseHeading
              m_gyro.setYaw(0);
              m_gyro.setFusedHeading(0);
}

 public double[] getYawPitchRoll() {
     double [] yawPitchRoll = new double[3];
      m_gyro.getYawPitchRoll(yawPitchRoll);
      return yawPitchRoll;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    this.gyroData = getYawPitchRoll();
    gyroPlease.setDoubleArray(gyroData);
   
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
 
  }

  public void robotInit() {
  //to test
SmartDashboard.putNumberArray("yaw pitch & roll", gyroData);
gyroPlease = m_ShuffleboardTab.add("yes",gyroData).getEntry();
 }
}


