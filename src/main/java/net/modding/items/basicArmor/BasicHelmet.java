package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class BasicHelmet extends ItemArmor{

	public BasicHelmet(ArmorMaterial material, String MaterialName, int MaterialInt, int armor, CreativeTabs tab) {
		super(material, MaterialInt, 0);
		setUnlocalizedName(MaterialName + "_helmet");
		setCreativeTab(tab);
	}

}
