package music;

import gui.SongGUI;

import javax.swing.JTextArea;

public class Solo extends Thread {
	
	private String guitarPlayerName;
	private Performance  performance;
	private Synchronizer sync;
	private boolean stop;
	
	public Solo() {
		super();
	}
	
	public Solo(String guitarPlayerName, Performance performance) {
		super();
		this.guitarPlayerName = guitarPlayerName;
		this.performance = performance;
	}
	
	public Solo(String guitarPlayerName, Performance performance,
			Synchronizer sync, boolean stop) {
		super();
		this.guitarPlayerName = guitarPlayerName;
		this.performance = performance;
		this.sync = sync;
		this.stop = stop;
	}
	
	@Override
	public void run() {
		playSolo(SongGUI.textAreaSong);
	}

	private void playSolo(JTextArea area) {
		Song song = performance.getSong();
		int delay = performance.getDelay();
		
		while(!stop) {
			sync.playSolo("Guitar solo...", delay, area);
			System.out.println();
		}
		
	}

	public String getGuitarPlayerName() {
		return guitarPlayerName;
	}

	public void setGuitarPlayerName(String guitarPlayerName) {
		this.guitarPlayerName = guitarPlayerName;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public Synchronizer getSync() {
		return sync;
	}

	public void setSync(Synchronizer sync) {
		this.sync = sync;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

}
