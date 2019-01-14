
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import static java.awt.datatransfer.DataFlavor.stringFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultHighlighter;


public class EditorGUI extends javax.swing.JFrame {

    String filename="Untitled";
    Clipboard clipboard= getToolkit().getSystemClipboard();
    public EditorGUI() {
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        SaveAs = new javax.swing.JMenuItem();
        PageSetup = new javax.swing.JMenuItem();
        Print = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Cut = new javax.swing.JMenuItem();
        Copy = new javax.swing.JMenuItem();
        Paste = new javax.swing.JMenuItem();
        Find = new javax.swing.JMenuItem();
        Format = new javax.swing.JMenu();
        WordWrap = new javax.swing.JMenuItem();
        Font = new javax.swing.JMenuItem();
        View = new javax.swing.JMenu();
        StatusBar = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        File.setText("File");

        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        File.add(New);

        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        File.add(Open);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        File.add(Save);

        SaveAs.setText("Save As...");
        SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAsActionPerformed(evt);
            }
        });
        File.add(SaveAs);

        PageSetup.setText("Page Setup...");
        File.add(PageSetup);

        Print.setText("Print...");
        File.add(Print);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        Edit.setText("Edit");

        Cut.setText("Cut");
        Cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutActionPerformed(evt);
            }
        });
        Edit.add(Cut);

        Copy.setText("Copy");
        Copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyActionPerformed(evt);
            }
        });
        Edit.add(Copy);

        Paste.setText("Paste");
        Paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteActionPerformed(evt);
            }
        });
        Edit.add(Paste);

        Find.setText("Find..");
        Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindActionPerformed(evt);
            }
        });
        Edit.add(Find);

        jMenuBar1.add(Edit);

        Format.setText("Format");

        WordWrap.setText("Word Wrap");
        Format.add(WordWrap);

        Font.setText("Font...");
        Format.add(Font);

        jMenuBar1.add(Format);

        View.setText("View");

        StatusBar.setText("Status Bar");
        View.add(StatusBar);

        jMenuBar1.add(View);

        Help.setText("Help");

        About.setText("About Notepad");
        Help.add(About);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteActionPerformed
        // TODO add your handling code here:
        try {
            Transferable paste=clipboard.getContents(EditorGUI.this);
            String sel=(String)paste.getTransferData(DataFlavor.stringFlavor);
            textArea.replaceRange(sel, textArea.getSelectionStart(), textArea.getSelectionEnd());
        } catch (Exception e) {
        }System.out.println("Didn't Work");
    }//GEN-LAST:event_PasteActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        // TODO add your handling code here:
        String data=textArea.getText();//read contents of text area into 'data'
        String newline = System.getProperty("line.separator");
        boolean hasNewline = data.contains(newline);
       if ((data.trim().length() > 0) && (!hasNewline)){
       int dialogButton = JOptionPane.YES_NO_OPTION;
    int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Note First?","Warning",dialogButton);
if(dialogResult == JOptionPane.YES_OPTION){ //The ISSUE is here
       SaveActionPerformed(evt);
        }
        textArea.setText("");
        setTitle("untitled");
       }
        
    }//GEN-LAST:event_NewActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        // TODO add your handling code here:
         String data=textArea.getText();//read contents of text area into 'data'
        String newline = System.getProperty("line.separator");
        boolean hasNewline = data.contains(newline);
        if ((data.trim().length() > 0) && (!hasNewline)){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Note First?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){ //The ISSUE is here
        SaveActionPerformed(evt);
        }
       }
        FileDialog fileDialog=new FileDialog(EditorGUI.this,"open File",FileDialog.LOAD);
        fileDialog.setVisible(true);
        if(fileDialog.getFile()!=null){
            filename = fileDialog.getDirectory()+fileDialog.getFile();
            setTitle(filename);
            
        }
        try{
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            StringBuilder sb=new StringBuilder();
            String line=null;
            while((line = reader.readLine())!=null)
            {
                sb.append(line+"\n");
                textArea.setText(sb.toString());
            }
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println("File not Found");
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        FileDialog fileDialog=new FileDialog(EditorGUI.this,"Save File",FileDialog.SAVE);
        fileDialog.setVisible(true);
        if(fileDialog.getFile() !=null){
            filename=fileDialog.getDirectory()+fileDialog.getFile();
            setTitle(filename);
        }
        try {
            FileWriter fileWriter=new FileWriter(filename);
            fileWriter.write(textArea.getText());
            setTitle(filename);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File not Found");
        }
{
            
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void CutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutActionPerformed
        // TODO add your handling code here:
        String cut=textArea.getSelectedText();
        StringSelection cutSelection=new StringSelection(cut);
        clipboard.setContents(cutSelection,cutSelection);
        textArea.replaceRange("",textArea.getSelectionStart(),textArea.getSelectionEnd());
        
    }//GEN-LAST:event_CutActionPerformed

    private void CopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyActionPerformed
        // TODO add your handling code here:
        String copy=textArea.getSelectedText();
        StringSelection copysel=new StringSelection(copy);
        clipboard.setContents(copysel, copysel);
        
    }//GEN-LAST:event_CopyActionPerformed

    private void FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindActionPerformed
        // TODO add your handling code here:
        class myHighlight extends DefaultHighlighter.DefaultHighlightPainter{
                public myHighlight(Color color) {
                    super(color);
                }                    
                }
        DefaultHighlighter.HighlightPainter highlighter=new myHighlight(Color.yellow);
        /*public void searchText(JTextComponent textComp,String textString)
        {
            try
        }*/
    }//GEN-LAST:event_FindActionPerformed

    private void SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAsActionPerformed
        // TODO add your handling code here:name
        if(filename!="untitled")
        {
            try {
            FileWriter fileWriter=new FileWriter(filename);
            fileWriter.write(textArea.getText());
            setTitle(filename);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File not Found");
        }
        }
        else
        {
            SaveActionPerformed(evt);
        }
    }//GEN-LAST:event_SaveAsActionPerformed

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
            java.util.logging.Logger.getLogger(EditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenuItem Copy;
    private javax.swing.JMenuItem Cut;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem Find;
    private javax.swing.JMenuItem Font;
    private javax.swing.JMenu Format;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem PageSetup;
    private javax.swing.JMenuItem Paste;
    private javax.swing.JMenuItem Print;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem SaveAs;
    private javax.swing.JMenuItem StatusBar;
    private javax.swing.JMenu View;
    private javax.swing.JMenuItem WordWrap;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
