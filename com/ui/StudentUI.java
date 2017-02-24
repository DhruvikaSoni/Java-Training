package com.ui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentUI.
 */
public class StudentUI extends Frame {

	/** The lbl roll. */
	public Label lblRoll;

	/** The lbl name. */
	public Label lblName;

	/** The lbl address. */
	public Label lblAddress;

	/** The lbl marks. */
	public Label lblMarks;

	/** The lbl age. */
	public Label lblAge;

	/** The lbl gender. */
	public Label lblGender;

	/** The lbl male. */
	public Label lblMale;

	/** The lbl female. */
	public Label lblFemale;

	/** The roll txt. */
	public TextField rollTxt;

	/** The name txt. */
	public TextField nameTxt;

	/** The marks txt. */
	public TextField marksTxt;

	/** The age ch. */
	public Choice ageCh;

	/** The gender grp. */
	public CheckboxGroup genderGrp;

	/** The male radio. */
	public Checkbox maleRadio;

	/** The female radio. */
	public Checkbox femaleRadio;

	/** The address txt area. */
	public TextArea addressTxtArea;

	/** The btn save. */
	public Button btnSave;

	/** The btn update. */
	public Button btnUpdate;

	/** The btn delete. */
	public Button btnDelete;

	/** The btn search. */
	public Button btnSearch;

	/** The btn first. */
	public Button btnFirst;

	/** The btn last. */
	public Button btnLast;

	/** The btn next. */
	public Button btnNext;

	/** The btn prev. */
	public Button btnPrev;

	/**
	 * Instantiates a new student UI.
	 *
	 * @param title
	 *            the title
	 */
	public StudentUI(String title) {
		setBounds(100, 100, 500, 600);
		setVisible(true);
		setTitle(title);
		setLayout(null);

		lblRoll = new Label("Roll No");
		lblRoll.setBounds(70, 100, 70, 30);
		rollTxt = new TextField();
		rollTxt.setBounds(170, 100, 150, 30);

		lblName = new Label("Name");
		lblName.setBounds(70, 150, 70, 30);
		nameTxt = new TextField();
		nameTxt.setBounds(170, 150, 150, 30);

		lblAddress = new Label("Address");
		lblAddress.setBounds(70, 200, 70, 30);
		addressTxtArea = new TextArea(3, 150);
		addressTxtArea.setBounds(170, 200, 150, 90);

		lblMarks = new Label("Marks");
		lblMarks.setBounds(70, 300, 70, 30);
		marksTxt = new TextField();
		marksTxt.setBounds(170, 300, 150, 30);

		lblAge = new Label("Age");
		lblAge.setBounds(70, 350, 70, 30);
		ageCh = new Choice();
		for (int i = 4; i < 24; i++)
			ageCh.add(String.valueOf(i));
		ageCh.setBounds(170, 350, 50, 30);

		lblGender = new Label("Gender");
		lblGender.setBounds(70, 400, 70, 30);
		genderGrp = new CheckboxGroup();
		maleRadio = new Checkbox("Male", genderGrp, true);
		maleRadio.setBounds(170, 410, 10, 10);
		femaleRadio = new Checkbox("Female", genderGrp, false);
		femaleRadio.setBounds(240, 410, 10, 10);
		lblMale = new Label("Male");
		lblMale.setBounds(185, 400, 40, 30);
		lblFemale = new Label("Female");
		lblFemale.setBounds(255, 400, 50, 30);

		btnSave = new Button("Save");
		btnSave.setBounds(70, 450, 50, 30);
		btnUpdate = new Button("Update");
		btnUpdate.setBounds(130, 450, 50, 30);
		btnDelete = new Button("Delete");
		btnDelete.setBounds(190, 450, 50, 30);
		btnSearch = new Button("Search");
		btnSearch.setBounds(250, 450, 50, 30);

		btnFirst = new Button("First");
		btnFirst.setBounds(70, 490, 50, 30);
		btnPrev = new Button("Prev");
		btnPrev.setBounds(130, 490, 50, 30);
		btnNext = new Button("Next");
		btnNext.setBounds(190, 490, 50, 30);
		btnLast = new Button("Last");
		btnLast.setBounds(250, 490, 50, 30);

		add(lblRoll);
		add(rollTxt);
		add(lblName);
		add(nameTxt);
		add(lblAddress);
		add(addressTxtArea);
		add(lblMarks);
		add(marksTxt);
		add(lblAge);
		add(ageCh);
		add(lblGender);
		add(maleRadio);
		add(femaleRadio);
		add(lblMale);
		add(lblFemale);
		add(btnSave);
		add(btnUpdate);
		add(btnDelete);
		add(btnSearch);
		add(btnFirst);
		add(btnPrev);
		add(btnNext);
		add(btnLast);

		MyListener myListener = new MyListener(this);
		addWindowListener(myListener);
		btnSave.addActionListener(myListener);
		btnUpdate.addActionListener(myListener);
		btnDelete.addActionListener(myListener);
		btnSearch.addActionListener(myListener);
		btnFirst.addActionListener(myListener);
		btnLast.addActionListener(myListener);
		btnPrev.addActionListener(myListener);
		btnNext.addActionListener(myListener);

	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		new StudentUI("Student");
	}

}
