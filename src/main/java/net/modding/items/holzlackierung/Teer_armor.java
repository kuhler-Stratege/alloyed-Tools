package net.modding.items.holzlackierung;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.modding.proxy.ServerProxy;

public class Teer_armor extends ItemArmor{

	public static Benennung_Registry registry = modding.registry;
	
	public Teer_armor(ArmorMaterial material, String kleidungteil, int proxy, int kleidungsteilInt) {
		super(material, proxy, kleidungsteilInt);
		setUnlocalizedName("teer_" + kleidungteil);
		setCreativeTab(registry.teerTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem().equals(registry.teer_helmet) || stack.getItem().equals(registry.teer_chestplate) || stack.getItem().equals(registry.teer_boots)) {
			return modding.MODID + ":textures/models/armor/teer_layer_1.png";
		}
		else if (stack.getItem().equals(registry.teer_leggings)) {
			return modding.MODID + ":textures/models/armor/teer_layer_2.png";
		}
		else {
			return null;
		}
	}
	
}
