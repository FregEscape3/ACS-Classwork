public class Cat { //public lowercased
    //class named change to Cat instead of Cats
	private String name;
	private String breed;
	private boolean isHungry;
	private int livesRemaining;

    // 2-Parameter Constructor
    //added second parameter (breed)
	public Cat(String name, String breed) {
        //added this. to make the reference correct
		this.name = name;
		this.breed = breed;
		isHungry = true;
        //removed an unnecessary this.
		livesRemaining = 9;
	}

	public String getName() {
        //changed return to String instead of void
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsHungry(){
        //fixed method name to camel case
        //changed return to boolean instead of void
		return isHungry;
	}

    public void setIsHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getLivesRemaining() {
        return livesRemaining;
    }

    public void setLivesRemaining(int livesRemaining) {
        this.livesRemaining = livesRemaining;
    }
    //added getters + setters for all variables

	public boolean feed() {
		this.isHungry = false;
        return isHungry;
        //returned a boolean instead of nothing
	}

	public boolean equals(Cat other) {
        //changed the first == into .equals()
		return (this.name.equals(other.name) && this.breed.equals(other.breed)
			&& this.livesRemaining == other.livesRemaining);
	}

	public String toString() {
        //returned instead of printed
		return (name + " is of breed " + breed + " and has " + livesRemaining + " lives remaining.");
	}
}
