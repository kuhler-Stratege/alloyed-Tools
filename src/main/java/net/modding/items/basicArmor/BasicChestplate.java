package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class BasicChestplate extends ItemArmor{

	public BasicChestplate(ArmorMaterial material, String MaterialName, CreativeTabs tab) {
		super(material, 0, 1);
		setUnlocalizedName(MaterialName + "_chestplate");
		setCreativeTab(tab);
	}

}
