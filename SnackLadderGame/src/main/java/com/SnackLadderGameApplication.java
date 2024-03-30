package com;

import model.Board;
import model.Jump;
import model.Player;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.logging.Logger;

public class SnackLadderGameApplication {

    private static final Logger logger =  Logger.getLogger("SnackLadderGameApplication");

    private static final Scanner scanner = new Scanner(System.in);
    public static Queue<Player> turnQueue = new LinkedList<>();
    public static Board board;

    public static void main(String[] args) {

        logger.info("Initialize board size");
        int n = scanner.nextInt();
        initializeGame(n);

        initializePlayers();
        LaunchGame.launch(turnQueue,board);
        logger.info("Game Finished");
    }

    private static void initializePlayers() throws InvalidParameterException {
        logger.info("Initialize Players");
        try{
            int players = scanner.nextInt();
            if(players <= 1){
                logger.warning("Please enter more than 1 player");
                throw new InvalidParameterException("Invalid No of Player entered");
            }
            for(int i=1;i<=players;i++){
                Player player = new Player(0,i);
                turnQueue.add(player);
            }
        }
        catch (Exception e){
            logger.info(Arrays.toString(e.getStackTrace()));
        }

    }

    private static void initializeGame(int n) {
        board = new Board(n);
        int index = n*n+1;
        Random rand = new Random();

        //initialize snacks
        logger.info("/--Initialize snacks--/");
        int snacks = scanner.nextInt();
        while(snacks>0){
            int x = rand.nextInt(index);
            int y = rand.nextInt(index);
            logger.info(String.format("start : %d, end : %d", x,y));
            if(x>y && isValid(x,y,index)){
                Jump jump = new Jump(x,y);
                board.setJump(jump);
            }
            else{
                logger.info( String.format("Start should be greater than end for Snack [ %d %d ]", x, y));
                continue;
            }
            snacks--;
        }

        //initialize ladders
        logger.info("/--Initialize ladders--/");
        int ladders = scanner.nextInt();
        while(ladders>0){
            int x = rand.nextInt(index);
            int y = rand.nextInt(index);
            logger.info(String.format("start : %d, end : %d", x,y));
            if(x<y && isValid(x,y,index)){
                Jump jump = new Jump(x,y);
                board.setJump(jump);
            }
            else{
                logger.info(String.format("Start should be less than end for Ladder [ %d %d ]", x, y));
                continue;
            }
            ladders--;
        }
    }

    private static boolean isValid(int x,int y,int size){
        if(x<=0 || y<=0 || x==size ){
            return false;
        }
        return true;
    }
}