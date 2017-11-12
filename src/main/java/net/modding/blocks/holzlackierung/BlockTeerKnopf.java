package net.modding.blocks.holzlackierung;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.modding.util.UnluckEffekte;

public class BlockTeerKnopf extends BlockButtonWood{

	public static Benennung_Registry registry = modding.registry;
	
	public BlockTeerKnopf() {
		setBlockName("teer_knopf");
		setCreativeTab(null);
		setBlockTextureName(modding.MODID + "teer_knopf");
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, int x, int y, int z, Entity entityIn) {
		UnluckEffekte.unluckBlock(this, worldIn, entityIn, x, y, z);
	}
	
	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return Blocks.planks.getBlockTextureFromSide(1);
	}
	
}
