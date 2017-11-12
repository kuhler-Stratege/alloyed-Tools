package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class BasicChestplate extends ItemArmor{

	public BasicChestplate(ArmorMaterial material, String MaterialName, int MaterialInt, int armor, CreativeTabs tab) {
		super(material, MaterialInt, 1);
		setUnlocalizedName(MaterialName + "_chestplate");
		setCreativeTab(tab);
	}

}
