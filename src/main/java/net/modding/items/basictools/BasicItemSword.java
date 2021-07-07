package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.modding.main.Benennung_Registry;

public class BasicItemSword extends ItemAdvancedSword{

	public static Benennung_Registry registry = new Benennung_Registry();
	
	protected BasicItemSword(ToolMaterial material, String Materialname, CreativeTabs tab, float attackDamage) {
		super(material, attackDamage);
		setUnlocalizedName(Materialname + "_sword");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_sword");
		
	}


}
