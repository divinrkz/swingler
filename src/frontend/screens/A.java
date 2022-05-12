package frontend.screens;

import backend.Repository;
import backend.models.Student;
import frontend.actions.UIActionListener;
import frontend.utils.Util;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class A extends JFrame {


    public A() {
        this.setTitle("Screen A");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLayout(new java.awt.BorderLayout(10, 10));


        this.setBackground(new Color(255, 255, 255));

        UIInitiator();


        this.setVisible(true);

    }


    public void UIInitiator() {
        try {
            JPanel topPanel = new JPanel();
            topPanel.setLayout(new BorderLayout());
            topPanel.setBackground(Color.red);
//            topPanel.setPreferredSize(new Dimension(90, 170));

            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new BorderLayout());
            bottomPanel.setBackground(Color.red);
//            bottomPanel.setPreferredSize(new Dimension(90, 100));

            headerComponent(topPanel);
            tableComponent(bottomPanel);


            this.add(topPanel, java.awt.BorderLayout.NORTH);
            this.add(bottomPanel, BorderLayout.SOUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void headerComponent(JPanel panel) {
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
z
        JMenuBar menuBar = new JMenuBar();
        JMenu homeMenu = new JMenu();
        JMenu schoolsMenu = new JMenu("Schools");
        JMenu studentsMenu = new JMenu("Students");
        JMenuItem addStudentMenuItem = new JMenuItem("Add new");
        JMenu exitMenu = new JMenu("Exit");


        addStudentMenuItem.setActionCommand("ADD_STUD_001");
        addStudentMenuItem.addActionListener(new UIActionListener());






        ImageIcon schoolIconImage = new ImageIcon("assets/images/school.png");
        headerTitleLabel.setIcon(Util.resizeImage(schoolIconImage, 90, 90));
        headerTitleLabel.setText("School Management Information System");
        headerTitleLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
        headerTitleLabel.setForeground(Color.BLACK);
        headerTitleLabel.setHorizontalTextPosition(JLabel.RIGHT);
        headerTitleLabel.setVerticalTextPosition(JLabel.CENTER);
        headerTitleLabel.setIconTextGap(40);
        headerTitleLabel.setVerticalAlignment(JLabel.CENTER);


        ImageIcon profileIconImage = new ImageIcon("assets/images/profile.jpg");
        userProfileLabel.setIcon(Util.resizeImage(profileIconImage, 90, 90));
        userProfileLabel.setText("Your Name");
        userProfileLabel.setFont(new Font("", Font.PLAIN, 13));
        userProfileLabel.setForeground(Color.BLACK);
        userProfileLabel.setHorizontalTextPosition(JLabel.CENTER);
        userProfileLabel.setVerticalTextPosition(JLabel.BOTTOM);
        userProfileLabel.setIconTextGap(40);
        userProfileLabel.setVerticalAlignment(JLabel.CENTER);

        homeMenu.setText("Home");
        homeMenu.setForeground(Color.BLACK);

        schoolsMenu.setText("Schools");
        schoolsMenu.setForeground(Color.BLACK);

        studentsMenu.setText("Students");
        studentsMenu.add(addStudentMenuItem);
        studentsMenu.setForeground(Color.BLACK);

        exitMenu.setText("Exit");
        homeMenu.setForeground(Color.BLACK);

        menuBar.add(homeMenu);
        menuBar.add(schoolsMenu);
        menuBar.add(studentsMenu);
        menuBar.add(exitMenu);



        JTextArea searchInput = new JTextArea(0,2);
        searchInput.setBorder(new LineBorder(Color.lightGray));
        searchInput.setText("Search ");


        top.setLayout(new BorderLayout());
        top.add(headerTitleLabel, BorderLayout.WEST);
        top.add(userProfileLabel, BorderLayout.EAST);

        bottom.setLayout(new BorderLayout(10, 30));

        bottom.add(menuBar, BorderLayout.WEST);
        bottom.add(searchInput, BorderLayout.CENTER);

        panel.add(top, BorderLayout.NORTH);
        panel.add(bottom,  BorderLayout.SOUTH);

    }

    public void tableComponent(JPanel panel) {
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Add new");
        JLabel descriptionLabel = new JLabel();


        titleLabel.setText("Add new");
        titleLabel.setFont(new Font("", Font.PLAIN, 13));
        titleLabel.setForeground(Color.BLACK);

        descriptionLabel.setText("List of Recorded Students");
        descriptionLabel.setFont(new Font("", Font.PLAIN, 13));
        descriptionLabel.setForeground(Color.BLACK);

        String[] columnNames = { "", "FirstName", "LastName", "Department", "School" };


        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        ArrayList<Student> students = new Repository().getAllStudents();

        for (Student student : students) {
            System.out.println(student.getId());

            JCheckBox checkBox = new JCheckBox("");
            checkBox.setBounds(0,0, 50,50);

            model.addRow(new Object[]{"", student.getFirstName(), student.getLastName(), student.getDepartmentId(), student.getDepartmentId()});
        }




        JTable table = new JTable();
        table.setModel(model);

        JScrollPane sp = new JScrollPane(table);
        tablePanel.setBackground(Color.RED);


        tablePanel.add(titleLabel);
        tablePanel.add(descriptionLabel);
        tablePanel.add(new JScrollPane(table));


        panel.add(tablePanel, BorderLayout.NORTH);


    }
}
