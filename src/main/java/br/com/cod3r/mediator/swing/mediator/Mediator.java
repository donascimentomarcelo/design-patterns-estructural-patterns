package br.com.cod3r.mediator.swing.mediator;

import br.com.cod3r.mediator.swing.components.AddButton;
import br.com.cod3r.mediator.swing.components.Label;
import br.com.cod3r.mediator.swing.components.State;

public class Mediator {
    private AddButton button;
    private Label label;
    private State state;

    public void buttonClicked() {
        state.addCount();
        label.refresh();
    }

    public void stop() {
        button.setEnabled(false);
    }

    public void reset() {
        state.setCounter(0);
        button.setEnabled(true);
        label.refresh();
    }

    public int getCountValue() {
        return state.getCounter();
    }

    public AddButton getButton() {
        return button;
    }

    public void setButton(final AddButton button) {
        this.button = button;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(final Label label) {
        this.label = label;
    }

    public State getState() {
        return state;
    }

    public void setState(final State state) {
        this.state = state;
    }
}
