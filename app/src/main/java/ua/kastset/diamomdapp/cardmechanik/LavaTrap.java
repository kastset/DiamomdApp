package ua.kastset.diamomdapp.cardmechanik;

public class LavaTrap extends Card {
	public boolean isDead = false;

	public void kill() {
		isDead = true;
	}
	public LavaTrap(Integer iconId,String cards) {
		super(iconId,cards);
	}

	public String playCard() {
		return "Use Lava trap";
	}

}
