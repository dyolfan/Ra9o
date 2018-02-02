package jtm.activity06;

public class Martian implements Alien, Humanoid, Cloneable {
	public int weight;
	public Object backpack;
	public final boolean IS_ALIVE = true;

	public Martian(int weigth) {
		this.weight = weigth;
	}

	@Override
	public String killHimself() {
		return "I AM IMMORTAL!";
	}

	@Override
	public int getArmCount() {
		return Humanoid.ARM_COUNT;
	}

	@Override
	public void setBackpack(String item) {
		this.backpack = item;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public void eatHuman(Humanoid humanoid) {
		if (humanoid.isAlive() == "Alive") {
			humanoid.killHimself();
			this.weight = this.weight + humanoid.getWeight();
		}
	}

	@Override
	public int getLegCount() {
		return Alien.LEG_COUNT;
	}

	@Override
	public Object getBackpack() {
		return clone(this.backpack);
	}

	@Override
	public void setBackpack(Object item) {
		if (item == this) {

		} else
			this.backpack = item;
	}

	@Override
	public String isAlive() {
		return "I AM IMMORTAL!";
	}

	public Object clone() throws java.lang.CloneNotSupportedException {
		return clone(this);
	}

	@Override
	public Object clone(Object object) {
		if (object == null)
			return null;
		if (object.getClass() == Object.class)
			return new Object();
		if (object instanceof String) {
			return new String((String) object);
		}
		if (object instanceof Human) {
			Human realHuman = (Human) object;
			Human copyHuman = new Human(realHuman.getWeight());
			copyHuman.setBackpack(realHuman.getBackpack());
			return copyHuman;
		}
		if (object instanceof Martian) {
			Martian realMartian = (Martian) object;
			Martian copyMartian = new Martian(realMartian.getWeight());
			copyMartian.setBackpack(realMartian.getBackpack());
			return copyMartian;
		} else
			return null;
	}

	@Override
	public String toString() {
		String type = this.getClass().getSimpleName();
		return type + " " + this.weight + " [" + this.getBackpack() + "]";
	}
	
}
