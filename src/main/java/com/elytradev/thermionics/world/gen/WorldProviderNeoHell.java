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
package com.elytradev.thermionics.world.gen;

import com.elytradev.thermionics.world.gen.biome.BiomeProviderNeo;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderNeoHell extends WorldProviderHell {

	public WorldProviderNeoHell() {
	}
	
	/**
	 * Up in WorldProvider, this sets a skylight and builds the BiomeProvider
	 */
	public void init() {
		this.hasSkyLight = false;
		this.doesWaterVaporize = true;
		
		this.biomeProvider = new BiomeProviderNeo(this.world.getWorldInfo());
	}
	
	
	@Override
	public DimensionType getDimensionType() { 
		return DimensionType.getById(-1);
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float x, float z) {
		return new Vec3d(0.4, 0.03, 0.1);
	}

	@Override
	protected void generateLightBrightnessTable() {
		float f = 0.1F;

		for (int i = 0; i <= 15; ++i) {
			float scale = 1.0F - i / 15.0F;
			lightBrightnessTable[i] = (1.0F - scale) / (scale * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderNeo(this.world, this.world.getSeed());
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	@Override
	public boolean canCoordinateBeSpawn(int x, int z) {
		return false;
	}

	@Override
	public float calculateCelestialAngle(long globalTicks, float worldTicks) {
		return 0.5F;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	/**
	 * Returns true if the given X,Z coordinate should show environmental fog.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		//return false;
		return true;
	}

	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
	
	@Override
	public int getActualHeight() {
        return 256;
    }
	
	@Override
	public double getMovementFactor() {
		return 4.0;
	}
	
	public String getDepartMessage(){
		return "Error: Could not leave world_nether. Returned to overworld";
    }
	
	public String getWelcomeMessage(){
		return "Error: Could not teleport to world_nether. Returned to world_neo_hell.";
	}
	
	@Override
	public Biome getBiomeForCoords(BlockPos pos) {
		return this.biomeProvider.getBiome(pos);
	}
}
