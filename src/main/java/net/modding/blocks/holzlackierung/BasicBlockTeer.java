package net.modding.blocks.holzlackierung;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.modding.fludis.holzlackierung.Teer;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import scala.collection.convert.Wrappers.SetWrapper;

public class BasicBlockTeer extends Block{

	public static Benennung_Registry registry = modding.registry;
	
	public BasicBlockTeer(String unlocname, String regname, Material material, int level, float harte, float resistenz, SoundType sound) {
		super(material);
		setUnlocalizedName(unlocname);
		setRegistryName(regname);
		setCreativeTab(registry.teerTab);
		setHarvestLevel("axe", level);
		setHardness(harte);
		setSoundType(sound);
		setResistance(resistenz);
		//Holz, Gold: 0, Stein: 1, Eisen: 2, Diamant: 3
	}
	
	public BasicBlockTeer(String name, Material material, int level, float harte, float resistenz, SoundType sound) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.teerTab);
		setHarvestLevel("axe", level);
		setHardness(harte);
		setSoundType(sound);
		setResistance(resistenz);
	}
}
