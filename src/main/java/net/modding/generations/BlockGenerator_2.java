package net.modding.generations;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BlockGenerator_2 extends WorldGenMinable implements IWorldGenerator{

	private int frequency;
	
	public BlockGenerator_2(IBlockState p_i45630_1_, int p_i45630_2_, int frequency) {
		super(p_i45630_1_, p_i45630_2_);
		this.frequency=frequency;	
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator arg4, IChunkProvider arg5) {
	for (int i= 0; i < frequency; i++) {
			int offsetX = random.nextInt(16);
			int offsetZ = random.nextInt(16);
			
			int posX = chunkX * 16 + offsetX;
			int posZ = chunkZ * 16 + offsetZ;
			
			int posY = random.nextInt(17);
			
			generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
}
