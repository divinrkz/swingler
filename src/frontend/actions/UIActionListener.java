package frontend.actions;

import backend.Repository;
import backend.models.Student;
import frontend.screens.B;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIActionListener implements ActionListener {
    private JFrame topWindow;

    public UIActionListener() {
    }

    public UIActionListener(ActionEvent e, Student student) {
        System.out.println(saveStudent(e, student));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand);
        if (actionCommand.equals("ADD_STUD_001")) {
            System.out.println("me here");
            new B();
        }
    }

    public boolean saveStudent(ActionEvent e, Student student) {
        Boolean saved =  new Repository().saveStudent(student);
        return saved;
    }
}
