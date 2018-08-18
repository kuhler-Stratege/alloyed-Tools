package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class BasicChestplate extends ItemArmor {

	public BasicChestplate(ArmorMaterial materialIn, String materialName, CreativeTabs tab) {
		super(materialIn, 0, EntityEquipmentSlot.CHEST);
		setUnlocalizedName(materialName + "_chestplate");
		setRegistryName(materialName + "_chestplate");
		setCreativeTab(tab);
	}

}
