public class News {
	private String title;
	private String description;
	private String link;
	private String guid;
	
	public News() {
		super();
	}

	public News(String title, String description, String link) {
		super();
		this.title = title;
		this.description = description;
		this.link = link;
	}
	
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "News [guid=" + guid + ", title=" + title + ", descriptionc=" + description + ", link=" + link + "]";
	}
	
}
