package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    Button b1=new Button("计算下一天");
    Button b2=new Button("重新输入");
    TextField t1=new TextField();
    TextField t2=new TextField();
    TextField t3=new TextField();
    TextField t4=new TextField();
    String a,b,c;
    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(11,12,13,14));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("请分别输入年、月、日："),0,0);
        pane.add(new Label("年"),0,1);
        pane.add(t1,1,1);
        pane.add(new Label("月"),0,2);
        pane.add(t2,1,2);
        pane.add(new Label("日"),0,3);
        pane.add(t3,1,3);
        pane.add(new Label("下一天"),0,4);
        pane.add(t4,1,4);
        pane.add(b1,0,5);
        pane.add(b2,1,5);

        primaryStage.setTitle("计算下一天");
        primaryStage.setScene(new Scene(pane, 330, 366));
        primaryStage.show();
        b1.setOnAction(e->Get());
        b2.setOnAction(e->Clean());
    }
    public void Get(){
        a=t1.getText().toString();
        b=t2.getText().toString();
        c=t3.getText().toString();
        int A,B,C,year = 0,month=0,day=0;
        A=Integer.parseInt(a);
        B=Integer.parseInt(b);
        C=Integer.parseInt(c);
        switch (B){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if(C==31)
                {
                    year=A;
                    month=B+1;
                    day=1;
                    t4.setText(year+"年"+month+"月"+day+"日");
                    }
                else if(C>=1&&C<31)
                {
                     year=A;
                     month=B;
                     day=C+1;
                    t4.setText(year+"年"+month+"月"+day+"日");
                }
                else{
                    b1.setOnAction(e->Attention());
                }
                break;
            case 2:
                if(A%4==0&&A%100!=0&&C==29)
                {
                    year=A;
                    month=B+1;
                    day=1;
                    t4.setText(year+"年"+month+"月"+day+"日");
                }
                else if(!(A%4==0&&A%100!=0)&&C==28)
                {
                    year=A;
                    month=B+1;
                    day=1;
                    t4.setText(year+"年"+month+"月"+day+"日");
                }
                else if(C>=1&&C<=28)
                {
                    year=A;
                    month=B;
                    day=C+1;
                    t4.setText(year+"年"+month+"月"+day+"日");
                }
                else{
                    b1.setOnAction(e->Attention());
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(C==30)
                {
                    year=A;
                    month=B+1;
                    day=1;
                    t4.setText(year+"年"+month+"月"+day+"日");
                }
                else if(C>=1&&C<30)
                {
                    year=A;
                    month=B;
                    day=C+1;
                    t4.setText(year+"年"+month+"月"+day+"日");
                }
                else{
                    b1.setOnAction(e->Attention());
                }
                break;
            case 12:
                if(C==31)
                {
                    year=A+1;
                    month=1;
                    day=1;
                    t4.setText(year+"年"+month+"月"+day+"日");
                }
                else if(C>=1&&C<31)
                {
                    year=A;
                    month=B;
                    day=C+1;
                    t4.setText(year+"年"+month+"月"+day+"日");
                }
                else{
                    b1.setOnAction(e->Attention());
                }
                break;
        }
    }
    public void Clean(){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
    }
    public void Attention(){
        Stage primaryStage=new Stage();
        GridPane pane = new GridPane();
        Button b3=new Button("确定");
        pane.setPadding(new Insets(11,12,13,14));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("不可能"),0,0);
        pane.add(b3,0,1);
        primaryStage.setScene(new Scene(pane, 120, 70));
        primaryStage.show();
        b3.setOnAction(e->primaryStage.close());
    }
    public static void main(String[] args) {
        launch(args);
    }
}