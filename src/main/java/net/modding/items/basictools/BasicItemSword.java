package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BasicItemSword extends ItemAdvancedSword{

	public static Benennung_Registry registry = modding.registry;
	
	protected BasicItemSword(ToolMaterial material, String Materialname, CreativeTabs tab, float attackSpeed) {
		super(material, attackSpeed);
		setUnlocalizedName(Materialname + "_sword");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_sword");
		
	}

	@Override
	public boolean isRepairable() {
		return true;
	}
}
