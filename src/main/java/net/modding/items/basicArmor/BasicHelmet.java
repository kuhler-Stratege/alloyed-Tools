package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class BasicHelmet extends ItemArmor {

	public BasicHelmet(ArmorMaterial materialIn, String MaterialName, CreativeTabs tab) {
		super(materialIn, 0, EntityEquipmentSlot.HEAD);
		setUnlocalizedName(MaterialName + "_helmet");
		setRegistryName(MaterialName + "_helmet");
		setCreativeTab(tab);
	}

}
