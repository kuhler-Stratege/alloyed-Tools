package net.modding.blocks.holzlackierung;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.modding.blocks.holzlackierung.metadata.TeerTypes;
import net.modding.main.modding;
import net.modding.registry.Holzlackierung;
import net.modding.util.UnluckEffekte;

public class BasicBlockTeer extends Block{

	public static Holzlackierung registry = modding.registry.holz;
	public int teerTypesLength = TeerTypes.length;
	private int level;
	
	public BasicBlockTeer(String unlocname, String regname, Material material, int level, float harte, float resistenz, SoundType sound) {
		super(material);
		setUnlocalizedName(unlocname);
		setRegistryName(regname);
		setCreativeTab(registry.teerTab);
		setHarvestLevel("axe", level);
		this.level = level;
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
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		super.onBlockHarvested(worldIn, pos, state, player);
		if (getHarvestLevel(state) >= 0) {
			UnluckEffekte.teereAxt(player, worldIn, pos, this, state, registry);
		}
	}
}