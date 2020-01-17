//CLASE NODO

public class Song {
	int ID;
	String songName;
	String artist;
	String album;
	String year;
	
	Song next;
	Song prev;
	
	public Song(int ID, String songName, String artist, String album,String year) {
		this.ID=ID;
		this.songName=songName;
		this.artist=artist;
		this.album=album;
		this.year=year;
	}
}
