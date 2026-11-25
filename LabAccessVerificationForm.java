package dcit50.gui;

import java.awt.*;
import javax.swing.*;

public class LabAccessVerificationForm extends JFrame {

    
    private final String expectedId = "2026-001";
    private final String expectedCode = "LAB123";
    private int attemptsRemaining = 3;

    private JLabel lblTitle, lblStudentId, lblAccessCode, lblStatus, lblAttemptsText, lblAttempts;
    private JTextField txtStudentId;
    private JPasswordField pwdAccessCode;
    private JButton btnVerify, btnClear;

    public LabAccessVerificationForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Lab Access Verification");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 10, 8, 10);
        c.anchor = GridBagConstraints.WEST;

        lblTitle = new JLabel("LAB ACCESS VERIFICATION");
        lblTitle.setFont(lblTitle.getFont().deriveFont(Font.BOLD, 18f));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        add(lblTitle, c);

        c.gridwidth = 1;
        lblStudentId = new JLabel("Student ID:");
        c.gridy = 1; add(lblStudentId, c);
        txtStudentId = new JTextField(15);
        c.gridx = 1; add(txtStudentId, c);

        lblAccessCode = new JLabel("Access Code:");
        c.gridx = 0; c.gridy = 2; add(lblAccessCode, c);
        pwdAccessCode = new JPasswordField(15);
        c.gridx = 1; add(pwdAccessCode, c);

        btnVerify = new JButton("VERIFY");
        btnClear = new JButton("CLEAR");
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttons.add(btnVerify);
        buttons.add(btnClear);
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        add(buttons, c);

        lblStatus = new JLabel("Waiting for verification...");
        c.gridy = 4; add(lblStatus, c);

        lblAttemptsText = new JLabel("Attempts Remaining:");
        lblAttempts = new JLabel("3");
        JPanel attempts = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        attempts.add(lblAttemptsText);
        attempts.add(lblAttempts);
        c.gridy = 5; add(attempts, c);

        btnVerify.addActionListener(evt -> btnVerifyActionPerformed(evt));
        btnClear.addActionListener(evt -> btnClearActionPerformed(evt));

        pack();
        setLocationRelativeTo(null);
    }

    
    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {
       
        String studentId = txtStudentId.getText();
        char[] codeChars = pwdAccessCode.getPassword();
        String accessCode = new String(codeChars);

       
        if (studentId.isBlank() || accessCode.isBlank()) {
            lblStatus.setText("Complete both fields.");
            return;
        }

        
        boolean idMatches = studentId.equals(expectedId);
        boolean codeMatches = accessCode.equals(expectedCode);

       
        if (idMatches && codeMatches) {
            lblStatus.setText("Verification accepted.");
        } else {
            
            attemptsRemaining--;
            lblAttempts.setText(String.valueOf(attemptsRemaining));

           
            if (attemptsRemaining <= 0) {
                lblStatus.setText("No attempts remaining.");
                btnVerify.setEnabled(false);
            } else {
                lblStatus.setText("Verification failed. Attempts remaining: " + attemptsRemaining);
            }
        }
    }

  
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {
        txtStudentId.setText("");
        pwdAccessCode.setText("");
        lblStatus.setText("Waiting for verification...");
        txtStudentId.requestFocus();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new LabAccessVerificationForm().setVisible(true));
    }
}
