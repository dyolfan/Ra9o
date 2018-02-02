package jtm.activity06;

public class Human implements Humanoid, Cloneable {
	public int weight;
	public String backpack;
	public boolean isAlive = true;

	public Human() {
		weight = 42;
	}

	public Human(int weight) {
		this.weight = weight;
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String killHimself() {
		this.isAlive = false;
		return "Dead";
	}

	@Override
	public int getArmCount() {
		return Humanoid.ARM_COUNT;
	}

	@Override
	public String getBackpack() {
		return backpack;
	}

	@Override
	public void setBackpack(String item) {
		backpack = item;
	}

	@Override
	public String isAlive() {
		if (isAlive)
			return "Alive";
		else
			return "Dead";
	}

	@Override
	public String toString() {
		String type = this.getClass().getSimpleName();
		return type + " " + this.weight + " [" + this.getBackpack() + "]";
	}
	
}
