package net.modding.fludis.holzlackierung;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class Teer {
	
	public static final class FluidTeer extends Fluid {
		
		public static final String name = "teer";
		public static final FluidTeer instance = new FluidTeer();

		public FluidTeer() {
			super(name);
			setDensity(4500);
			setGaseous(false);
			setRarity(EnumRarity.rare);
			setTemperature(500);
			setViscosity(2859);
			
		}
		
	}
	
	public static final class BlockTeer extends BlockFluidClassic {
		
		public static final BlockTeer instance = new BlockTeer();
		public static final String name = "teer";
		public static Benennung_Registry registry = modding.registry;
		
		public BlockTeer() {
			super(FluidTeer.instance, new MaterialLiquid(MapColor.obsidianColor));
			setBlockName(name);
			setBlockTextureName(modding.MODID + name);
		}
		
		@Override
		public void onEntityCollidedWithBlock(World worldIn, int x, int y, int z, Entity entityIn) {
			if (entityIn instanceof EntityLivingBase) {
				((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(27, 300, 1, false));
			}
		}
		
		public void ersetzen (World world, int x, int y, int z, Block vorher, Block nachher) {
			for(EnumFacing facing : EnumFacing.values()) {
				
				Block block = world.getBlock(x, y, z);
				if (block == vorher) {
					world.setBlock(x, y, z, nachher);
				}
			}
		}
		
		@Override
		public void onBlockAdded(World world, int x, int y, int z) {
			super.onBlockAdded(world, x, y, z);
			ersetzen(world, x, y, z, Blocks.planks, registry.plank_teer);
		}
		
		@Override
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			super.onNeighborBlockChange(world, x, y, z, block);
			ersetzen(world, x, y, z, Blocks.planks, registry.plank_teer);
		}
	}
}
