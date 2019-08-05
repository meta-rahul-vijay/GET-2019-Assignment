package question1;

/**
 * class Crocodile inheriting Reptiles
 * @author Mahendar
 */
public class Crocodile extends Reptiles {

	Crocodile(String name, int age, float weight) {
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

		return "ghrrr";
	}
}
