package net.modding.items.basicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class BasicBoots extends ItemArmor{

	public BasicBoots(ArmorMaterial material, String MaterialName, CreativeTabs tab) {
		super(material, 0, 3);
		setUnlocalizedName(MaterialName + "_boots");
		setCreativeTab(tab);
	}

}
