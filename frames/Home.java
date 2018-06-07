package frames;

import domain.RunningImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame{
    
    RunningImage runImage = new RunningImage();
    int [][] matrizOfWall;
    BufferedImage bufferedCharacters1,bufferedCharacters2,bufferedCharacters3,bufferedCharacters4;
    BufferedImage door_exit,buffered_wall,candy;
    URL door = getClass().getResource("images/dor.png");
    URL wall = getClass().getResource("images/muro.png");
    String speed1;
    String speed2;
    String speed3;
    String speed4;
    static int exit = 8;
    String cantidad="";
    boolean eatCandy = true;
    
    public Home() throws FileNotFoundException, IOException {
        
        initComponents(); 
        this.setLocationRelativeTo(null);
        btn_ChargedAnimation.setEnabled(false);
        btn_ChargedMaze.setEnabled(false);
        btn_Start.setEnabled(false);
        cbx_NumberBugs.setEnabled(false);
        File file5= new File("./src/icons/candy.png");
        candy = ImageIO.read(file5);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pn_Options = new javax.swing.JPanel();
        lb_chronometer = new javax.swing.JLabel();
        lb_TitleUploadBugs = new javax.swing.JLabel();
        lb_chronometer_title = new javax.swing.JLabel();
        btn_Start = new javax.swing.JButton();
        btn_Restart = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btn_ChargedAnimation = new javax.swing.JButton();
        cbx_NumberBugs = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        cb_Level = new javax.swing.JComboBox<>();
        btn_ChargedMaze = new javax.swing.JButton();
        btn_Music = new javax.swing.JButton();
        lb_win1 = new javax.swing.JLabel();
        lb_win2 = new javax.swing.JLabel();
        lb_win3 = new javax.swing.JLabel();
        lb_win4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        item_exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1350, 750));
        setMinimumSize(new java.awt.Dimension(1350, 750));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1350, 750));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pn_Options.setBackground(new java.awt.Color(0, 102, 102));

        lb_chronometer.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lb_chronometer.setForeground(new java.awt.Color(255, 255, 255));
        lb_chronometer.setText("min : 0 sec : 0");
        lb_chronometer.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        lb_TitleUploadBugs.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lb_TitleUploadBugs.setForeground(new java.awt.Color(255, 255, 255));
        lb_TitleUploadBugs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pacman.png"))); // NOI18N
        lb_TitleUploadBugs.setText("Upload  Bugs");

        lb_chronometer_title.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lb_chronometer_title.setForeground(new java.awt.Color(255, 255, 255));
        lb_chronometer_title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/timer.png"))); // NOI18N
        lb_chronometer_title.setText("Chronometer");

        btn_Start.setBackground(new java.awt.Color(204, 204, 255));
        btn_Start.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btn_Start.setForeground(new java.awt.Color(255, 255, 255));
        btn_Start.setText("Start");
        btn_Start.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StartActionPerformed(evt);
            }
        });

        btn_Restart.setBackground(new java.awt.Color(204, 204, 255));
        btn_Restart.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btn_Restart.setForeground(new java.awt.Color(255, 255, 255));
        btn_Restart.setText("Restart");
        btn_Restart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RestartActionPerformed(evt);
            }
        });

        btn_ChargedAnimation.setBackground(new java.awt.Color(204, 204, 255));
        btn_ChargedAnimation.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btn_ChargedAnimation.setForeground(new java.awt.Color(255, 255, 255));
        btn_ChargedAnimation.setText("Cargar Bichos");
        btn_ChargedAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChargedAnimationActionPerformed(evt);
            }
        });

        cbx_NumberBugs.setBackground(new java.awt.Color(204, 204, 255));
        cbx_NumberBugs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cbx_NumberBugs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_NumberBugsActionPerformed(evt);
            }
        });

        cb_Level.setBackground(new java.awt.Color(204, 204, 255));
        cb_Level.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        cb_Level.setForeground(new java.awt.Color(255, 255, 255));
        cb_Level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Easy", "Medium", "Hard" }));
        cb_Level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LevelActionPerformed(evt);
            }
        });

        btn_ChargedMaze.setBackground(new java.awt.Color(204, 204, 255));
        btn_ChargedMaze.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btn_ChargedMaze.setForeground(new java.awt.Color(255, 255, 255));
        btn_ChargedMaze.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maze.png"))); // NOI18N
        btn_ChargedMaze.setText("Charge Maze");
        btn_ChargedMaze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChargedMazeActionPerformed(evt);
            }
        });

        btn_Music.setBackground(new java.awt.Color(204, 204, 255));
        btn_Music.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btn_Music.setForeground(new java.awt.Color(255, 255, 255));
        btn_Music.setText("Items");
        btn_Music.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MusicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_OptionsLayout = new javax.swing.GroupLayout(pn_Options);
        pn_Options.setLayout(pn_OptionsLayout);
        pn_OptionsLayout.setHorizontalGroup(
            pn_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_OptionsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pn_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_OptionsLayout.createSequentialGroup()
                        .addGroup(pn_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_ChargedMaze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_Level, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_OptionsLayout.createSequentialGroup()
                        .addComponent(lb_chronometer_title, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(pn_OptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_OptionsLayout.createSequentialGroup()
                        .addGap(0, 23, Short.MAX_VALUE)
                        .addGroup(pn_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_OptionsLayout.createSequentialGroup()
                                .addGroup(pn_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_Start, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_Restart)
                                    .addComponent(btn_Music, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_OptionsLayout.createSequentialGroup()
                                .addGroup(pn_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbx_NumberBugs, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_TitleUploadBugs)
                                    .addComponent(btn_ChargedAnimation))
                                .addGap(32, 32, 32))))
                    .addGroup(pn_OptionsLayout.createSequentialGroup()
                        .addComponent(lb_chronometer, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pn_OptionsLayout.setVerticalGroup(
            pn_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_OptionsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cb_Level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_ChargedMaze)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_chronometer_title)
                .addGap(33, 33, 33)
                .addComponent(lb_chronometer)
                .addGap(31, 31, 31)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_TitleUploadBugs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbx_NumberBugs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_ChargedAnimation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btn_Start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Restart)
                .addGap(18, 18, 18)
                .addComponent(btn_Music)
                .addGap(29, 29, 29))
        );

        lb_win1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lb_win1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        lb_win2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lb_win2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        lb_win3.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lb_win3.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        lb_win4.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lb_win4.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_win1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lb_win2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(lb_win3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lb_win4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 766, Short.MAX_VALUE)
                .addComponent(pn_Options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_Options, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lb_win1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_win2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_win3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_win4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu2.setBackground(new java.awt.Color(255, 255, 255));
        jMenu2.setForeground(new java.awt.Color(0, 102, 102));
        jMenu2.setText("       System         ");

        item_exit.setBackground(new java.awt.Color(0, 102, 102));
        item_exit.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        item_exit.setForeground(new java.awt.Color(255, 255, 255));
        item_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-out-option.png"))); // NOI18N
        item_exit.setText("Exit");
        item_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        item_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_exitActionPerformed(evt);
            }
        });
        jMenu2.add(item_exit);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ChargedAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChargedAnimationActionPerformed
        cbx_NumberBugs.setEnabled(false);
        btn_ChargedAnimation.setEnabled(false);
        btn_Start.setEnabled(true);
        Graphics g= this.getGraphics();
        int numBug = Integer.parseInt((String) cbx_NumberBugs.getSelectedItem());
                     
        File file1= new File("./src/icons/bug1.png");
        File file2= new File("./src/icons/bug2.png");
        File file3= new File("./src/icons/bug3.png");
        File file4= new File("./src/icons/bug4.png");
        
        try {
            bufferedCharacters1 = ImageIO.read(file1);
            bufferedCharacters2 = ImageIO.read(file2);
            bufferedCharacters3 = ImageIO.read(file3);
            bufferedCharacters4 = ImageIO.read(file4);
            
            
            if(cbx_NumberBugs.getSelectedIndex()==0){
               speed1= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
               while(!speed1.equals("1") &&!speed1.equals("2")&&!speed1.equals("3")){
                    speed1= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                }
                if(cb_Level.getSelectedIndex()== 0){
                    g.drawImage(bufferedCharacters1, 250, 510, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 1){
                    g.drawImage(bufferedCharacters1, 250, 510, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 2){
                    g.drawImage(bufferedCharacters1, 150, 510, 30, 30, this);
                }
            }
            
            else if(cbx_NumberBugs.getSelectedIndex()==1){
               speed1= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
               while(!speed1.equals("1") &&!speed1.equals("2")&&!speed1.equals("3")){
                    speed1= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                }
               if(cb_Level.getSelectedIndex()== 0){
                    g.drawImage(bufferedCharacters1, 250, 510, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 1){
                    g.drawImage(bufferedCharacters1, 250, 510, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 2){
                    g.drawImage(bufferedCharacters1, 150, 510, 30, 30, this);
                }
                
               speed2= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
               while(!speed2.equals("1") &&!speed2.equals("2")&&!speed2.equals("3")){
                    speed2= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                }
               
                if(cb_Level.getSelectedIndex()== 0){
                    g.drawImage(bufferedCharacters2, 250, 460, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 1){
                    g.drawImage(bufferedCharacters2, 250, 460, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 2){
                    g.drawImage(bufferedCharacters2, 150, 460, 30, 30, this);
                }
            }
            
            else if(cbx_NumberBugs.getSelectedIndex()==2){
                speed1= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
               while(!speed1.equals("1") &&!speed1.equals("2")&&!speed1.equals("3")){
                    speed1= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                }
               if(cb_Level.getSelectedIndex()== 0){
                    g.drawImage(bufferedCharacters1, 250, 510, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 1){
                    g.drawImage(bufferedCharacters1, 250, 510, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 2){
                    g.drawImage(bufferedCharacters1, 150, 510, 30, 30, this);
                }
               
               speed2= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
               while(!speed2.equals("1") &&!speed2.equals("2")&&!speed2.equals("3")){
                    speed2= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                }
               
               if(cb_Level.getSelectedIndex()== 0){
                    g.drawImage(bufferedCharacters2, 250, 460, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 1){
                    g.drawImage(bufferedCharacters2, 250, 460, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 2){
                    g.drawImage(bufferedCharacters2, 150, 460, 30, 30, this);
                }
            
               
               speed3= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
               while(!speed3.equals("1") &&!speed3.equals("2")&&!speed3.equals("3")){
                    speed3= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                }
                if(cb_Level.getSelectedIndex()== 0){
                    g.drawImage(bufferedCharacters3, 250, 310, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 1){
                    g.drawImage(bufferedCharacters3, 250, 310, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 2){
                    g.drawImage(bufferedCharacters3, 150, 310, 30, 30, this);
                }
            }
            
            else{
                speed1= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                while(!speed1.equals("1") &&!speed1.equals("2")&&!speed1.equals("3")){
                    speed1= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                }
               if(cb_Level.getSelectedIndex()== 0){
                    g.drawImage(bufferedCharacters1, 250, 510, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 1){
                    g.drawImage(bufferedCharacters1, 250, 510, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 2){
                    g.drawImage(bufferedCharacters1, 150, 510, 30, 30, this);
                }
               speed2= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
               while(!speed2.equals("1") &&!speed2.equals("2")&&!speed2.equals("3")){
                    speed2= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                }
               
               if(cb_Level.getSelectedIndex()== 0){
                    g.drawImage(bufferedCharacters2, 250, 460, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 1){
                    g.drawImage(bufferedCharacters2, 250, 460, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 2){
                    g.drawImage(bufferedCharacters2, 150, 460, 30, 30, this);
                }
               
               speed3= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
               while(!speed3.equals("1") &&!speed3.equals("2")&&!speed3.equals("3")){
                    speed3= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                }
                if(cb_Level.getSelectedIndex()== 0){
                    g.drawImage(bufferedCharacters3, 250, 310, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 1){
                    g.drawImage(bufferedCharacters3, 250, 310, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 2){
                    g.drawImage(bufferedCharacters3, 150, 310, 30, 30, this);
                }
                
                speed4= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
               while(!speed4.equals("1") &&!speed4.equals("2")&&!speed4.equals("3")){
                    speed4= JOptionPane.showInputDialog("Enter 1 for the modality faste"+"\nEnter 2 for the modality Furios"+"\nEnter 3 for the modality Smart");
                }
                if(cb_Level.getSelectedIndex()== 0){
                    g.drawImage(bufferedCharacters4, 250, 260, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 1){
                    g.drawImage(bufferedCharacters4, 250, 260, 30, 30, this);
                }else if(cb_Level.getSelectedIndex()== 2){
                    g.drawImage(bufferedCharacters4, 150, 260, 30, 30, this);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }         
         
    }//GEN-LAST:event_btn_ChargedAnimationActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //obtiene el las coordenadas del mouse 
        int x=evt.getX();
        int y= evt.getY();
        Graphics g= this.getGraphics();
        
        int moveColum=0;
        int moveFil=0;
        //bloques
        int xInit=0;
        int xEnd=0;
        int yInit=0;
        int yEnd=0;
        
        if (cb_Level.getSelectedIndex()==0) {
            xInit=300;
            xEnd=800;
            yInit=150;
            yEnd=650;
            
        } else if (cb_Level.getSelectedIndex()==1) {
            xInit=300;
            xEnd=1000;
            yInit=150;
            yEnd=650;
            
        }else if (cb_Level.getSelectedIndex()==2) {
            xInit=200;
            xEnd=1100;
            yInit=150;
            yEnd=700;
            
        }// fin del else if 
        
        //lee la imagen 
        try{
            buffered_wall = ImageIO.read(wall);
        }catch(Exception e){
            System.out.println("The image is not charged : "+e.getMessage());
        }
                
        
        for (int i = yInit; i <yEnd; i+=50) {
            if (y>i && y<i+50){
            for (int j = xInit; j < xEnd; j+=50) {
                
                    if (x>j && x<j+50) {
                        if (matrizOfWall[moveFil][moveColum]==1) {
                            
                            g.clearRect(j, i, 50, 50);
                            g.setColor(Color.BLACK);
                            g.drawRect(j, i, 50, 50);
                            matrizOfWall[moveFil][moveColum]=0;
                            //System.out.println("Guardo esto"+moveRects[moveFil][moveColum]);
                        }else{
                            g.drawImage(buffered_wall, j, i, 50, 50, this);
                            matrizOfWall[moveFil][moveColum]=1;
                        }// fin del else 
                    }// fin del if
                moveColum++;
            }// fin del for
                
            }// fin del if 
            moveFil++;
        }//fin del for
    }//GEN-LAST:event_formMouseClicked
    
    public synchronized void sincronised1() {
        Graphics g=this.getGraphics();
        RunningImage runImage = new RunningImage();
        runImage.runImage1(g, bufferedCharacters1, matrizOfWall, Integer.parseInt(speed1), lb_win1, lb_win2, lb_win3, lb_win4, cb_Level);
        runImage.runImage2(g, bufferedCharacters2, matrizOfWall, Integer.parseInt(speed2), lb_win1, lb_win2, lb_win3, lb_win4, cb_Level);
        runImage.chronometer(lb_chronometer);
    }
       
    private void btn_ChargedMazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChargedMazeActionPerformed
        cbx_NumberBugs.setEnabled(true);
        cb_Level.setEnabled(false);
        btn_ChargedMaze.setEnabled(false);
        btn_Music.setEnabled(false);
        // Matriz por defecto      
        int matrixSmall[][]={
                       {1,1,1,1,1,1,1,1,1,1},
                       {1,0,1,0,0,0,1,0,exit,1},
                       {0,0,0,0,1,0,0,1,0,1},
                       {0,0,1,1,0,0,0,0,0,1},
                       {1,0,0,1,0,1,1,0,0,1},
                       {1,0,1,0,0,0,1,0,0,1},
                       {0,0,1,0,1,0,1,0,0,1},
                       {0,0,1,0,1,0,1,0,0,1},
                       {1,0,0,0,1,0,1,0,0,1},
                       {1,1,1,1,1,1,1,1,1,1}
                       };
        
        int matrixMedium [][]={
                       {1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                       {1,1,1,1,0,0,0,0,0,1,0,0,0,1},
                       {0,0,0,0,0,1,1,0,0,1,0,1,0,1},
                       {0,0,1,0,0,0,0,1,0,1,0,1,0,1},
                       {1,0,1,0,1,1,0,1,0,0,0,1,0,1},
                       {1,0,1,0,1,1,0,1,1,1,1,1,0,1},
                       {0,0,1,0,1,1,0,0,1,0,0,0,0,1},
                       {0,0,0,0,0,1,0,0,0,0,1,0,0,1},
                       {1,1,1,0,1,1,0,0,1,0,1,0,exit,1},
                       {1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                       };
        
        int matrixBig [][]={
                       {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                       {1,0,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,1},
                       {0,0,0,0,1,1,1,0,0,1,0,1,0,1,1,0,0,1},
                       {0,0,1,0,0,0,0,1,0,1,0,1,0,0,0,0,exit,1},
                       {1,0,1,0,1,1,0,1,0,0,0,1,0,1,1,0,1,1},
                       {1,0,1,0,1,1,0,1,1,1,1,1,0,1,1,0,1,1},
                       {0,0,1,0,1,1,0,0,1,0,0,0,0,0,0,1,1,1},
                       {0,0,0,0,0,1,0,0,1,0,1,0,1,1,0,0,0,1},
                       {1,1,1,0,1,1,0,0,1,0,1,0,1,1,0,1,1,1},
                       {0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,exit,1},
                       {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                       };
        //lee la imagen 
        try{
            buffered_wall = ImageIO.read(wall);
            door_exit = ImageIO.read(door);
        }catch(Exception e){
            System.out.println("The image is not charged : "+e.getMessage());
        }
        
        Graphics g = this.getGraphics();
        g.setColor(Color.BLACK);
        int moveXcandy=160;
        int moveYcandy=610;
        
        try {
       
        switch (cb_Level.getSelectedIndex()) {
            case 0:
                {
                    int fil=0;
                    int col=0;
                    //horizontales
                    matrizOfWall=matrixSmall;
                    for (int y = 150; y < 650; y+=50) {
                        for (int x = 300; x < 800; x+=50) {
                            if(matrizOfWall[fil][col]==1)
                                g.drawImage(buffered_wall, x, y, 50, 50, this);
                            else if(matrizOfWall[fil][col]==0)
                                g.drawRect(x, y, 50, 50);
                            else if (matrizOfWall[fil][col]==exit) 
                                g.drawImage(door_exit, x, y, 50, 50, this);
                            col++;
                        }// fin del for
                        col=0;
                        fil++;
                    }// fin del for 
                    if(cantidad.equals("1")){
                        g.drawImage(candy, moveYcandy-50,moveXcandy , this);
                        g.clearRect(moveYcandy, moveXcandy, 30, 30);
                        g.drawImage(candy, moveYcandy+50,moveXcandy , this);
                        g.clearRect(moveYcandy, moveXcandy, 30, 30);

                    }else if(cantidad.equals("2")){
                       g.drawImage(candy, moveYcandy,moveXcandy , this);
                       g.drawImage(candy, moveYcandy,moveXcandy+100 , this); 
                    }else if(cantidad.equals("3")){
                       g.drawImage(candy, moveYcandy,moveXcandy , this);
                       g.drawImage(candy, moveYcandy,moveXcandy+100 , this);
                       g.drawImage(candy, moveYcandy-50,moveXcandy+150 , this);
                    }else if(cantidad.equals("4")){
                       g.drawImage(candy, moveYcandy,moveXcandy , this);
                       g.drawImage(candy, moveYcandy,moveXcandy+100 , this);
                       g.drawImage(candy, moveYcandy-50,moveXcandy+450 , this);
                       g.drawImage(candy, moveYcandy-250,moveXcandy , this);
                    }
                    break;
                }// fin del caso 0
            case 1:
                {
                    int fil=0;
                    int col=0;
                    matrizOfWall=matrixMedium;
                    for (int y = 150; y < 650; y+=50) {
                        for (int x = 300; x < 1000; x+=50) {
                            if(matrizOfWall[fil][col]==1)
                                g.drawImage(buffered_wall, x, y, 50, 50, this);
                            else if(matrizOfWall[fil][col]==0)
                                g.drawRect(x, y, 50, 50);
                            else if (matrizOfWall[fil][col]==exit) 
                                g.drawImage(door_exit, x, y, 50, 50, this);
                            col++;
                        }// fin del for
                        col=0;
                        fil++;
                    }// fin del for 
                    if(cantidad.equals("1")){
                        g.drawImage(candy, moveYcandy+300,moveXcandy , this);
                    }else if(cantidad.equals("2")){
                       g.drawImage(candy, moveYcandy+300,moveXcandy , this);
                       g.drawImage(candy, moveYcandy+50,moveXcandy+100 , this);
                    }else if(cantidad.equals("3")){
                       g.drawImage(candy, moveYcandy+300,moveXcandy , this);
                       g.drawImage(candy, moveYcandy+50,moveXcandy+100 , this);
                       g.drawImage(candy, moveYcandy,moveXcandy+450 , this);
                    }else if(cantidad.equals("4")){
                       g.drawImage(candy, moveYcandy+300,moveXcandy , this);
                       g.drawImage(candy, moveYcandy+50,moveXcandy+100 , this);
                       g.drawImage(candy, moveYcandy,moveXcandy+450 , this);
                       g.drawImage(candy, moveYcandy-250,moveXcandy , this);
                    }
                    break;
                }// fin del caso 1
            case 2:
                {
                    int fil=0;
                    int col=0;
                    matrizOfWall=matrixBig;
                    for (int y = 150; y < 700; y+=50) {
                        for (int x = 200; x < 1100; x+=50) {
                            if(matrizOfWall[fil][col]==1)
                                g.drawImage(buffered_wall, x, y, 50, 50, this);
                            else if(matrizOfWall[fil][col]==0)
                                g.drawRect(x, y, 50, 50);
                            else if (matrizOfWall[fil][col]==exit) 
                                g.drawImage(door_exit, x, y, 50, 50, this);
                            col++;
                        }// fin del for
                        col=0;
                        fil++;
                    }// fin del for 
                    if(cantidad.equals("1")){
                       g.drawImage(candy, moveYcandy+200,moveXcandy , this);
                    }else if(cantidad.equals("2")){
                       g.drawImage(candy, moveYcandy+200,moveXcandy , this);
                       g.drawImage(candy, moveYcandy,moveXcandy+100 , this);
                    }else if(cantidad.equals("3")){
                      g.drawImage(candy, moveYcandy+200,moveXcandy , this);
                       g.drawImage(candy, moveYcandy,moveXcandy+100 , this);
                       g.drawImage(candy, moveYcandy-50,moveXcandy+500 , this);
                    }else if(cantidad.equals("4")){
                       g.drawImage(candy, moveYcandy+200,moveXcandy , this);
                       g.drawImage(candy, moveYcandy,moveXcandy+100 , this);
                       g.drawImage(candy, moveYcandy-50,moveXcandy+500 , this);
                       g.drawImage(candy, moveYcandy-350,moveXcandy , this);
                    }
                    break;
                } // fin del caso 2
            default:
                break;
        }// fin del switch
        }catch(NullPointerException npe){}
        catch(NumberFormatException nfe){}

    }//GEN-LAST:event_btn_ChargedMazeActionPerformed
    
    private void cb_LevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LevelActionPerformed
        // limpia la ventana 
        repaint();
        btn_ChargedMaze.setEnabled(true);
    }//GEN-LAST:event_cb_LevelActionPerformed

    private void btn_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StartActionPerformed
        Graphics g=this.getGraphics();
        
        cb_Level.setEnabled(false);
        btn_ChargedMaze.setEnabled(false);
        cbx_NumberBugs.setEnabled(false);
        btn_ChargedAnimation.setEnabled(false);
        btn_Start.setEnabled(false);
        if(cbx_NumberBugs.getSelectedIndex()==0){
             runImage.runImage1(g, bufferedCharacters1, matrizOfWall, PROPERTIES, lb_win1, lb_win2, lb_win3, lb_win4,cb_Level);
//             runImage.runImage1(g, bufferedCharacters1, matrizOfWall,Integer.parseInt(speed1));
             runImage.chronometer(lb_chronometer);
        }else if(cbx_NumberBugs.getSelectedIndex()==1){
            sincronised1();
        } 
    }//GEN-LAST:event_btn_StartActionPerformed

    private void btn_RestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RestartActionPerformed

          Home h;
        try {
            h = new Home();
            h.setVisible(true);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
          

    }//GEN-LAST:event_btn_RestartActionPerformed

    private void cbx_NumberBugsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_NumberBugsActionPerformed
        btn_ChargedAnimation.setEnabled(true);
    }//GEN-LAST:event_cbx_NumberBugsActionPerformed

    private void item_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_item_exitActionPerformed

    private void btn_MusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MusicActionPerformed

        try{
            while(!cantidad.equals("1") && !cantidad.equals("2") && !cantidad.equals("3") && !cantidad.equals("4")){
                cantidad = JOptionPane.showInputDialog("Enter the numbers of items, do not exceed more than 4 items");
            }
        }catch(NullPointerException | NumberFormatException npe){

        }

    }//GEN-LAST:event_btn_MusicActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChargedAnimation;
    private javax.swing.JButton btn_ChargedMaze;
    private javax.swing.JButton btn_Music;
    private javax.swing.JButton btn_Restart;
    private javax.swing.JButton btn_Start;
    private javax.swing.JComboBox<String> cb_Level;
    private javax.swing.JComboBox<String> cbx_NumberBugs;
    private javax.swing.JMenuItem item_exit;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lb_TitleUploadBugs;
    private javax.swing.JLabel lb_chronometer;
    private javax.swing.JLabel lb_chronometer_title;
    private javax.swing.JLabel lb_win1;
    private javax.swing.JLabel lb_win2;
    private javax.swing.JLabel lb_win3;
    private javax.swing.JLabel lb_win4;
    private javax.swing.JPanel pn_Options;
    // End of variables declaration//GEN-END:variables

}