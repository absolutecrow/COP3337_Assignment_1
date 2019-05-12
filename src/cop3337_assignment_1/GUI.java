/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop3337_assignment_1;

import java.util.Arrays;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author AbsoluteCrow
 */
public class GUI extends javax.swing.JFrame {

    Admissions admissions = new Admissions();
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }    
    
    //Change the text of the scrollpane
    private void modifyText()
    {
        outputDisplay.setText(stringFormatter());
    }
    
    //Create a the string in the necessary format to print out to the screen.
    private String stringFormatter()
    {
        StringBuilder string = new StringBuilder();
        
        string.append("CURRENTLY ENROLLED\n");
        for (int i = 0; i < admissions.sizeOfRecords(); i++)
        {
            string.append("Id number:  " + admissions.getRecords().get(i).getIDnumber() + "\n");
            string.append("Name:       " + admissions.getRecords().get(i).name.getLastName() + ", " + admissions.getRecords().get(i).name.getFirstName() + "\n");
            string.append("Address:    " + admissions.getRecords().get(i).address.getStreet() + "\n");
            string.append("            " + admissions.getRecords().get(i).address.getCity() + ", " + admissions.getRecords().get(i).address.getState() + " " + admissions.getRecords().get(i).address.getZipcode() + "\n");
            string.append("Date:       " + dateMonthChanger(admissions.getRecords().get(i).date.getMonth()) + " " + admissions.getRecords().get(i).date.getDate() + ", " + admissions.getRecords().get(i).date.getYear() + "\n");
            string.append("Courses:    ");
            
            //A second loop used to obtain the courses and prepare them with the proper format for output.
            for (int k = 0; k < admissions.getRecords().get(i).getCourses().size(); k++)
            {
                if (k != admissions.getRecords().get(i).getCourses().size() - 1)
                {
                    string.append(admissions.getRecords().get(i).getCourses().get(k) + ", ");
                }
                else
                {
                    string.append(admissions.getRecords().get(i).getCourses().get(k));
                }
            }
            string.append("\n\n");
        }
        
        string.append("STUDENT WHO WERE DROPPED\n");
        for (int i = 0; i < admissions.sizeOfDroppedRecords(); i++)
        {
            string.append("Id number:  " + admissions.getDroppedStudents().get(i).getIDnumber() + "\n");
            string.append("Name:       " + admissions.getDroppedStudents().get(i).name.getLastName() + ", " + admissions.getDroppedStudents().get(i).name.getFirstName() + "\n");
            string.append("Date:       " + dateMonthChanger(admissions.getDroppedStudents().get(i).date.getMonth()) + " " + admissions.getDroppedStudents().get(i).date.getDate() + ", " 
                                         + admissions.getDroppedStudents().get(i).date.getYear() + "\n");
            
            string.append("\n");
        }

        return string.toString();
    }
    
    //Changing the built-in date month to proper names.
    private String dateMonthChanger(int month)
    {
        switch (month)
        {
            case 0: return "January";
            case 1: return "February";
            case 2: return "March";
            case 3: return "April";
            case 4: return "May";
            case 5: return "June";
            case 6: return "July";
            case 7: return "August";
            case 8: return "September";
            case 9: return "October";
            case 10: return "November";
            case 11: return "December";
        }
        return "Invalid month";
    }
    
    //Obtaining the text form the course text fields
    private String[] obtainCourses()
    {       
        String[] courses = new String[5];

        courses[0] = courseTextField1.getText();
        courses[1] = courseTextField2.getText();
        courses[2] = courseTextField3.getText();
        courses[3] = courseTextField4.getText();
        courses[4] = courseTextField5.getText();        
        
        return courses;
    }
    
    //A method used to extract numbers as an integer from a String formatted as ##/##/## or any variation of that such as #/#/##.
    //The for loop is used to search through the entire string. We count how many numbers we have found before a slash and store it in
    //the variable named "numbersBeforeSlash". Once we detect a "/" we take the substring from the current position minus
    //how many numbers we have found before the slash. We store that value as an integer into an int array to return back.
    private int[] extractDate(String formattedDate)
    {
        int[] dates = new int[3];
        int slashCounter = 0;
        int numbersBeforeSlash = 0;
        int j = 0;
        
        for (int i = 0; i < formattedDate.length(); i++)
        {
            if (formattedDate.charAt(i) == '/')
            {               
                dates[j++] = Integer.valueOf(formattedDate.substring(i-numbersBeforeSlash, i));               
                numbersBeforeSlash = 0;
                slashCounter++;
            }
            else if(slashCounter == 2)
            {
                dates[j] = Integer.valueOf(formattedDate.substring(formattedDate.length() - 4, formattedDate.length()));
            }
            else
            {
                numbersBeforeSlash++;
            }
        }        
        return dates;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modifyCourses = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        modifyCourseTextField = new javax.swing.JTextField();
        modifyAdd = new javax.swing.JButton();
        modifyRemove = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputDisplay = new javax.swing.JTextArea();
        idNumberTextField = new javax.swing.JTextField();
        idNumberLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        streetTextField = new javax.swing.JTextField();
        streetLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        stateLabel = new javax.swing.JLabel();
        stateTextField = new javax.swing.JTextField();
        zipTextField = new javax.swing.JTextField();
        zipLabel = new javax.swing.JLabel();
        addToRegistry = new javax.swing.JButton();
        courseLabel = new javax.swing.JLabel();
        courseTextField1 = new javax.swing.JTextField();
        courseTextField2 = new javax.swing.JTextField();
        courseTextField3 = new javax.swing.JTextField();
        courseTextField4 = new javax.swing.JTextField();
        courseTextField5 = new javax.swing.JTextField();
        dropStudentButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        dateTextField = new javax.swing.JFormattedTextField();
        modifyButton = new javax.swing.JButton();
        deleteStudentButton = new javax.swing.JButton();

        modifyCourses.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        modifyCourses.setTitle("Modify Student");
        modifyCourses.setResizable(false);
        modifyCourses.setSize(new java.awt.Dimension(300, 195));

        modifyAdd.setText("Add");
        modifyAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAddActionPerformed(evt);
            }
        });

        modifyRemove.setText("Remove");
        modifyRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyRemoveActionPerformed(evt);
            }
        });

        jLabel1.setText("Course:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(modifyCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(modifyAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modifyRemove)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyRemove)
                    .addComponent(modifyAdd))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout modifyCoursesLayout = new javax.swing.GroupLayout(modifyCourses.getContentPane());
        modifyCourses.getContentPane().setLayout(modifyCoursesLayout);
        modifyCoursesLayout.setHorizontalGroup(
            modifyCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        modifyCoursesLayout.setVerticalGroup(
            modifyCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        modifyCourses.pack();
        modifyCourses.setLocationRelativeTo(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Registry");
        setLocation(new java.awt.Point(0, 0));

        outputDisplay.setEditable(false);
        outputDisplay.setColumns(20);
        outputDisplay.setRows(5);
        jScrollPane1.setViewportView(outputDisplay);

        idNumberLabel.setText("ID Number:");

        lastNameLabel.setText("Last Name:");

        firstNameLabel.setText("First Name:");

        streetLabel.setText("Street:");

        cityLabel.setText("City:");

        stateLabel.setText("State:");

        stateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        zipTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        zipLabel.setText("ZIP Code:");

        addToRegistry.setText("Add to Registry");
        addToRegistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToRegistryActionPerformed(evt);
            }
        });

        courseLabel.setText("Courses:");

        courseTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        courseTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        courseTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        courseTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        courseTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        dropStudentButton.setText("Drop Student");
        dropStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropStudentButtonActionPerformed(evt);
            }
        });

        dateLabel.setText("Date:");

        dateTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("M/d/yyyy"))));
        dateTextField.setText("1/1/2019");
        dateTextField.setToolTipText("Must be in m/d/yy, i.e. 4/25/19 or 12/5/05");
        dateTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        dateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTextFieldActionPerformed(evt);
            }
        });

        modifyButton.setText("Modify Student");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        deleteStudentButton.setText("Delete Student");
        deleteStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lastNameLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(firstNameLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(streetLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(streetTextField))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cityLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(stateLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(stateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(zipLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(zipTextField)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(idNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dateLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(courseLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(courseTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(courseTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(courseTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(163, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(addToRegistry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dropStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modifyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(182, 182, 182)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idNumberLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameLabel)
                            .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(streetLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(zipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(zipLabel))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(stateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stateLabel))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cityLabel)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courseTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseLabel)
                            .addComponent(courseTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateLabel)
                            .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(addToRegistry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dropStudentButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modifyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteStudentButton)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Obtain the text from all the fields and placing them in the ArrayList
    private void addToRegistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToRegistryActionPerformed
        Student student = new Student();
        
        if (admissions.doesStudentExist(idNumberTextField.getText()) || idNumberTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "ID number is either taken or empty");
        }
        else
        {
            int[] dates = extractDate(dateTextField.getText());
        
            student.setIDnumber(idNumberTextField.getText());
            student.name.setFirstName(firstNameTextField.getText());
            student.name.setLastName(lastNameTextField.getText());
            student.address.setStreet(streetTextField.getText());
            student.address.setCity(cityTextField.getText());
            student.address.setState(stateTextField.getText());
            student.address.setZipcode(zipTextField.getText());
            student.date.setMonth(dates[0]-1);
            student.date.setDate(dates[1]);
            student.date.setYear(dates[2]);
            student.setCourses(obtainCourses());
            admissions.addStudent(student);
            modifyText();
        } 
    }//GEN-LAST:event_addToRegistryActionPerformed

    //Button to drop a student
    private void dropStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropStudentButtonActionPerformed
        Student student = new Student();
        
        student.setIDnumber(idNumberTextField.getText());
        admissions.dropStudent(student);
        modifyText();
    }//GEN-LAST:event_dropStudentButtonActionPerformed

    private void dateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTextFieldActionPerformed
    
    //Button to open the window to modify the classes of a student
    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        if (idNumberTextField.getText().isEmpty() || !(admissions.doesStudentExist(idNumberTextField.getText())))
        {
            JOptionPane.showMessageDialog(null, "ID number is empty or invalid");
        }
        else if (admissions.doesStudentExist(idNumberTextField.getText()))
        {
            modifyCourses.setVisible(true);
        }
        
    }//GEN-LAST:event_modifyButtonActionPerformed

    //Button to add a class to a student.
    private void modifyAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyAddActionPerformed
        int studentLocation = admissions.whatStudent(idNumberTextField.getText());   
        
        if (admissions.getRecords().get(studentLocation).getCourses().size() < 5)
        {
            admissions.getRecords().get(studentLocation).addCourse(modifyCourseTextField.getText());
            modifyText();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Cannot add more than 5 classes");
        }
    }//GEN-LAST:event_modifyAddActionPerformed

    //Button to drop a class from a student
    private void modifyRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyRemoveActionPerformed
        int studentLocation = admissions.whatStudent(idNumberTextField.getText());        
        admissions.getRecords().get(studentLocation).removeCourse(modifyCourseTextField.getText());
        modifyText();
    }//GEN-LAST:event_modifyRemoveActionPerformed

    //Delete student button
    private void deleteStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentButtonActionPerformed
        Student student = new Student();
        
        student.setIDnumber(idNumberTextField.getText());
        admissions.removeStudent(student);
        modifyText();
    }//GEN-LAST:event_deleteStudentButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToRegistry;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JTextField courseTextField1;
    private javax.swing.JTextField courseTextField2;
    private javax.swing.JTextField courseTextField3;
    private javax.swing.JTextField courseTextField4;
    private javax.swing.JTextField courseTextField5;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JFormattedTextField dateTextField;
    private javax.swing.JButton deleteStudentButton;
    private javax.swing.JButton dropStudentButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel idNumberLabel;
    private javax.swing.JTextField idNumberTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton modifyAdd;
    private javax.swing.JButton modifyButton;
    private javax.swing.JTextField modifyCourseTextField;
    private javax.swing.JDialog modifyCourses;
    private javax.swing.JButton modifyRemove;
    private static javax.swing.JTextArea outputDisplay;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JTextField stateTextField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JLabel zipLabel;
    private javax.swing.JTextField zipTextField;
    // End of variables declaration//GEN-END:variables
}
