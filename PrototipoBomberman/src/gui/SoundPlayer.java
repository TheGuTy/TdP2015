package gui;

import java.io.*;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {

	private static String pathToFile = "/Recursos/audio/";

	public static synchronized void playSound(final URL url) {
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void explosionBomba() {
		URL url = SoundPlayer.class.getResource(pathToFile + "bomb.wav");
		playSound(url);
	}
}