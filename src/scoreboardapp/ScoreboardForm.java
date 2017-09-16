/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoreboardapp;



/**
 *
 * @author Zane Neuschuler <neuschuler@gmail.com>
 */
public class ScoreboardForm extends javax.swing.JFrame {
class GameEntry //use the linkedlist element class as a template
{
   private String      name;        
   private Integer      score;
   GameEntry     nextElement;      // Pointer to next element in the list


   
   // Default Constructor
   public GameEntry()
   {
      this.name = null;
      this.score = 0;
      this.nextElement = null;


   }
   
   // Constructor providing first and last name
   public GameEntry( String name, Integer score)
   {
      this.name = name;
      this.score = score;
      this.nextElement = null;


   }
   
   
   public String getName(){
       return name;
   }
   
   public Integer getScore(){
       return score;
   }
   
   public String toString()
   {
      return( this.name + " "  + this.score + "" );
   }
}//end of GameEntry class

class Scoreboard{
    private int numEntries;
    public int  maxEntries; 

    
    GameEntry firstNode = null;
  
public void setMaxEntries(int i){
    maxEntries = i;
}

    public Scoreboard(){
        this.firstNode = null;

    }
    public void add(String s, Integer i){
        GameEntry newNode, currentNode, tempNode;
        newNode = new GameEntry(s, i);
        
        if ( this.firstNode == null )     // Determine if there is a firstNode
      {
         this.firstNode = newNode;      // Store the first node

      }
        else{

         currentNode = this.firstNode;//set it to be back to firstNode
         if(newNode.getScore() > firstNode.getScore()){ //if bigger than first
             tempNode = currentNode;
             currentNode = newNode;
             this.firstNode = newNode; //first node is new node
             currentNode.nextElement = tempNode;
            
                
              //firstnode now equals newnode
         }
         else{
            while ( currentNode.nextElement != null  )  // Check if this is last element
         {
            currentNode = currentNode.nextElement;// Go to the next element
            numEntries++;//add to numEntries counter
            }
           currentNode = this.firstNode;//set it to be back to firstNode
 
            while ( currentNode.nextElement != null )  // Check if this is last element
         {
            if(newNode.getScore() > currentNode.nextElement.getScore()){//if bigger than currentnode nextelement
                 tempNode = currentNode.nextElement; //move next element to tempnode
                    currentNode.nextElement = newNode;//next element is newnode
                    currentNode = currentNode.nextElement;//move to next element
                    currentNode.nextElement = tempNode;//nextelement is tempnode
                break;
                }
            else {
                    currentNode = currentNode.nextElement;// Go to the next element
                    }
            }
            if (currentNode.nextElement == null){ //if nothing in next element
                currentNode.nextElement = newNode; //newnode is next element
            }

         }
         currentNode = this.firstNode;//set it to be back to firstNode
         numEntries = 0;//there will always be a first node
            while ( currentNode.nextElement != null )  // Check if this is last element
            {
             numEntries++;//increment counter
             if(numEntries == maxEntries){//if this is as long as max
         currentNode.nextElement = null; //erase next node
         break;
            }  
            currentNode = currentNode.nextElement;// Go to the next element
 }
        }  
       
    }//end of add
    public void print(){
  GameEntry currentNode = this.firstNode;
         while ( currentNode != null )    // Traverse entire list
         {
            scoreList.add(currentNode.toString());// Print Element contents
            currentNode = currentNode.nextElement;  // Go to next node
         }
    }
    public void delete(String s, Integer i){
        GameEntry newNode, currentNode, previousNode;
        previousNode = null;
        newNode = new GameEntry(s, i);
        currentNode = this.firstNode;//set it to be back to firstNode
        while ( currentNode != null )  // Check if this is last element
            {
                if(newNode.getName().equals(this.firstNode.getName()) && newNode.getScore().equals(this.firstNode.getScore())){//if this is as long as max
                     this.firstNode = currentNode.nextElement; //erase firstNode
                     currentNode = currentNode.nextElement; //currentNode is next node
                    break;
            }  
                else if(newNode.getName().equals(currentNode.getName()) && newNode.getScore().equals(currentNode.getScore()) ){
                  
                   previousNode.nextElement = currentNode.nextElement;
                   break;
                }
            previousNode = currentNode;//save last node
            currentNode = currentNode.nextElement;// Go to the next element
            }  
    }
}//end of Scoreboard class
Scoreboard board = new Scoreboard();//init scoreboard
    /**
     * Creates new form ScoreboardForm
     */
    public ScoreboardForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scoreList = new java.awt.List();
        btnKill = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        fieldScore = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        fieldMax = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnKill.setText("Close");
        btnKill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKillActionPerformed(evt);
            }
        });

        jLabel1.setText("Zane Neuschuler");

        jLabel2.setText("Intermediate Java");

        jLabel3.setText("Scoreboard App");

        fieldName.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));

        fieldScore.setBorder(javax.swing.BorderFactory.createTitledBorder("Score"));

        btnAdd.setText("Add Score");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove Score");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        fieldMax.setBorder(javax.swing.BorderFactory.createTitledBorder("Scoreboard Length"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scoreList, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldMax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldScore, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldName, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scoreList, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd)
                                .addGap(13, 13, 13)
                                .addComponent(btnRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKill))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKillActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnKillActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        scoreList.clear();
        int max = Integer.parseInt(fieldMax.getText());
       board.setMaxEntries(max);
        String name = fieldName.getText();
        Integer score = Integer.parseInt(fieldScore.getText());
        board.add(name, score);
        board.print();
        
        
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        scoreList.clear();
        String name = fieldName.getText();
        Integer score = Integer.parseInt(fieldScore.getText());
        board.delete(name, score);
        board.print();
    }//GEN-LAST:event_btnRemoveActionPerformed
//end of add
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScoreboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreboardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnKill;
    private javax.swing.JButton btnRemove;
    private javax.swing.JTextField fieldMax;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.List scoreList;
    // End of variables declaration//GEN-END:variables
}
