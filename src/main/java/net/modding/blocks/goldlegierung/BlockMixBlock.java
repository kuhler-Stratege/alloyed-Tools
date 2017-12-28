package net.modding.blocks.goldlegierung;

import java.util.Random;

import javax.annotation.Nullable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.modding.main.modding;

public class BlockMixBlock extends BasicBlockGold {

		
		public BlockMixBlock() {
		super("mix_block", Material.iron, 2, 6F, soundTypeMetal, 12F);
	}
		
		@Override
		public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
			return registry.mix_ingot;
		}
		
		@Override
		public int quantityDropped(Random p_149745_1_) {
			return 9;
		}
		
		@SideOnly(Side.CLIENT)
		private IIcon[] mixIcons;
		
		@Override
		public void registerBlockIcons(IIconRegister reg) {
			mixIcons = new IIcon[] {
				reg.registerIcon(modding.MODID + ":" + "mix_block1"),
				reg.registerIcon(modding.MODID + ":" + "mix_block2")
			};
			this.blockIcon = mixIcons[0];
		}
		
		@SideOnly(Side.CLIENT)
		@Override
		public IIcon getIcon(int side, int meta) {
			switch (side) {
			case 0: //Unten
				return mixIcons[0];
			case 1: //Oben
				return mixIcons[0];
			default: //Seiten
				return mixIcons[1];
			}
		}
}