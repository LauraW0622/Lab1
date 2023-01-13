// Laura Wilson and Neha Pandit
// Sweng 431 - Lab1
// Test Recording - https://psu.zoom.us/rec/share/7eJvN2vsbDOBrm7LcKRWkR1iCR11B93ghoIY_exFEo8CWpacJlPkI-NdO7peusav.bFHH5LOOt7TuicVI?startTime=1673568176000


import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class NameAgeChecker extends javax.swing.JFrame {
    boolean validateName = false;
    boolean validateAge = false;
    String Name;
    int Age;

    public NameAgeChecker()
    {
        initComponents();
        InputVerifier iv = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField nameText = (JTextField) input;
                if (nameText.getText().indexOf(0) > -1) return false;
                else return true;
            }
        };
        InputVerifier iv2 = new InputVerifier() {
            @Override
            public boolean verify(JComponent jc) {
                JTextField ageInt = (JTextField) jc;
                if (ageInt.getText().indexOf(0) > -1) return false;
                else return false;
            }
        };
        nameField.setInputVerifier(iv); // verify Name textfield input
        ageField.setInputVerifier(iv2); // verify Age textfield input
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        valBtn = new javax.swing.JButton();
        valText = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Name: ");
        nameField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nameField.setPreferredSize(new java.awt.Dimension(100, 24));
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });
        jLabel2.setText("Age: ");
        ageField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ageField.setPreferredSize(new java.awt.Dimension(100, 24));
        ageField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ageFieldKeyReleased(evt);
            }
        });
        valBtn.setText("Validate");
        valBtn.setEnabled(false);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                              .addGap(110)
                                                                              .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                                                                                .addComponent(jLabel1)
                                                                                                .addComponent(jLabel2))
                                                                              .addGap(33)
                                                                              .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                                                                                .addComponent(ageField,
                                                                                                              GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                                                                                .addComponent(nameField,
                                                                                                              GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                              .addGap(45)
                                                                              .addComponent(valText)))
                                          .addGap(35))
                        .addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(168)
                                .addComponent(valBtn, GroupLayout.PREFERRED_SIZE, 114,
                                              GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addGap(53)
                                          .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(jLabel1)
                                                            .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 31,
                                                                          GroupLayout.PREFERRED_SIZE))
                                          .addGap(18)
                                          .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(ageField, GroupLayout.PREFERRED_SIZE, 31,
                                                                          GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel2))
                                          .addGap(18)
                                          .addComponent(valBtn, GroupLayout.PREFERRED_SIZE, 32,
                                                        GroupLayout.PREFERRED_SIZE)
                                          .addGap(9)
                                          .addComponent(valText)
                                          .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                      javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                      javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {
        //GEN-FIRST:event_nameFieldKeyReleased
// get Name if field not empty
        if (!nameField.getText().isEmpty()) {
            Name = nameField.getText(); // get Name from user
            validateName = checkName(Name); // redeclare validateName as true/false
// if-else to enable or disable button
            if (validateName == true && validateAge == true) {
                valBtn.setEnabled(true);
            } else valBtn.setEnabled(false);
        }
// if Name field empty, disable button, and set text back to empty
        if (nameField.getText().isEmpty()) {
            Name = nameField.getText();
            validateName = false;
            valBtn.setEnabled(false);
            valText.setText("");
        }
    }//GEN-LAST:event_nameFieldKeyReleased

    private void ageFieldKeyReleased(java.awt.event.KeyEvent evt) {
        //GEN-FIRST:event_ageFieldKeyReleased
// get Age if field not empty
        if (!ageField.getText().isEmpty()) {
            Age = Integer.parseInt(ageField.getText()); // get Age from user input
            validateAge = checkAge(Age); // redeclare validateAge as true/false
// if-else to enable or disable button
            if (validateName == true && validateAge == true) {
                valBtn.setEnabled(true);
            } else valBtn.setEnabled(false);
        }
// if field becomes empty, disable button, and set text back to empty
        if (ageField.getText().isEmpty()) {
            Age = Integer.parseInt(ageField.getText());
            validateAge = false;
            valBtn.setEnabled(false);
            valText.setText("");
        }
    }//GEN-LAST:event_ageFieldKeyReleased

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NameAgeChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NameAgeChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NameAgeChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NameAgeChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NameAgeChecker().setVisible(true);
            }
        });
    }

    public boolean checkName(String s) { // check if string contains Name characters only
        try {
            if (s.isEmpty() || s == "") { // warn user: need to enter Name first before Age
                return false;
//throw new Exception("NameException: Must enter Name first.");
            }
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if (Character.isDigit(c))
                {
                    throw new Exception("Name Exception: Name contains digits");
                }
            }

            String specialregexPattern = "^[A-Za-z,-]*$";
            boolean hasSpecialChar = isValidName(s, specialregexPattern);
            if (hasSpecialChar == false) //contains special char, show error
                throw new Exception("NameException: Contains special character");

            if (s.length() >= 15)
            {
                throw new Exception("NameException: Too many characters");
            }
            else
            {
                valText.setText(""); // remove text on GUI if good
                return true;
            }

            
        } catch (Exception nameException) {
//System.out.println(NameException);
            valText.setText(nameException.getMessage()); // print msg to GUI
            return false;
        }
    }

    public boolean checkAge(int i) {
        try {

            String regex = "^[0-9]*$";
            boolean validAge = isValidAge(String.valueOf(i), regex);
            if (validAge == false) { // not digits, show error
                throw new Exception("AgeException: Invalid Age...");
            }
            if(i <= 0 || i >= 100)
                throw new Exception("Age Exception: Invalid age");
            else
            {
                valText.setText(""); // remove text on GUI if good
                return true;
            }
        } catch (Exception AgeException) {
//System.out.println(AgeException);
            valText.setText(AgeException.getMessage()); // print msg to GUI
            return false;
        }
    }

    public static boolean isValidAge(CharSequence c, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(c);
        return matcher.matches();
    }

    public static boolean isValidName(String S, String regexpatern) {
        Pattern pattern = Pattern.compile(regexpatern);
        Matcher matcher = pattern.matcher(S);
        return matcher.matches();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton valBtn;
    private javax.swing.JLabel valText;
// End of variables declaration//GEN-END:variables
}

