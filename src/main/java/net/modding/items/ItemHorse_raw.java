package net.modding.items;

public class ItemHorse_raw extends BasicFood{

	public ItemHorse_raw(String name, int amount, boolean isWolfFood) {
		super("horse_raw", 3, true);
		setAlwaysEdible();
	}
}