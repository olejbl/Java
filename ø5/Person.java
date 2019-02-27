package objectstructures;

import java.util.ArrayList;

public class Person {
	String name;
	char gender;
	
	ArrayList<Person> parents = new ArrayList<Person>();
	ArrayList<Person> children = new ArrayList<Person>();
	
	public Person (String name, char gender) {
		if (!(checkGender(gender))) {
			throw new IllegalArgumentException("Ugyldig kjønn eller navn");
		}
		else {
			this.name = name;
			this.gender = gender;
		}
	}
	public boolean checkName(String name) {
		char[] chArray = name.toCharArray();
		for (char ch : chArray) {
			if (!Character.isAlphabetic(ch)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkGender(char gender) {
		if (gender != 'M' && gender != 'F' ) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String getName() {
		return name;
		
	}
	
	public char getGender() {
		return gender;
		
	}
	
	public Person getMother() {
		for (Person parent : parents) {
			if (parent.getGender() == 'F') {
				return parent;
			}
		}
		return null;
	}
	public Person getFather() {
		for (Person parent : parents) {
			if (parent.getGender() == 'M') {
				return parent;
				
			}
		}
		return null;
	}
	
	public int getChildCount() {
		return children.size();
	}
	public Person getChild(int i) {
		if (i < 0 || i >= children.size()) {
			throw new IllegalArgumentException("Barnet finnes ikke");
		}
		else {
			return children.get(i);
			
		}
	}
	
	public void addChild(Person child) {
		if (children.contains(child)) {
			return;
			
		}
		else if (child == this) {
			throw new IllegalArgumentException(" Du kan ikke bli forelder til deg selv");	
		}
		children.add(child);
		if (gender == 'M') {
			child.setFather(this);
		}
		else if ( gender == 'F') {
			child.setMother(this);
		}
	}
	
	public void removeChild(Person child) {
		if (!children.contains(child)) {
			return;
			
		}
		else {
			children.remove(child);
			child.removeParent(getGender());
		}
	}
	
	public void removeParent(char gender) {
		if (gender == 'M') {
				for (Person parent : parents) {
					if (parent.getGender() == 'M') {
						parent.removeChild(this);
						parents.remove(parent);
						break;
						
					}
				}
		}
		else if(gender == 'F') {
			for (Person parent : parents) {
				if (parent.getGender() == 'M') {
					parent.removeChild(this);
					parents.remove(parent);
					break;
				}
			}
		}
	}
	
	
	public void setMother(Person mother) {
		if (parents.contains(mother)) {
			return;			
		} else if (mother == this) {
			throw new IllegalArgumentException("Kan ikke bli mor til seg selv");
		} else if (mother.getGender() != 'F') {
			throw new IllegalArgumentException("Mor må være kvinne");
		} else if (getMother() != null) {
			removeParent('F');
		} 
		parents.add(mother);
		mother.addChild(this);
	}
	
	public void setFather(Person father) {
		if (parents.contains(father)) {
			return;
		} else if (father == this) {
			throw new IllegalArgumentException("Kan ikke bli far til seg selv");
		} else if (father.getGender() != 'M') {
			throw new IllegalArgumentException("Far må være mann");
		} else if (getFather() != null) {
			removeParent('M'); 
		}
		parents.add(father);
		father.addChild(this);
	}
	
	public String toString() {
		return name + " (" + gender + ")";
	}

	public static void main(String[] args) {
		Person p1 = new Person("Jonna", 'M');
		Person p2 = new Person("Atle", 'M');
		Person p3 = new Person("Johanne", 'F');
		Person p4 = new Person("Laila", 'F');
		p1.setMother(p4);
		p1.setFather(p3);
		p1.setFather(p2);
		System.out.println(p1.getFather());
	}

}