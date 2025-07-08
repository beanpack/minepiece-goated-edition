package net.mcreator.minepiecegoatededition.client.particle;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.particles.BasicParticleType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IAnimatedSprite;

@OnlyIn(Dist.CLIENT)
public class WaterParticleParticle extends SpriteTexturedParticle {
	public static WaterParticleIParticleFactory factory(IAnimatedSprite spriteSet) {
		return new WaterParticleIParticleFactory(spriteSet);
	}

	@OnlyIn(Dist.CLIENT)
	public static class WaterParticleIParticleFactory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public WaterParticleIParticleFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new WaterParticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final IAnimatedSprite spriteSet;
	private float angularVelocity;
	private float angularAcceleration;

	protected WaterParticleParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(3f, 3f);
		this.particleScale *= 1.4f;
		this.maxAge = 24;
		this.particleGravity = 0.2f;
		this.canCollide = true;
		this.motionX = vx * 0.1;
		this.motionY = vy * 0.1;
		this.motionZ = vz * 0.1;
		this.angularVelocity = -0.1f;
		this.angularAcceleration = 0.01f;
		this.selectSpriteWithAge(spriteSet);
	}

	@Override
	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Override
	public void tick() {
		super.tick();
		this.prevParticleAngle = this.particleAngle;
		this.particleAngle += this.angularVelocity;
		this.angularVelocity += this.angularAcceleration;
		if (!this.isExpired) {
			this.setSprite(this.spriteSet.get((this.age / 3) % 8 + 1, 8));
		}
	}
}
