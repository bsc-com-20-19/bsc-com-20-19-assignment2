import javax.swing.RowFilter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;



public class Smart_Home extends Application {

  static Room room1, room2, room3, room4, room5, room6, room7;

  public static void main(String[] args) {
    launch(args);
  }




  @Override
  public void start(Stage primaryStage) throws Exception {


    room1 = new Room("yellow","ROOM1", 100, 170);
    room2 = new Room("green","ROOM2", 120, 40);
    room3 = new Room("orange","ROOM3", 60, 90);
    room4 = new Room("orange","ROOM4", 60, 90);
    room5 = new Room("yellow","ROOM5", 90, 130);
    room6 = new Room("red","ROOM6",   100, 140);
    room7 = new Room("yellow","ROOM7", 110, 140);

    HBox room34 = new HBox();
    room34.getChildren().addAll(room3.getRoom(), room4.getRoom());
    VBox room234 = new VBox();
    room234.getChildren().addAll(room34, room2.getRoom());
    HBox room2345 = new HBox();
    room2345.getChildren().addAll(room234, room5.getRoom());
    HBox room67 = new HBox();
    room67.getChildren().addAll(room6.getRoom(), room7.getRoom()); 
    VBox room234567 = new VBox();
    room234567.getChildren().addAll(room2345, room67);

    GridPane switches = new GridPane();
    switches.setPadding(new Insets(70));
    switches.setVgap(50);
    switches.setHgap(50);
    switches.setAlignment(Pos.CENTER);

    Button allRooms = new Button("ALLROOMS ON/OFF");
    allRooms.setMinWidth(150);
    Button switch12 = new Button("ROOM12");
    switch12.setMinWidth(150);


    Button [] switchesArray = {allRooms, switch12, room1.getBulbSwitch(), room2.getBulbSwitch(), room3.getBulbSwitch(),
       room4.getBulbSwitch(), room5.getBulbSwitch(), room6.getBulbSwitch(), room7.getBulbSwitch()};

    int position =0;
    for (int col =0; col< 3; col++){
      for(int row = 0; row < 3; row++ ){
        switches.add(switchesArray[position], col, row);
        position++;
      }
    }

    HBox house = new HBox();
    house.getChildren().addAll(room1.getRoom(), room234567);
    HBox mainHouse = new HBox();
    mainHouse.getChildren().add(house);
    mainHouse.setAlignment(Pos.CENTER);

    BorderPane window = new BorderPane();
    window.setTop(mainHouse);
    window.setCenter(switches);

    
    room1.getBulbSwitch().setOnAction(e ->{
      room1.setBulbOnOff();
    });
    room2.getBulbSwitch().setOnAction(e ->{
      room2.setBulbOnOff();
    });
    room3.getBulbSwitch().setOnAction(e ->{
      room3.setBulbOnOff();
    });
    room4.getBulbSwitch().setOnAction(e ->{
      room4.setBulbOnOff();
    });
    room5.getBulbSwitch().setOnAction(e ->{
      room5.setBulbOnOff();
    });
    room6.getBulbSwitch().setOnAction(e ->{
      room6.setBulbOnOff();
    });
    room7.getBulbSwitch().setOnAction(e ->{
      room7.setBulbOnOff();
    });

    switch12.setOnAction(e -> {
        if(room1.isBulbStatus() ==false && room2.isBulbStatus() ==false ){
            room1.setBulbStatus(true);
            room2.setBulbStatus(true);
            
        }
        else{
          room1.setBulbStatus(false);
          room2.setBulbStatus(false);


        }

    });
    allRooms.setOnAction(e -> {
      if(room1.isBulbStatus() ==false && room2.isBulbStatus() ==false && room3.isBulbStatus() ==false &&
       room4.isBulbStatus() ==false && room5.isBulbStatus() ==false && room6.isBulbStatus() ==false && room7.isBulbStatus() ==false){
          room1.setBulbStatus(true);
          room2.setBulbStatus(true);
          room3.setBulbStatus(true);
          room4.setBulbStatus(true);
          room5.setBulbStatus(true);
          room6.setBulbStatus(true);
          room7.setBulbStatus(true);
          
      }
      else{
        room1.setBulbStatus(false);
        room2.setBulbStatus(false);
        room3.setBulbStatus(false);
        room4.setBulbStatus(false);
        room5.setBulbStatus(false);
        room6.setBulbStatus(false);
        room7.setBulbStatus(false);

      }

  });




   
    Scene scene = new Scene(window);
    primaryStage.setScene(scene);
    primaryStage.setTitle("IOTHOME");
    primaryStage.show();





  }


}
  
