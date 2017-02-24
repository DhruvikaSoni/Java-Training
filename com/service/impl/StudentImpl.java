package com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.student.Student;
import com.service.StudentService;
import common.DBHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentImpl.
 */
public class StudentImpl implements StudentService {

	/** The db. */
	DBHelper db = new DBHelper();

	/** The con. */
	Connection con = db.getDBConnection();

	/** The ps. */
	PreparedStatement ps;

	/** The student. */
	Student student;

	/** The rs. */
	ResultSet rs;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#saveStudent(com.model.Student)
	 */
	@Override
	public void saveStudent(Student student) throws SQLException {
		ps = con.prepareStatement("insert into student values(?,?,?,?,?,?);");
		ps.setInt(1, student.getRoll());
		ps.setString(2, student.getName());
		ps.setString(3, student.getAge());
		ps.setFloat(4, student.getMarks());
		ps.setString(5, student.getGender());
		ps.setString(6, student.getAddress());
		ps.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#updateStudent(com.model.Student)
	 */
	@Override
	public void updateStudent(Student student) throws SQLException {
		ps = con.prepareStatement("update student set name=?, age=?, marks=?, gender=?,address=? where roll=?");
		ps.setString(1, student.getName());
		ps.setString(2, student.getAge());
		ps.setFloat(3, student.getMarks());
		ps.setString(4, student.getGender());
		ps.setString(5, student.getAddress());
		ps.setInt(6, student.getRoll());
		ps.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#getFirstStudent()
	 */
	@Override
	public Student getFirstStudent() throws SQLException {
		rs.first();
		student = setStudentData(rs);
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#getLastStudent()
	 */
	@Override
	public Student getLastStudent() throws SQLException {
		rs.last();
		student = setStudentData(rs);
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#getNextStudent()
	 */
	@Override
	public Student getNextStudent() throws SQLException {
		rs.next();
		student = setStudentData(rs);
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#getPrevStudent()
	 */
	@Override
	public Student getPrevStudent() throws SQLException {
		rs.previous();
		student = setStudentData(rs);
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#deleteStudent(int)
	 */
	@Override
	public void deleteStudent(int roll) throws SQLException {
		ps = con.prepareStatement("delete from student where roll=?");
		ps.setInt(1, roll);
		ps.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#searchStudent(int)
	 */
	@Override
	public Student searchStudent(int roll) throws SQLException {
		ps = con.prepareStatement("select * from student where roll=?");
		ps.setInt(1, roll);
		ResultSet rs = ps.executeQuery();
		rs.first();
		student = setStudentData(rs);
		return student;
	}

	/**
	 * Sets the student data.
	 *
	 * @param rs
	 *            the rs
	 * @return the student
	 * @throws SQLException
	 *             the SQL exception
	 */
	public Student setStudentData(ResultSet rs) throws SQLException {
		student = new Student();
		student.setRoll(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setMarks(rs.getFloat(3));
		student.setAge(rs.getString(4));
		student.setGender(rs.getString(5));
		student.setAddress(rs.getString(6));
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#getAllStudents()
	 */
	public void getAllStudents() throws SQLException {
		ps = con.prepareStatement("select * from student ");
		rs = ps.executeQuery();
	}
}
