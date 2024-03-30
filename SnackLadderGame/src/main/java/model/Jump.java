package model;

public class Jump {

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int start;
    public int end;

    public Jump(int x,int y){
        this.start = x;
        this.end = y;
    }
}
