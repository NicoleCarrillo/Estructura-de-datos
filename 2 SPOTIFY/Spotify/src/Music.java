//NICOLE CARRILLO

//CLASE PRINCIPAL

public class Music {
	Song first; //SIRVE PARA INSERTAR LOS NODOS
	Song playing; //NODO QUE GUARDA EN QUE MUSICA ESTOY 
	
	public Music() {
		first=null;
	}
	
	public void Play() {
		if(playing==null) { //COMO TAL EL PROGRAMA NO TRUENA, TE APARECE UN MENSAJE Y NO TE DEJA AVANZAR
			System.out.println("NO HAY CANCION PARA REPRODUCIR");
		}else {
		System.out.println("PLAY: "+playing.songName);
		}
	}
	
	public void Next() {
		if(playing.next==null) {
			System.out.println("NEXT:  YA HAY CANCION PARA REPRODUCIR: "+playing.songName+" ES LA ULTIMA");
		}else {
			playing=playing.next;
			System.out.println("NEXT: "+playing.songName);
		}
	}
	
	public void Prev() {
	
			if(playing.prev==null) {
				System.out.println("PREV: "+playing.songName);
				System.out.println("YA HAY CANCION PARA REPRODUCIR, ES LA PRIMERA");
			}else {
		playing=playing.prev;
		System.out.println("PREV: "+playing.songName);
			}
	}
	
	public void addSong(Song cancion) { //METODO PARA AGREGAR CANCIONES, ES UNA LISTA DOBLE ENLZADA 
		if(first==null) {
			first=cancion;
			first.next=null;
			first.prev=null;
			playing=first;
		}else {
			Song current=first;
			playing=first;
			while(current.next!=null) {
				current=current.next;
			}
			current.next=cancion;
			cancion.prev=current;
			cancion.next=null;
		}
		
	}
	
	public void PrintList() {//METODO QUE IMPRIME LA LISTA
		Song current=first;
		int x=0;
		while(current!=null) {
			System.out.println(x+" "+current.songName);
			current=current.next;
			x++;
		}
	}
	
	public static void main(String[] args) {
		Music player = new Music();
		
		Song cancion1=new Song(1,"RUDE","MAGIC","DON'T KILL THE MAGIC","2006");
		Song cancion2=new Song(2,"ES MEJOR ASI","CRISTIAN CASTRO","UN SEGUNDO EN EL TIEMPO","2000");
		Song cancion3=new Song(3,"AVE MARIA","DAVID BISBAL","CORAZOZ LATINO","20064");
		Song cancion4=new Song(4,"TORERO","CHAYANEE","GRANDES EXITOS","2002");
		Song cancion5=new Song(5,"DEMONS","IMAGINE DRAGONS","NIGHT VISIONS","2012");
		
		player.addSong(cancion1);
		player.addSong(cancion2);
		player.addSong(cancion3);
		player.addSong(cancion4);
		player.addSong(cancion5);
		
		player.PrintList();
		System.out.println("--------------------------------------------");
		player.Play();
		System.out.println("--------------------------------------------");
		player.Next();
		System.out.println("--------------------------------------------");
		player.Next();
		System.out.println("--------------------------------------------");
	    player.Next();
		System.out.println("--------------------------------------------");
		player.Next();
		System.out.println("--------------------------------------------");
		player.Play();
		System.out.println("--------------------------------------------");
		player.Next();
		System.out.println("--------------------------------------------");
		
		player.Prev();
		System.out.println("--------------------------------------------");
		player.Prev();
		System.out.println("--------------------------------------------");
		player.Prev();
		System.out.println("--------------------------------------------");
		player.Prev();
		System.out.println("--------------------------------------------");
		player.Play();
		System.out.println("--------------------------------------------");
		System.out.println(player.playing.songName);
		System.out.println("--------------------------------------------");
		player.Prev();
		System.out.println("--------------------------------------------");
		player.Prev();
		System.out.println("--------------------------------------------");
		
		player.Next();
		System.out.println("--------------------------------------------");
	}
}
