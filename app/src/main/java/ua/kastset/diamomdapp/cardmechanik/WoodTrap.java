package ua.kastset.diamomdapp.cardmechanik;

public class WoodTrap extends Card {
	public boolean isDead = false;

	public void kill() {
		isDead = true;
	}
	public WoodTrap(Integer iconId,String cards) {
		super(iconId,cards);
	}

	@Override
	public String playCard() {
		return "Use Wood trap";
	}

}
