package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class BasicLeggings extends ItemArmor{

	public BasicLeggings(ArmorMaterial material, String MaterialName, CreativeTabs tab) {
		super(material, 0, 2);
		setUnlocalizedName(MaterialName + "_leggings");
		setCreativeTab(tab);
	}

}
