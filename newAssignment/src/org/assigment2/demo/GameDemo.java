package org.assigment2.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.assigment2.controller.GameController;
import org.assigment2.model.Player;

public class GameDemo {
	public static void main(String[] args) {	
		GameController gameController = new GameController();
		
		gameController.initialGame();
		gameController.startGame();
		
	}
}
