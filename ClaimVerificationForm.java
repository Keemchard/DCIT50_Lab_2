package dcit50.gui;

import java.awt.*;
import javax.swing.*;

public class ClaimVerificationForm extends JFrame {

    // My own sample values (not 2026-001 / LAB123)
    private final String expectedReference = "CLM-4821";
    private final String expectedClaimCode = "PICKUP77";
    private int claimAttemptsLeft = 3;

    private JLabel lblKioskTitle, lblReference, lblClaimCode, lblResult, lblTriesText, lblTries;
    private JTextField txtReference;
    private JPasswordField pwdClaimCode;
    private JButton btnCheck, btnReset;

    public ClaimVerificationForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Claim Verification Kiosk");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 10, 8, 10);
        c.anchor = GridBagConstraints.WEST;

        lblKioskTitle = new JLabel("CLAIM VERIFICATION KIOSK");
        lblKioskTitle.setFont(lblKioskTitle.getFont().deriveFont(Font.BOLD, 18f));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        add(lblKioskTitle, c);

        c.gridwidth = 1;
        lblReference = new JLabel("Reference No.:");
        c.gridy = 1; add(lblReference, c);
        txtReference = new JTextField(15);
        c.gridx = 1; add(txtReference, c);

        lblClaimCode = new JLabel("Claim Code:");
        c.gridx = 0; c.gridy = 2; add(lblClaimCode, c);
        pwdClaimCode = new JPasswordField(15);
        c.gridx = 1; add(pwdClaimCode, c);

        btnCheck = new JButton("CHECK");
        btnReset = new JButton("RESET");
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttons.add(btnCheck);
        buttons.add(btnReset);
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        add(buttons, c);

        lblResult = new JLabel("Result appears here");
        c.gridy = 4; add(lblResult, c);

        lblTriesText = new JLabel("Attempts Remaining:");
        lblTries = new JLabel("3");
        JPanel tries = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tries.add(lblTriesText);
        tries.add(lblTries);
        c.gridy = 5; add(tries, c);

        btnCheck.addActionListener(evt -> btnCheckActionPerformed(evt));
        btnReset.addActionListener(evt -> btnResetActionPerformed(evt));

        pack();
        setLocationRelativeTo(null);
    }

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {
        String reference = txtReference.getText();
        String claimCode = new String(pwdClaimCode.getPassword());

        // Blank input is rejected first and costs no attempt
        if (reference.isBlank() || claimCode.isBlank()) {
            lblResult.setText("Enter both Reference No. and Claim Code.");
            return;
        }

        boolean referenceMatches = reference.equals(expectedReference);
        boolean claimMatches = claimCode.equals(expectedClaimCode);

        if (referenceMatches && claimMatches) {
            lblResult.setText("Claim verified.");
        } else {
            claimAttemptsLeft--;
            lblTries.setText(String.valueOf(claimAttemptsLeft));
            if (claimAttemptsLeft <= 0) {
                lblResult.setText("Locked. No attempts remaining.");
                btnCheck.setEnabled(false);
            } else {
                lblResult.setText("Claim not verified. Attempts remaining: " + claimAttemptsLeft);
            }
        }
    }

    // Reset clears inputs only; attempts are NOT restored
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        txtReference.setText("");
        pwdClaimCode.setText("");
        lblResult.setText("Result appears here");
        txtReference.requestFocus();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new ClaimVerificationForm().setVisible(true));
    }
}
