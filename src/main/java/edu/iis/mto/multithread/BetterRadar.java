package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {
	private PatriotBattery battery;
	private Executor exec;

	public BetterRadar(PatriotBattery missle) {
		this.battery = missle;
	}

	public void setExecutor(Executor e) {
		this.exec = e;
	}
	
	public void notice(Scud enemyMissle) {
		launchPatriot();
	}

	private void launchPatriot() {
		Runnable launchPatriotTask = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					battery.launchPatriot();
				}
			}
		};

		exec.execute(launchPatriotTask);
	}

}