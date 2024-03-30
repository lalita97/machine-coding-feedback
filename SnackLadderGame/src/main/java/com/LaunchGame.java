package com;

import model.Board;
import model.Player;

import java.util.Queue;
import java.util.Random;
import java.util.logging.Logger;

public class LaunchGame {

    private static final Logger logger = Logger.getLogger("SnackLadder");
    private static Player winner;

    public static void launch(Queue<Player> turnQueue, Board board){
        Random rand = new Random();
        while(turnQueue.size()!=1){
            Player curr = turnQueue.poll();
            logger.info("Dice roll");
            int num = rand.nextInt(6);
            logger.info(String.format("rolled value %d", num));
            int pos = curr.getPosition()+num;

            if(pos >= board.getSize()){
                logger.info(String.format("position getting out of board game", pos));
                turnQueue.add(curr);
                continue;
            }
            //check if snack ladder at pos
            if(board.shouldJump(pos)){
                pos = board.getBoard()[pos].getEnd();
            }
            curr.setPosition(pos);
            //check winner
            if(pos==board.getSize()-1){
                winner = curr;
                continue;
            }
            logger.info(String.format("final position for player [%d : %d]", curr.getId(), pos));
            turnQueue.add(curr);
        }
        System.out.println("Winner is "+ winner.getId());
    }
}
