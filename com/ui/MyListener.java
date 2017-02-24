package com.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.model.student.Student;
import com.service.StudentService;
import com.service.impl.StudentImpl;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving my events. The class that is interested
 * in processing a my event implements this interface, and the object created
 * with that class is registered with a component using the component's
 * <code>addMyListener<code> method. When the my event occurs, that object's
 * appropriate method is invoked.
 *
 * @see MyEvent
 */
public class MyListener implements WindowListener, ActionListener {

	/** The student UI. */
	StudentUI studentUI;

	/** The result set. */
	ResultSet resultSet;

	/** The student. */
	Student student;

	/** The student service. */
	StudentService studentService = new StudentImpl();

	/**
	 * Instantiates a new my listener.
	 *
	 * @param studentUI
	 *            the student UI
	 */
	public MyListener(StudentUI studentUI) {
		// TODO Auto-generated constructor stub
		this.studentUI = studentUI;
		try {
			studentService.getAllStudents();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * My student.
	 *
	 * @return the student
	 */
	public Student myStudent() {
		Student student = new Student();
		student.setRoll(Integer.parseInt(studentUI.rollTxt.getText()));
		student.setName(studentUI.nameTxt.getText());
		student.setMarks(Float.parseFloat(studentUI.marksTxt.getText()));
		student.setAge(studentUI.ageCh.getSelectedItem());
		student.setGender(studentUI.genderGrp.getSelectedCheckbox().getLabel());
		student.setAddress(studentUI.addressTxtArea.getText());
		return student;
	}

	/**
	 * Clear fields.
	 */
	public void clearFields() {
		studentUI.rollTxt.setText("");
		studentUI.nameTxt.setText("");
		studentUI.marksTxt.setText("");
		studentUI.ageCh.select("4");
		studentUI.addressTxtArea.setText("");
		studentUI.maleRadio.setState(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == studentUI.btnSave) {
			try {
				callSave();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error in Save", "InfoBox ", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ae.getSource() == studentUI.btnUpdate) {
			try {
				callUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error in Update", "InfoBox ", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ae.getSource() == studentUI.btnDelete) {
			try {
				callDelete();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error in Delete", "InfoBox ", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ae.getSource() == studentUI.btnSearch) {
			try {
				callSearch();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error in Search", "InfoBox ", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ae.getSource() == studentUI.btnFirst) {
			try {
				callFirst();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error in First Record", "InfoBox ", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ae.getSource() == studentUI.btnLast) {
			try {
				callLast();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error in Last Record", "InfoBox ", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ae.getSource() == studentUI.btnNext) {
			try {
				callNext();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error in Next Record", "InfoBox ", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ae.getSource() == studentUI.btnPrev) {
			try {
				callPrev();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error in Previous Record", "InfoBox ", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	/**
	 * Call save.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void callSave() throws SQLException {
		student = myStudent();
		studentService.saveStudent(student);
		clearFields();
	}

	/**
	 * Call update.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void callUpdate() throws SQLException {
		student = myStudent();
		studentService.updateStudent(student);
		clearFields();
	}

	/**
	 * Call delete.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void callDelete() throws SQLException {
		int roll = Integer.parseInt(studentUI.rollTxt.getText());
		studentService.deleteStudent(roll);
		clearFields();
	}

	/**
	 * Call search.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void callSearch() throws SQLException {
		int roll = Integer.parseInt(studentUI.rollTxt.getText());
		student = studentService.searchStudent(roll);
		setStudent(student);
	}

	/**
	 * Call first.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void callFirst() throws SQLException {
		student = studentService.getFirstStudent();
		setStudent(student);
	}

	/**
	 * Call last.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void callLast() throws SQLException {
		student = studentService.getLastStudent();
		setStudent(student);
	}

	/**
	 * Call next.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void callNext() throws SQLException {
		student = studentService.getNextStudent();
		setStudent(student);
	}

	/**
	 * Call prev.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void callPrev() throws SQLException {
		student = studentService.getPrevStudent();
		setStudent(student);
	}

	/**
	 * Sets the student.
	 *
	 * @param student
	 *            the new student
	 */
	public void setStudent(Student student) {
		studentUI.rollTxt.setText(String.valueOf(student.getRoll()));
		studentUI.nameTxt.setText(student.getName());
		studentUI.marksTxt.setText(String.valueOf(student.getMarks()));
		studentUI.ageCh.select(student.getAge());
		studentUI.addressTxtArea.setText(student.getAddress());
		if (student.getGender().equals("Male"))
			studentUI.maleRadio.setState(true);
		else
			studentUI.femaleRadio.setState(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		studentUI.dispose();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.
	 * WindowEvent)
	 */
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.
	 * WindowEvent)
	 */
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
