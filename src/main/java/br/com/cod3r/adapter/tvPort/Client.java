package br.com.cod3r.adapter.tvPort;

import br.com.cod3r.adapter.tvPort.adapters.HDMIToOldMonitorAdapter;
import br.com.cod3r.adapter.tvPort.adapters.HDMIToVGAAdapter;
import br.com.cod3r.adapter.tvPort.devices.Computer;
import br.com.cod3r.adapter.tvPort.devices.OldMonitor;
import br.com.cod3r.adapter.tvPort.devices.TV;

public class Client {

	public static void main(String[] args) {
		Computer pc = new Computer();
		TV tv = new TV();
		pc.connectPort(tv);
		pc.sendImageAndSound("Cat and rainbow", "Nyan cat song");
		
		System.out.println("------ Monitor ----------");

		final Computer pc1 = new Computer();
		final OldMonitor oldMonitor = new OldMonitor();
		pc1.connectPort(new HDMIToVGAAdapter(oldMonitor));
		pc1.sendImageAndSound("image...", "sound...");


		System.out.println("------ Monitor Class Adapter ----------");

		final Computer pc2 = new Computer();
		final HDMIToOldMonitorAdapter monitorAdapter = new HDMIToOldMonitorAdapter();
		pc2.connectPort(monitorAdapter);
		pc2.sendImageAndSound("My Image", "My Sound");

	}
}
