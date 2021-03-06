/**
 * MIT License
 *
 * Copyright (c) 2017 Isaac Ellingson (Falkreon) and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.elytradev.thermionics.world.gen.biome;

import com.elytradev.thermionics.world.block.TWBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiomeRegistry extends RegistryNamespaced<String, NeoBiome> {
	public static BiomeRegistry NEO_HELL = new BiomeRegistry();
	
	public void init() {
		NEO_HELL.register(0,
			new NeoBiome("bridges", new Biome.BiomeProperties("bridges")
				.setBaseHeight(128f)
				.setTemperature(0.25f)
				.setRainfall(0.25f)
			)
			.withSurfaceMaterial(Blocks.NETHERRACK)
			.withTerrainFillMaterial(Blocks.NETHERRACK)
			.withDensitySurfaceMaterial(Blocks.NETHERRACK)
			.withDensityCoreMaterial(Blocks.SOUL_SAND)
			.withTypes(BiomeDictionary.Type.NETHER)
			);
		
		NEO_HELL.register(1,
			new NeoBiome("strata", new Biome.BiomeProperties("strata")
				.setBaseHeight(128f)
				.setTemperature(0.375f)
				.setRainfall(0.25f)
			)
			.withSurfaceMaterial(TWBlocks.GEMROCK_PYRITE)
			.withTerrainFillMaterial(TWBlocks.GEMROCK_ROSE_QUARTZ)
			.withDensitySurfaceMaterial(TWBlocks.GEMROCK_PYRITE)
			.withDensityCoreMaterial(Blocks.NETHERRACK)
			.withWorldGenerator(new GeneratorNorfairiteBush())
			.withTypes(BiomeDictionary.Type.NETHER)
			);
		
		NEO_HELL.register(2,
			new NeoBiome("cold", new Biome.BiomeProperties("cold")
				.setBaseHeight(128f)
				.setTemperature(0.625f)
				.setRainfall(0.25f)
			)
			.withSurfaceMaterial(TWBlocks.GEMROCK_MAGNESITE)
			.withTerrainFillMaterial(TWBlocks.GEMROCK_SAPPHIRE)
			.withDensitySurfaceMaterial(TWBlocks.GEMROCK_OPAL)
			.withDensityCoreMaterial(Blocks.PACKED_ICE)
			.withTypes(BiomeDictionary.Type.NETHER, BiomeDictionary.Type.COLD)
			);
		
		NEO_HELL.register(3,
			new NeoBiome("barad_dur", new Biome.BiomeProperties("barad_dur")
				.setBaseHeight(128f)
				.setTemperature(0.75f)
				.setRainfall(0.25f)
			)
			.withSurfaceMaterial(TWBlocks.GEMROCK_HEMATITE)
			.withTerrainFillMaterial(Blocks.NETHERRACK)
			.withDensitySurfaceMaterial(TWBlocks.GEMROCK_HEMATITE)
			.withDensityCoreMaterial(Blocks.NETHERRACK)
			.withTypes(BiomeDictionary.Type.NETHER)
			);
		
		NEO_HELL.register(4,
			new NeoBiome("heartsblood", new Biome.BiomeProperties("heartsblood")
				.setBaseHeight(128f)
				.setTemperature(0.25f)
				.setRainfall(0.5f)
			)
			.withSurfaceMaterial(TWBlocks.GEMROCK_GARNET)
			.withTerrainFillMaterial(TWBlocks.GEMROCK_TOURMALINE)
			.withDensitySurfaceMaterial(TWBlocks.GEMROCK_GARNET)
			.withDensityCoreMaterial(TWBlocks.GEMROCK_EMERALD)
			.withWorldGenerator(new GeneratorBoneTree())
			.withWorldGenerator(new GeneratorBoneShrub())
			.withTypes(BiomeDictionary.Type.NETHER, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET)
			);

		NEO_HELL.register(5,
			new NeoBiome("sulfur", new Biome.BiomeProperties("sulfur")
				.setBaseHeight(128f)
				.setTemperature(0.375f)
				.setRainfall(0.5f)
			)
			.withSurfaceMaterial(TWBlocks.GEMROCK_HELIODOR)
			.withTerrainFillMaterial(TWBlocks.GEMROCK_PERIDOT)
			.withDensitySurfaceMaterial(TWBlocks.GEMROCK_HELIODOR)
			.withDensityCoreMaterial(TWBlocks.GEMROCK_PERIDOT)
			.withWorldGenerator(new GeneratorSulfurVent())
			.withTypes(BiomeDictionary.Type.NETHER)
			);
		
		NEO_HELL.register(6,
			new NeoBiome("nocturne", new Biome.BiomeProperties("nocturne")
				.setBaseHeight(128f)
				.setTemperature(0.625f)
				.setRainfall(0.5f)
			)
			.withSurfaceMaterial(TWBlocks.GEMROCK_CASSITERITE)
			.withTerrainFillMaterial(TWBlocks.GEMROCK_CHRYSOPRASE)
			.withDensitySurfaceMaterial(TWBlocks.GEMROCK_CASSITERITE)
			.withDensityCoreMaterial(TWBlocks.GEMROCK_CASSITERITE)
			.withWorldGenerator(new GeneratorMagmaSpike())
			.withTypes(BiomeDictionary.Type.NETHER, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SPOOKY)
			);
		
		NEO_HELL.register(7,
			new NeoBiome("doom", new Biome.BiomeProperties("doom")
				.setBaseHeight(128f)
				.setTemperature(0.75f)
				.setRainfall(0.5f)
			)
			.withSurfaceMaterial(TWBlocks.GEMROCK_SPINEL)
			.withTerrainFillMaterial(TWBlocks.GEMROCK_PYRITE)
			.withDensitySurfaceMaterial(TWBlocks.GEMROCK_SPINEL)
			.withDensityCoreMaterial(TWBlocks.GEMROCK_CASSITERITE)
			.withTypes(BiomeDictionary.Type.NETHER, BiomeDictionary.Type.DRY)
			);
	}
	
	public void register(int id, NeoBiome biome) {
		this.register(id, biome.name(), biome);
	}
	
	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		NEO_HELL.registryObjects.values().forEach((it)->{
			System.out.println("Registering "+it.getRegistryName());
			event.getRegistry().register(it);
			for(BiomeDictionary.Type type : it.getTypes()) {
				BiomeDictionary.addTypes(it, type);
			}
		});
	}
}
