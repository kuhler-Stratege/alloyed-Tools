package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class BasicLeggings extends ItemArmor {

	public BasicLeggings(ArmorMaterial materialIn, String materialName, CreativeTabs tab) {
		super(materialIn, 0, EntityEquipmentSlot.LEGS);
		setUnlocalizedName(materialName + "_leggings");
		setRegistryName(materialName + "_leggings");
		setCreativeTab(tab);
	}

}
