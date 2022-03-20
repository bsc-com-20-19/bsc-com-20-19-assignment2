import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

/**
 *  a class for the Rooms
 */
public class Room {

    String isOnColor ;
    boolean bulbStatus = false;
    Button bulbSwitch ;
    String roomName;
    Button room; //room structure

    //constructor for the room class
    public Room(String isOnColor, String roomName, int width, int height) {
        this.isOnColor = isOnColor;
        this.roomName = roomName;
        bulbSwitch = new Button(roomName.toUpperCase() + " ON/OFF");
        bulbSwitch.setMinWidth(150);
        structureRoom(width, height);
    }

    public void structureRoom(int w, int h){
        room = new Button(this.roomName);
        room.setPrefWidth(w);
        room.setPrefHeight(h);

    }

  
    public  void styleRoom(){
        room.setTextAlignment(TextAlignment.CENTER);
        room.setStyle("-fx-border-color: black ; -fx-border-radius: 0; -fx-background-color: " + (bulbStatus == true ? isOnColor: "grey" ));

    }
  // setters for setbulbstatus  and setbulbonoff
    public void setBulbOnOff(){
        bulbStatus = !bulbStatus;
        styleRoom();
    }

    public void setBulbStatus(boolean value ){
        this.bulbStatus = value;
        styleRoom();
    }


    public Button getBulbSwitch() {
        return bulbSwitch;
    }


    public Button getRoom() {
        return room;
    }

    public boolean isBulbStatus() {
        return bulbStatus;
    }



    
    



    


}