package net.modding.items;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemHorse_cooked extends BasicFood{

	public ItemHorse_cooked(String name, int amount, boolean isWolfFood) {
		super("horse_cooked", 5, false);
		
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 80, 2));
		//Eine Sekunde=20 Ticks
	}
	
}