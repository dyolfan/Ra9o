package jtm.activity07;

public class Dog extends Mammal {
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		boolean hasDigit = false;
		for (char x : name.toCharArray())
			if (Character.isDigit(x))
				hasDigit = true;
		if (!hasDigit) {
			this.name = name;
		} else
			this.name = "";

		if (name == name.toLowerCase())
			this.name = "";
	}
}
