package br.com.cod3r.mediator.swing;

import br.com.cod3r.mediator.swing.mediator.Mediator;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.cod3r.mediator.swing.components.AddButton;
import br.com.cod3r.mediator.swing.components.Label;
import br.com.cod3r.mediator.swing.components.ResetButton;
import br.com.cod3r.mediator.swing.components.State;

public class Client {
	private AddButton button;
	private ResetButton reset;
	private Label label;
	private State state;
	private Mediator mediator;
	
	public Client() {
		mediator = new Mediator();
		state = new State(mediator);
		label = new Label(mediator);
		button = new AddButton(mediator);
		reset = new ResetButton(mediator);
		mediator.setButton(button);
		mediator.setLabel(label);
		mediator.setState(state);
	}

	public void run() {
		JFrame frame = new JFrame();  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Counter");
		frame.add(title, BorderLayout.NORTH);

		frame.add(reset, BorderLayout.WEST);
		frame.add(button, BorderLayout.CENTER);
		frame.add(label, BorderLayout.SOUTH);
		
		frame.setSize(400,200);  
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Client().run();
	}
}
