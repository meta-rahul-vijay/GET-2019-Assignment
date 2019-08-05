package question1;

/**
 * class Lion inheriting Mammals
 * @author Mahendar
 *
 */
public class Lion extends Mammals {

	Lion(String name, int age, float weight) {
		this.aid = ++(super.id);
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	/**
	 * method to return the sound of animals 
	 * @return the sound of given animal
	 */
	public String getSound() {
		return "roar";
	}

}
