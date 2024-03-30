package model;

public class Board {

    public int size;

    public int getSize() {
        return size;
    }

    public Jump[] getBoard() {
        return board;
    }

    public Jump[] board;

    public Board(int size){
        this.size=size*size+1;
        this.board = new Jump[this.size];
    }

    public void setJump(Jump jump) {
        board[jump.start] = jump;
    }

    public boolean shouldJump(int x){
        return board[x] != null;
    }
}
