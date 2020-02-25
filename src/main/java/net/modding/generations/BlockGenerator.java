package net.modding.generations;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BlockGenerator extends WorldGenMinable implements IWorldGenerator{

	private int frequency;
	private int YHohe;
	
	public BlockGenerator(IBlockState state, int i, int frequency, int YHohe) {
		super(state, i);
		this.frequency=frequency;
		this.YHohe = YHohe;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator arg4, IChunkProvider arg5) {
	for (int i= 0; i < frequency; i++) {
			int offsetX = random.nextInt(16);
			int offsetZ = random.nextInt(16);
			
			int posX = chunkX * 16 + offsetX;
			int posZ = chunkZ * 16 + offsetZ;
			
			int posY = random.nextInt(YHohe);
			
			generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
}