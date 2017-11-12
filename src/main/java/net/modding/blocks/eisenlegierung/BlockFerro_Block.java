package net.modding.blocks.eisenlegierung;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.modding.main.modding;

public class BlockFerro_Block extends BasicBlockEisen{
	
	public BlockFerro_Block() {
		super("ferro_block", Material.iron, 2, 3.5F, soundTypeMetal);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return registry.ferro_ingot;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 9;
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon[] ferroIcons;
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		ferroIcons = new IIcon[] {
			reg.registerIcon(modding.MODID + ":" + "ferro_EisenSili"),
			reg.registerIcon(modding.MODID + ":" + "ferro_EisenChrom"),
			reg.registerIcon(modding.MODID + ":" + "ferro_SiliChrom")
		};
		this.blockIcon = ferroIcons[0];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		switch (side) {
		case 0: //Unten
			return ferroIcons[1];
		case 1: //Oben
			return ferroIcons[2];
		case 2: //Seite
			return ferroIcons[0];
		case 3: //Seite
			return ferroIcons[1];
		case 4: //Seite
			return ferroIcons[2];
		default: //Seite
			return ferroIcons[0];
		}
	}
}
