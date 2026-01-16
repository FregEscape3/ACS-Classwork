public class Assignment {
    private String title;
    private String description;
    private int descriptionLength;

    public Assignment(String title, String description) {
        // Students: add your own validation and exceptions as you see fit
        if (title != null && description != null) {
            setTitle(title);
            setDescription(description);
        } else if (title == null && description != null) {
            throw new IllegalArgumentException("title is null");
        } else {
            throw new IllegalArgumentException("description is null");
        }
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title is null");
        }
        this.title = title;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("description is null");
        }
        this.description = description;
        this.descriptionLength = (description == null) ? 0 : description.length();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDescriptionLength() {
        return descriptionLength;
    }
}
