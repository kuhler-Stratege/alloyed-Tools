package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class BasicBoots extends ItemArmor {

	public BasicBoots(ArmorMaterial materialIn, String materialName, CreativeTabs tab) {
		super(materialIn, 0, EntityEquipmentSlot.FEET);
		setUnlocalizedName(materialName + "_boots");
		setRegistryName(materialName + "_boots");
		setCreativeTab(tab);
	}

}
