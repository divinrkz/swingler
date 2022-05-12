package frontend.screens;

import backend.Repository;
import backend.models.Department;
import backend.models.Student;
import frontend.actions.UIActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class B extends JFrame{
    JLabel registrationCodeLabel;
    JTextField registrationCodeInput;

    JLabel firstNameLabel;
    JTextField firstNameInput;

    JLabel lastNameLabel;
    JTextField lastNameInput;

    JLabel genderLabel;
    JTextField genderInput;
    JLabel femaleLabel;
    JRadioButton femaleRadioButton;
    JLabel maleLabel;
    JRadioButton maleRadioButton;


    ArrayList<Department> departments = null;



    JLabel birthDateLabel;
    JTextField birthDateInput;

    JLabel departmentLabel;
    JComboBox departmentSelect;

    public B() {
        this.setTitle("Screen B");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLayout(new java.awt.BorderLayout(10, 10));


        this.setBackground(new Color(255, 255, 255));

        UIInitiator();


        this.setVisible(true);

    }


    public void UIInitiator() {
        try {
            JPanel panel = new JPanel();
            formLayout(panel);
            this.add(panel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void formLayout(JPanel panel) {
        departments = new Repository().getAllDepartments();

        String departmentSelectValues[] = new String[departments.size()];

        int i = 0;
        for (Department department : departments) {
            departmentSelectValues[i] = department.getName();
            i++;
        }

        JPanel formPanel = new JPanel(new FlowLayout(SwingConstants.PREVIOUS, 10, 10));

        TitledBorder centerBorder = BorderFactory.createTitledBorder("Fill in Student Registration Form");
        centerBorder.setTitleJustification(TitledBorder.CENTER);
        centerBorder.setTitleColor(Color.RED);
        formPanel.setBorder(centerBorder);

        JPanel formAreaPanel = new JPanel(new GridLayout(0,2));

        registrationCodeLabel = new JLabel("Registration Number");
        registrationCodeInput = new JTextField(10);
        registrationCodeInput.setText("Code");

        firstNameLabel = new JLabel("First name");
        firstNameInput = new JTextField(10);
        firstNameInput.setText("Firstname");

        lastNameLabel = new JLabel("Last name");
        lastNameInput = new JTextField(10);
        lastNameInput.setText("Last name");

        genderLabel = new JLabel("Gender");
        ButtonGroup buttonGroup = new ButtonGroup();
        femaleLabel = new JLabel("Female");

        femaleRadioButton = new JRadioButton("Female");

        buttonGroup.add(femaleRadioButton);
        maleLabel = new JLabel("Male");

        maleRadioButton = new JRadioButton("Male");
        buttonGroup.add(maleRadioButton);


         departmentLabel = new JLabel("Departments");
         departmentSelect = new JComboBox(departmentSelectValues);



        JButton saveButton = new JButton();
        saveButton.setText("Save");
        saveButton.setActionCommand("SAVE_001");

        saveButton.addActionListener(
                e -> new UIActionListener(e, getStudent())
        );

        JButton cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.setActionCommand("CANCEL_001");


        formAreaPanel.add(registrationCodeLabel);
        formAreaPanel.add(registrationCodeInput);

        formAreaPanel.add(firstNameLabel);
        formAreaPanel.add(firstNameInput);

        formAreaPanel.add(lastNameLabel);
        formAreaPanel.add(lastNameInput);


        formAreaPanel.add(genderLabel);
        formAreaPanel.add(maleRadioButton);
        formAreaPanel.add(femaleRadioButton);

        formAreaPanel.add(departmentLabel);
        formAreaPanel.add(departmentSelect);


        formAreaPanel.add(saveButton);
        formAreaPanel.add(cancelButton);

        panel.add(formAreaPanel);
    }

    public Student getStudent(){
        Student student = new Student();
        student.setRegistrationNumber(registrationCodeInput.getText());
        student.setFirstName(firstNameInput.getText());
        student.setLastName(lastNameInput.getText());
        student.setGender(maleRadioButton.isSelected() ? "MALE" : femaleRadioButton.isSelected() ? "FEMALE" : "NA");
        student.setBirthDate(registrationCodeInput.getText());

        System.out.println(departmentSelect.getSelectedIndex());
        student.setDepartmentId(departments.get(departmentSelect.getSelectedIndex()).getId());

        return student;
    }

}
