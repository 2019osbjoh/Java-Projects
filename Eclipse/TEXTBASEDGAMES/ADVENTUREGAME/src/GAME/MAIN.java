package GAME;

import java.util.Random;
import java.util.Scanner;

public class MAIN {
	public static void main(String[] args) {
		
		// System objects
		Scanner in = new Scanner(System.in); 
		Random rand = new Random();
		
		// Game Variables
		boolean running = true;
		
		String[] enemies = {"Warrior", "Skeleton", "Zombie", "Assassin"};
		int maxEnemyHealth = 75;
		int maxEnemyDamage = 25;
		
		// Player Variables
		int health = 100;
		int maxDamage = 30;
		int numHealingSalves = 3;
		int healingSalveAmount = 30;
		int salveDropChance = 50; // %
		
		System.out.println("LOST!");
		
		GAME:
		while(running) {
			System.out.println("-----------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat will you do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Use healing Salve");
				System.out.println("\t3. Run");
				
				String input = in.nextLine();
			}
		}
	}
}
