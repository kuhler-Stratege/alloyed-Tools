package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class BasicHelmet extends ItemArmor{

	public BasicHelmet(ArmorMaterial material, String MaterialName, CreativeTabs tab) {
		super(material, 0, 0);
		setUnlocalizedName(MaterialName + "_helmet");
		setCreativeTab(tab);
	}

}
