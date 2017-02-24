package com.service;

import java.sql.SQLException;

import com.model.student.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentService.
 */
public interface StudentService {

	/**
	 * Save student.
	 *
	 * @param student
	 *            the student
	 * @throws SQLException
	 *             the SQL exception
	 */
	void saveStudent(Student student) throws SQLException;

	/**
	 * Update student.
	 *
	 * @param student
	 *            the student
	 * @throws SQLException
	 *             the SQL exception
	 */
	void updateStudent(Student student) throws SQLException;

	/**
	 * Gets the first student.
	 *
	 * @return the first student
	 * @throws SQLException
	 *             the SQL exception
	 */
	Student getFirstStudent() throws SQLException;

	/**
	 * Gets the last student.
	 *
	 * @return the last student
	 * @throws SQLException
	 *             the SQL exception
	 */
	Student getLastStudent() throws SQLException;

	/**
	 * Gets the next student.
	 *
	 * @return the next student
	 * @throws SQLException
	 *             the SQL exception
	 */
	Student getNextStudent() throws SQLException;

	/**
	 * Gets the prev student.
	 *
	 * @return the prev student
	 * @throws SQLException
	 *             the SQL exception
	 */
	Student getPrevStudent() throws SQLException;

	/**
	 * Delete student.
	 *
	 * @param roll
	 *            the roll
	 * @throws SQLException
	 *             the SQL exception
	 */
	void deleteStudent(int roll) throws SQLException;

	/**
	 * Search student.
	 *
	 * @param roll
	 *            the roll
	 * @return the student
	 * @throws SQLException
	 *             the SQL exception
	 */
	Student searchStudent(int roll) throws SQLException;

	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 * @throws SQLException
	 *             the SQL exception
	 */
	void getAllStudents() throws SQLException;

}
