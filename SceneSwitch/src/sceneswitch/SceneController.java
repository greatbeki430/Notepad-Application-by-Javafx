
package sceneswitch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private TextArea myText;
    FileChooser file = new FileChooser();
    @FXML
    private TextField Text1;
    @FXML
    private TextField Pass1;
    @FXML
    private TextField ID_T;
    @FXML
    private TextField Name_T;
    @FXML
    private TextField Grade_T;
    @FXML
    private Text Text2;
    @FXML
    private Text Text3;
    @FXML
    private Button choice1;
    @FXML
    private Button choice2;
    @FXML
    private Button choice3;
    @FXML
    private Button cancel;
    @FXML
    private Button save;
    @FXML
    private Button view;
    
    public void switchToScene1(ActionEvent event) throws IOException{
        String username = "greatbeki";
        String password = "great123";
        if(Text1.getText().equals("greatbeki") && 
            Pass1.getText().equals("great123")){
        root = FXMLLoader.load(getClass().getResource("Choice.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setScene(scene);
        stage.show();
        }
        else if(Text1.getText().isEmpty() && Pass1.getText().isEmpty()){
            Text2.setText("Please Enter your Username and password!");
            //Text2.setText("Invalid Login Cridential! Please Try Again!");
            //Text2.blendModeProperty();
        }
        else{
            Text1.setText("");
            Pass1.setText("");
            Text2.setText("Invalid Login Cridential! Please Try Again!");
            //Text2.blendModeProperty();
            
        }
    }
    
        public void switchToScene2(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        //Image image = new Image("Great.jpg");
        stage.setTitle("Notepad");
        stage.setWidth(600);
        stage.setHeight(400);
        //stage.getIcons().add(image);
        scene=new Scene(root);
        //Stage.setTitle("Notepad");
        stage.setScene(scene);
        stage.show();
    }
        @FXML
        public void OpenFile(ActionEvent event) throws FileNotFoundException, IOException
          {
            file.setTitle("Open File");
            file.setInitialDirectory(new File(System.getProperty("user.home")));
            File ff = file.showOpenDialog(null);
           if(ff != null){
               //myText.setText("You have selected the file: " + ff.getAbsolutePath());
               //loadFileToTextArea(ff);
               Stage st =(Stage)myText.getScene().getWindow();
               st.setTitle(ff.getName());
               BufferedReader br = null;
                   String sCurrent;
                   br = new BufferedReader(new FileReader(ff));
                   while((sCurrent = br.readLine()) != null){
                       myText.appendText(sCurrent + "\n");
               }
           }
            //String text = myText.appendText();
            
            
          }
        
        @FXML
         public void SaveFile(ActionEvent event)
        {
           //new FileChooser.ExtensionFilter("pdf", "*.pdf");
           //new FileChooser.ExtensionFilter("Image", "*.png","*.jpeg");
            String content = "";
            file.setTitle("Save File");
            file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files","*.*")
        );
        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Document(*.txt)","*.txt"));
        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Pdf(*.pdf)","*.pdf"));
        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image(*.png)","*.png"));
        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image(*.JPEG)","*.JPEG"));
        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Docoment(*.docx)","*.docx"));
        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Powerpoint(*.ppt)","*.ppt"));
        
        File ff = file.showSaveDialog(stage);      
        if(ff != null){
            //saveTextToFile(myText.getText(),ff);
        }
            //File f1 = new File("C:\\Users\\Great\\Desktop\\Notepad");
//        try {
//            FileWriter f2 = new FileWriter(f1);
//            f2.write(content);
//            f2.close();
//        } catch (IOException ex) {
//            Logger.getLogger(SceneController.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
//            if(ff != null){
//               myText.setText("You have selected the file " + ff.getAbsolutePath());
//           }
            
        }
         
//         private void saveTextToFile(String content,File ff1){
//        try {
//            PrintWriter filewriter = new PrintWriter(ff1);
//            filewriter.println(content);
//            filewriter.close();
//        } catch (IOException ex) {
//            Logger.getLogger(SceneController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         }
         
         @FXML
          public void exitOnAction(ActionEvent event)
        {
            Platform.exit();
            System.exit(0); 
        }
          @FXML
          public void backToFrist(ActionEvent event) throws IOException{
             root = FXMLLoader.load(getClass().getResource("scene1.fxml")); 
             stage =(Stage)((Node)event.getSource()).getScene().getWindow();
             //Image image = new Image("Great.jpg");
//             stage.setWidth(600);
//             stage.setHeight(400);
             scene=new Scene(root);
             //stage.getIcons().add(image);
             stage.setScene(scene);
             stage.show();
          }
          
          @FXML
        public void clearOnAction(ActionEvent event){
            String userClear;
            String passClear;
            Text1.clear();
            Pass1.clear();  
          }
        @FXML
        public void notepadOnAction(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Notepad.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        //Image image = new Image("Great.jpg");
        stage.setTitle("Notepad");
        stage.setWidth(600);
        stage.setHeight(400);
        //stage.getIcons().add(image);
        scene=new Scene(root);
        //Stage.setTitle("Notepad");
        stage.setScene(scene);
        stage.show();
        }
        @FXML
        public void studentOnAction(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        //Image image = new Image("Great.jpg");
        stage.setTitle("Student Information");
        stage.setWidth(600);
        stage.setHeight(400);
        //stage.getIcons().add(image);
        scene=new Scene(root);
        //Stage.setTitle("Notepad");
        stage.setScene(scene);
        stage.show();
            
        }
        @FXML
        public void fileOnAction(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("RadioFile.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        //Image image = new Image("Great.jpg");
        stage.setTitle("File Selection");
        stage.setWidth(600);
        stage.setHeight(400);
        //stage.getIcons().add(image);
        scene=new Scene(root);
        //Stage.setTitle("Notepad");
        stage.setScene(scene);
        stage.show();
        }
        @FXML
        public void cancelOnAction(ActionEvent event){
            //String Id = ID_T.getText();
            //String Name = Name_T.getText();
            //String Grade = Grade_T.getText();
            ID_T.setText("");
            Name_T.setText("");
            Grade_T.setText("");  
        }
        @FXML
        public void saveOnAction(ActionEvent event)throws IOException{
            file.setTitle("Save Data");
            file.getExtensionFilters().addAll(new 
        FileChooser.ExtensionFilter("Text Document(*.txt)", "*.txt"));
            //if(ID_T.getText().toString().isEmpty() && Name_T.getText().toString().isEmpty() && 
            //Grade_T.getText().toString().isEmpty()){
           //Text3.setText("Please Fill Required Data!");
            //}
            //file.setInitialDirectory("great.txt");
            File f = new File("C:\\Users\\Great\\Desktop\\Notepad\\StudentInfo\\great.txt");
            //new File("C:\\Users\\Great\\Desktop\\Notepad\\StudentInfo\\great.txt");
                if(f !=null){
                     studentFileStore(ID_T.getText(),Name_T.getText(),Grade_T.getText(),f);
            }       
        }
        public void studentFileStore(String cont1,String cont2,String cont3,File fs) throws IOException{
        try {
            FileWriter pr = new FileWriter(fs);
            //pr.Writabele(true);
            pr.write("ID_NO\t");
            pr.write("Full Name\t");
            pr.write("Grade");
            System.out.println();
            pr.write(cont1 +"\t");
            pr.write(cont2 +"\t");
            pr.write(cont3 +"\t");
            pr.append(cont1);
            pr.append(cont2);
            pr.append(cont3);
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        @FXML
        public void viewOnAction(ActionEvent event) throws FileNotFoundException, IOException{
            //FileInputStream fis = new 
            //FileInputStream("C:\\Users\\Great\\Desktop\\Notepad\\StudentInfo\\great.txt");
            //String str = ID_T.getText().trim();
            //String str2 = Name_T.getText().trim();
            //String str3 = Grade_T.getText().trim();
            String myfile = "";
            File fl = new File("C:\\Users\\Great\\Desktop\\Notepad\\StudentInfo\\great.txt");
        //Scanner sc1 = new Scanner();
        try (Scanner sc = new Scanner(fl)) {
            //Scanner sc1 = new Scanner();
            while (sc.hasNextLine()) {
                myfile = myfile.concat(sc.nextLine());
                //System.out.println(sc.nextLine());
            }
                try (FileWriter fw = new FileWriter("\\Users\\Great\\Desktop\\newfile.txt")) {
                    fw.write(myfile);
//            File fl = new File("C:\\Users\\Great\\Desktop\\Notepad\\StudentInfo\\great.txt");
//            StringBuffer  sb;
//        try (FileReader fr = new FileReader(fl)) {
//            BufferedReader br = new BufferedReader(fr);
//            sb = new StringBuffer();
//            String line;
//            while((line = br.readLine()) !=null){
//                sb.append(line);
//                sb.append("\n");
//            }
//        }
//            System.out.println("File Contents:");
//            System.out.println(sb.toString());
                }
        }
            
        }
        @FXML
        public void fristFileOpen(ActionEvent event){
            
        }
        @FXML
        public void secondFileOpen(ActionEvent event){
            
        }
        @FXML
        public void thirdFileOpen(ActionEvent event){
            
        }
    
}
