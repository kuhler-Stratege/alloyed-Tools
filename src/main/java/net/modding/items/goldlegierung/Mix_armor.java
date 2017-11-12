package net.modding.items.goldlegierung;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.modding.proxy.ServerProxy;

public class Mix_armor extends ItemArmor{

	public static Benennung_Registry registry = modding.registry;
	
	public Mix_armor(ArmorMaterial material, String kleidungteil, int proxy, int kleidungsteilInt) {
		super(material, proxy, kleidungsteilInt);
		setUnlocalizedName("mix_" + kleidungteil);
		setCreativeTab(registry.platinTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem().equals(registry.mix_helmet) || stack.getItem().equals(registry.mix_chestplate) || stack.getItem().equals(registry.mix_boots)) {
			return modding.MODID + ":textures/models/armor/mix_layer_1.png";
		}
		else if (stack.getItem().equals(registry.mix_leggings)) {
			return modding.MODID + ":textures/models/armor/mix_layer_2.png";
		}
		else {
			return null;
		}
	}
	
}
