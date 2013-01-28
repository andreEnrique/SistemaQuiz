import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * 
 * @author Wennio
 *
 */

public class ReprodutorDeAudio {
	
	/**
	 * Variáveis e constantes
	 */
	private static final int BUFF = 128000;
	private AudioInputStream audioInputStream = null;
	private SourceDataLine line = null;
	private File soundFile = null;
	private AudioFormat audioFormat = null;
	
	/**
	 * Método que executa o arquivo de audio .wav
	 * @param audio
	 */
	public void play(String audio){
		
		soundFile = new File(audio);
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		audioFormat = audioInputStream.getFormat();
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		try {
			line = (SourceDataLine)AudioSystem.getLine(info);
			line.open(audioFormat);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		line.start();
		int	nBytesRead = 0;
		byte[]	abData = new byte[BUFF];
		while (nBytesRead != -1){
			try
			{
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			if (nBytesRead >= 0)
			{
				line.write(abData, 0, nBytesRead);
			}
		}
		line.drain();
		line.close();
	}
}
