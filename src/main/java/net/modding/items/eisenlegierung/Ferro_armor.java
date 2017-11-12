package net.modding.items.eisenlegierung;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.modding.proxy.ServerProxy;

public class Ferro_armor extends ItemArmor{

	public static Benennung_Registry registry = modding.registry;
	
	public Ferro_armor(ArmorMaterial material, String kleidungteil, int proxy, int kleidungsteilInt) {
		super(material, proxy, kleidungsteilInt);
		setUnlocalizedName("ferro_" + kleidungteil);
		setCreativeTab(registry.chromTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem().equals(registry.ferro_helmet) || stack.getItem().equals(registry.ferro_chestplate) || stack.getItem().equals(registry.ferro_boots)) {
			return modding.MODID + ":textures/models/armor/ferro_layer_1.png";
		}
		else if (stack.getItem().equals(registry.ferro_leggings)) {
			return modding.MODID + ":textures/models/armor/ferro_layer_2.png";
		}
		else {
			return null;
		}
	}
	
}
