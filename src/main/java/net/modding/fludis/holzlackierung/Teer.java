package net.modding.fludis.holzlackierung;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class Teer {
	
	private static ModelResourceLocation location = new ModelResourceLocation(modding.MODID + ":" + BlockTeer.name);
	
	public static void registerFluid() {
		FluidRegistry.registerFluid(FluidTeer.instance);
		GameRegistry.registerBlock(BlockTeer.instance, BlockTeer.name);
		
		Item teerItem = Item.getItemFromBlock(BlockTeer.instance);
		ModelLoader.setCustomMeshDefinition(teerItem, new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return location;
			}
		});
		ModelLoader.setCustomStateMapper(BlockTeer.instance, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return location;
			}
		});
	}
	
	public static final class FluidTeer extends Fluid {
		
		public static final String name = "teer";
		public static final FluidTeer instance = new FluidTeer();

		public FluidTeer() {
			super(name, new ResourceLocation(modding.MODID + ":" + "blocks/" + name + "_still"), new ResourceLocation(modding.MODID + ":" + "blocks/" + name + "_flow"));
			setFillSound(SoundEvents.ITEM_BUCKET_FILL_LAVA);
			setEmptySound(SoundEvents.ITEM_BUCKET_EMPTY_LAVA);
			setDensity(4500);
			setGaseous(false);
			setRarity(EnumRarity.RARE);
			setTemperature(500);
			setViscosity(2859);
			
		}
		
	}
	
	public static final class BlockTeer extends BlockFluidClassic {
		
		public static final BlockTeer instance = new BlockTeer();
		public static final String name = "teer";
		public static Benennung_Registry registry = modding.registry;
		
		public BlockTeer() {
			super(FluidTeer.instance, new MaterialLiquid(MapColor.OBSIDIAN));
			setUnlocalizedName(name);
			//setCreativeTab(registry.teerTab);
		}
		
		@Override
		public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
			if (entityIn instanceof EntityLivingBase) {
				((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(27), 300, 1, false, true));
			}
		}
		
		public void ersetzen (World world, BlockPos pos, IBlockState state, Block vorher, Block nachher) {
			for(EnumFacing facing : EnumFacing.values()) {
				
				Block block = world.getBlockState(pos.offset(facing)).getBlock();
				if (block == vorher) {
					world.setBlockState(pos.offset(facing), nachher.getDefaultState());
				}
			}
		}
		
		@Override
		public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
			super.onBlockAdded(world, pos, state);
			ersetzen(world, pos, state, Blocks.PLANKS, registry.plank_teer);
		}
		
		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock) {
			super.neighborChanged(state, world, pos, neighborBlock);
			ersetzen(world, pos, state, Blocks.PLANKS, registry.plank_teer);
		}
		
		@Override
		public EnumBlockRenderType getRenderType(IBlockState state) {
			return EnumBlockRenderType.MODEL;
		}
	}
	
}
