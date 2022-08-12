package com.enderzombi102.diversity.flora.registry;

import com.enderzombi102.diversity.flora.Flora;
import com.enderzombi102.diversity.flora.biome.CrystalForestBiome;
import com.hugman.dawn.api.creator.BiomeCreator;

public class BiomeRegistry {
	public static void register() {
		Flora.DATA.addCreator( new BiomeCreator( "crystal_forest", CrystalForestBiome.make() ) );
	}

	public static void registerClient() {

	}
}
