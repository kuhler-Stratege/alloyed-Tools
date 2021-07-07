package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;
import net.modding.main.Benennung_Registry;

public class BasicItemPickaxe extends ItemPickaxe{

	public static Benennung_Registry registry = new Benennung_Registry();
	
	protected BasicItemPickaxe(ToolMaterial material, String Materialname, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(Materialname + "_pickaxe");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_pickaxe");
		
	}


}
