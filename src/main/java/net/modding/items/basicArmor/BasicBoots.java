package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class BasicBoots extends ItemArmor{

	public BasicBoots(ArmorMaterial material, String MaterialName, int MaterialInt, int armor, CreativeTabs tab) {
		super(material, MaterialInt, 3);
		setUnlocalizedName(MaterialName + "_boots");
		setCreativeTab(tab);
	}

}
