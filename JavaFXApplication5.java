/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roshn
 */
/*
 * To change this license header, choose License Headers in Project
Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Math.round;
import java.sql.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author roshn
 */
public class JavaFXApplication5 extends Application {
 Connection con=null;
 Statement st=null;
 String query;
 Stage p;
 Scene in,mi,up,ii,upi,ij,ijin;
 String gr(double u)
 {
 if(u>=85)
 return "HD";
 if(u>=75)
 return "DI";
 if(u>=65)
 return "CR";
 if(u>=50)
 return "PS";
 return "FL";
 }
 double cal(int a,int b,int c,int d)
 {
 return round((a*0.05+b*0.15+c*0.2+d*0.6)*100)/100.0;
 }
 void ij()
 {
 Label l= new Label("ENTER THE ID TO BE UPDATED");
 Label ls= new Label("SELECT FIELD TO BE UPDATED");
 Label lp= new Label();
 VBox v= new VBox();
 ComboBox comboBox = new ComboBox();
 comboBox.getItems().add("ID");
 comboBox.getItems().add("NAME");
 comboBox.getItems().add("QUIZ");
 comboBox.getItems().add("A1");
 comboBox.getItems().add("A2");
 comboBox.getItems().add("EXAM");
 TextField ti=new TextField();
 Button bu= new Button("UPDATE");
 Button bunt= new Button("Go Back");
 v.getChildren().addAll(l,ti,lp,ls,comboBox,bu,bunt);
 v.setAlignment(Pos.CENTER);
 bunt.setOnAction(f->{
 p.setScene(mi);
 });
 bu.setOnAction(e->{
 try
 {
 ResultSet rs=st.executeQuery("select * from student where id='"+ti.getText()+"'");
 rs.next();
 String uid=rs.getString(1);
 }
 catch(Exception nm)
 {
 lp.setText("Record does not exsists");
 return;
 }
 String a=""+comboBox.getValue();
 VBox vin= new VBox();
 TextField tin=new TextField();
 Button buntin= new Button("Go Back");
 Button buin= new Button("UPDATE");
 buntin.setOnAction(ekjdfd->{p.setScene(ij);});
 Label linp= new Label();
 Label lin=new Label();
 switch(a)
 {
 case "NAME":
 case "ID":
 lin.setText("ENTER THE NEW "+a);
 break;
 case "QUIZ":
 case "A1":
 case "A2":
 case "EXAM":
 lin.setText("ENTER THE NEW MARKS");
 linp.setText("NOTE: CumulativeMark and grade will be updated automatically");
 break;
 }

vin.getChildren().addAll(lin,tin,linp,buin,buntin);
 vin.setAlignment(Pos.CENTER);
 ijin=new Scene(vin,340,150);
 p.setScene(ijin);
 buin.setOnAction(ekfd->
 {
 query="update student set "+a+"='"+tin.getText()+"' where id='"+ti.getText()+"'";
 try
 {
 st.executeUpdate(query);
 linp.setText("UPDATED");
 String s=ti.getText();
 if(a=="ID")
 s=tin.getText();
 ResultSet rs=st.executeQuery("select *from student where id='"+s+"'");
 rs.next();
 double jk=cal(Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString(4))
 ,Integer.parseInt(rs.getString(5)),Integer.parseInt(rs.getString(6)));
 st.executeUpdate("update student set Cumulative_Mark"
 +"="+jk+" where id='"+s+"'");
 st.executeUpdate("update student set grade"
 +"='"+gr(jk)+"' where id='"+s+"'");
 linp.setText("UPDATED");
 }
 catch(Exception elk)
 {
 linp.setText("Record Not valid");
 }
 });
 });
 ij= new Scene(v,170,190);
 }
 void iu()
 {
 Label l= new Label("ENTER THE ID TO BE SEARCHED");
 Label lp= new Label();
 VBox v= new VBox();
 TextField ti=new TextField();
 Button bu= new Button("SEARCH");
 Button bunt= new Button("Go Back");
 v.getChildren().addAll(l,ti,lp,bu,bunt);
 v.setAlignment(Pos.CENTER);
 bunt.setOnAction(f->{
 p.setScene(mi);
 });
 bu.setOnAction(e->{
 try
 {
 VBox vi= new VBox();
 Button but= new Button("Go Back");
 but.setOnAction(mbn->{
 p.setScene(upi);
 });
 ResultSet rs=st.executeQuery("select * from student where id='"+ti.getText()+"'");
 rs.next();
 Label lu= new Label(
 "ID: "+rs.getString(1)+
 "\nNAME: "+rs.getString(2)+
 "\nQUIZ MARKS: "+rs.getInt(3)+
 "\nA1 MARKS: "+rs.getInt(4)+
 "\nA2 MARKS: "+rs.getInt(5)+
 "\nEXAM MARKS: "+rs.getInt(6)+
 "\nCUMULATIVE MARKS: "+rs.getDouble(7)+
 "\nGRADE: "+rs.getString(8)+"\n\n");
 vi.getChildren().addAll(lu,but);
 vi.setAlignment(Pos.CENTER);
 up=new Scene(vi,170,180);
 p.setScene(up);
 }
 catch(Exception nm)
 {
 lp.setText("Record does not exsists");
 }});
 upi= new Scene(v,170,150);
 }
 void ii()
 {
 Label l= new Label("ENTER THE DATA");
 Label lp= new Label();
 VBox v= new VBox();
 Button bu= new Button("Submit");
 Label li= new Label("\nENTER THE ID");
 TextField ti=new TextField();
 Label ln= new Label("ENTER THE NAME");
 TextField tn=new TextField();
 Label lq= new Label("ENTER THE QUIZ MARKS");
 TextField tq=new TextField();
 Label l1= new Label("ENTER THE A1 MARKS");
 TextField t1=new TextField();
 Label l2= new Label("ENTER THE A2 MARKS");
 TextField t2=new TextField();
 Label le= new Label("ENTER THE EXAM MARKS");
 TextField te=new TextField();
 Button bunt= new Button("Go Back");
 bunt.setOnAction(f->{
 p.setScene(mi);
 });

v.getChildren().addAll(l,li,ti,ln,tn,lq,tq,l1,t1,l2,t2,le,te,lp,bu,bunt);
 v.setAlignment(Pos.CENTER);
 ii= new Scene(v,300,370);
 bu.setOnAction(e ->{
 try
 {
 double
m=cal(Integer.parseInt(tq.getText()),Integer.parseInt(t1.getText())
 ,Integer.parseInt(t2.getText()),Integer.parseInt
(te.getText()));
 String g=gr(m);
 query="insert into student values"
 +"('"+ti.getText()+"','"+tn.getText()
+"',"+Integer.parseInt(tq.getText())
 +","+Integer.parseInt(t1.getText())
+","+Integer.parseInt(t2.getText())
 +","+Integer.parseInt(te.getText())+","+m+",'"+g+"')";
 lp.setText("CumulativeMark: "+m+"\nGrade: "+g);
 st.execute(query);
 }
 catch(Exception p)
 {
 lp.setText("Invalid input");
 }});
 }
 void mii()
 {
 Label l= new Label("Which operation do you want to perform");
 Label lp= new Label();
 VBox v= new VBox();
 Button bu= new Button("Submit");
 RadioButton u,s,i;
 u=new RadioButton("Insert Record");
 s= new RadioButton("Update Record");
 i= new RadioButton("Search Record");
 ToggleGroup q= new ToggleGroup();
 u.setToggleGroup(q);
 s.setToggleGroup(q);
 i.setToggleGroup(q);
 bu.setOnAction(e ->
 {
 if (u.isSelected())
 {
 p.setScene(ii);
 }
 else if (s.isSelected())
 {
 p.setScene(ij);
 }
 else if (i.isSelected())
 {
 p.setScene(upi);
 }
 });
 v.getChildren().addAll(l,u,s,i,bu,lp);
 v.setAlignment(Pos.CENTER);
 mi= new Scene(v, 250, 180);
 p.setScene(mi);
 }
 void ct() throws SQLException
 {
 st=con.createStatement();
 query = "CREATE TABLE student("
 + "id varchar(8) PRIMARY KEY,"
 + "name varchar(20),"
 + "quiz int,"
 + "a1 int,"
 + "a2 int,"
 + "exam int,"
 + "cumulative_mark float,"
 +"grade varchar(2),"
 + "check(length(id)=8 and "
 + "a1>=0 and a1<=100 and a2>=0 and a2<=100 and "
 + "exam>=0 and exam<=100))";
 st.execute(query);
 query="insert into student values"
 +"('11111111','X',100,85,100,88,90.55,'HD')";
 st.execute(query);
 query="insert into student values"
 +"('22222222','Y',100,60,80,75,75.00,'DI')";
 st.execute(query);
 }
 @Override
 public void start(Stage primaryStage) {
 primaryStage.setTitle("19BIT0292");
 p=primaryStage;
 Label l=new Label("Login Id");
 TextField t1=new TextField();
 Label l1=new Label("Password");
 PasswordField t2= new PasswordField();
 Button b1=new Button("Submit");
 Label lp=new Label();
 VBox r=new VBox();
 r.getChildren().add(l);
 r.getChildren().add(t1);
 r.getChildren().add(l1);
 r.getChildren().add(t2);
 r.getChildren().add(b1);
 r.getChildren().add(lp);
 r.setAlignment(Pos.CENTER);
 b1.setOnAction(e->{

 try{

con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaumik", t1.getText(), t2.getText());
 ct();
 ii();
 iu();
 ij();
 mii();
 }
 catch(Exception ek)
 {
 lp.setText("Wrong ID or Password");
 }
 }
 );

 in=new Scene(r,150,120);
 p.setScene(in);
 p.show();
 }
 /**
 * @param args the command line arguments
 */
 public static void main(String[] args) {
 launch(args);
 }

}

