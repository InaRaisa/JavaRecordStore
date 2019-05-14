package model;

public class Track {

	private long id;
	private String name;
	
	public Track(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public long getId() {
		return this.id;
	}
}