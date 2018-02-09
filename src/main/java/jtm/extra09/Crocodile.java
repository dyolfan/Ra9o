package jtm.extra09;

/**
 * This is general interface for all Crocodiles
 */
public interface Crocodile {

	/**
	 * @return number of eaten candies
	 */
	public int getCandies();

	/**
	 * @return number of passed moves
	 */
	public int getMoves();

	/**
	 * @return type of the crocodile
	 */
	public String getType();

	/**
	 * Moves crocodile on the passed board eats candies and counts moves and
	 * candies
	 */
	public void move(Board board);

}
