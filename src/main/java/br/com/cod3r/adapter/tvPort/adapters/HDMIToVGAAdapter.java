package br.com.cod3r.adapter.tvPort.adapters;

import br.com.cod3r.adapter.tvPort.intefaces.HDMI;
import br.com.cod3r.adapter.tvPort.intefaces.VGA;

public class HDMIToVGAAdapter implements HDMI {
    private VGA vga;

    public HDMIToVGAAdapter(VGA vga) {
        this.vga = vga;
    }

    @Override
    public void setImage(final String image) {
        System.out.println("image...");
    }

    @Override
    public void setSound(final String sound) {
        System.out.println("no sound");
    }
}
