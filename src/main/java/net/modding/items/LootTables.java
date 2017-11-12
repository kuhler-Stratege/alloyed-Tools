package net.modding.items;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class LootTables {
  
	public static Benennung_Registry registry = modding.registry;
	public static Random rand = new Random();
	
	@SubscribeEvent
	public void onEntityDeath(LivingDropsEvent event) {
		if (event.entityLiving instanceof EntityCow) {
			event.entityLiving.dropItem(registry.sohlleder, rand.nextInt(3));
		}
		if (event.entityLiving instanceof EntityHorse) {
			event.entityLiving.dropItem(registry.horse_raw, rand.nextInt(4));
		}
		if (event.entityLiving instanceof EntityPigZombie) {
			event.entityLiving.dropItem(registry.mix_klumpen, rand.nextInt(4));
			if (event.source.getEntity() != null) {
				if (event.source.getEntity() instanceof EntityPlayer) {
					int zufall = rand.nextInt(10);
					if (zufall == 5) {
					event.entityLiving.dropItem(registry.mix_sword, 1);
					}
				}
			}
		}
	}
	/*@SubscribeEvent
	public void setHeldItem(EntityConstructing event) {
		if (event.entity instanceof EntityPigZombie) {
			int rustung = rand.nextInt(2);
			EntityLivingBase zombiePigman = ((EntityLivingBase)event.entity);
			if (rustung == 0) {
				zombiePigman.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
			}
			else if (rustung == 1){
				zombiePigman.setCurrentItemOrArmor(0, new ItemStack(registry.mix_sword));
			}
			else {
				zombiePigman.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
			}
		}
	}*/
}