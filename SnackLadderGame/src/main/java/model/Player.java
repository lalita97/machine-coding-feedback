package model;

public class Player {
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int position;
    public  int id;


    public Player(int position, int id) {
        this.position = position;
        this.id = id;
    }
}
