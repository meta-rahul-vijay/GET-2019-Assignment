package question1;

/**
 * abstract class containing properties of animals in zoo
 * @author Mahendar
 */
public abstract class Animals {
	int aid;
	static int id = 0;
	String name;
	int age;
	float weight;

	/**
	 * abstract method to return the sound of animals
	 * @return the sound of given animal
	 */
	abstract String getSound();

}
