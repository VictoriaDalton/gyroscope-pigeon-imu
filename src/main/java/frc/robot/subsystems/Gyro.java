// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU.CalibrationMode;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Gyro extends SubsystemBase {
  
  //create a pigeonIMU gyro check the constants if a problem occurs with the port
 WPI_PigeonIMU m_gyro = new WPI_PigeonIMU(Constants.gyroPort); 

public Gyro(){
               //gets the general status VI
              PigeonIMU.GeneralStatus genStatus = new PigeonIMU.GeneralStatus();
              m_gyro.getGeneralStatus(genStatus);

              //sets the yaw and the fuseHeading
              m_gyro.setYaw(0);
              m_gyro.setFusedHeading(0);

              //calibrates the gyro might not work
              m_gyro.enterCalibrationMode(CalibrationMode.Temperature);
               m_gyro.enterCalibrationMode(CalibrationMode.Accelerometer);
                m_gyro.enterCalibrationMode(CalibrationMode.Magnetometer12Pt);
                 m_gyro.enterCalibrationMode(CalibrationMode.Magnetometer360);
}

 public void robotInit() {
    // Places a compass indicator for the gyro heading on the dashboard
    Shuffleboard.getTab("gyro data").add(m_gyro);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double[] yawPitchRoll = new double[3];
     m_gyro.getYawPitchRoll(yawPitchRoll);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
