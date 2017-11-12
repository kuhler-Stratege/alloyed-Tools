package net.modding.generations;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BlockGenerator implements IWorldGenerator{

	public static Benennung_Registry registry = modding.registry;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId == 0) {
		generiere(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	private void generiere (World world, Random rand, int x, int z) {
		generiereErz(registry.platin_ore, world, rand, x, z, 30, 6, 8);
		generiereErz(registry.chrom_ore, world, rand, x, z, 17, 14, 3);
	}
	
	public void generiereErz (Block block, World world, Random rand, int x, int z, int maxY, int maxAderlaenge, int anzahlAdern) {
		int differenzMinMaxY = maxY - 3;
		int aderlaenge = 1 + rand.nextInt(maxAderlaenge);
		for (int u =0; u < anzahlAdern; u++) {
			int positionX = x + rand.nextInt(16);
			int positionY = 3 + rand.nextInt(differenzMinMaxY);
			int positionZ = z + rand.nextInt(16);
			(new WorldGenMinable(block, aderlaenge)).generate(world, rand, positionX, positionY, positionZ);
		}
	}
	
}