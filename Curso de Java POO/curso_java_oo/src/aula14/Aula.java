package aula14;

public class Aula {

	private PlayerVideo video;
	void videos(){
		video = new WMV();
		video.play();
		video.pause();
		video.volume(5);
		video.taxaDeQuadros();
		video.nomeArquivo("video_aula.wmv");
		video.stop();
		
		System.out.println();
		
		video = new RMV();
		video.play();
		video.pause();
		video.volume(5);
		video.taxaDeQuadros();
		video.nomeArquivo("video_aula.rmv");
		video.stop();
		
	}
	
	public static void main(String[] args) {
		
		//new Aula().videos();
		
		MP3 mp3 = new MP3();
		mp3.play();
		mp3.pause();
		mp3.volume(80);
		mp3.taxaDeBits();
		mp3.stop();
		
		System.out.println();
		
		AVI avi = new AVI();
		avi.play();
		avi.pause();
		avi.volume(80);
		avi.taxaDeBits();
		avi.stop();
		avi.taxaDeQuadros();
		
	}

}
