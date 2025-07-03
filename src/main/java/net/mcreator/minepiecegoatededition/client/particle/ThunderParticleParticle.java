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
public class ThunderParticleParticle extends SpriteTexturedParticle {
	public static ThunderParticleIParticleFactory factory(IAnimatedSprite spriteSet) {
		return new ThunderParticleIParticleFactory(spriteSet);
	}

	@OnlyIn(Dist.CLIENT)
	public static class ThunderParticleIParticleFactory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public ThunderParticleIParticleFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new ThunderParticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final IAnimatedSprite spriteSet;
	private float angularVelocity;
	private float angularAcceleration;

	protected ThunderParticleParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.maxAge = 6;
		this.particleGravity = 0f;
		this.canCollide = true;
		this.motionX = vx * 1;
		this.motionY = vy * 1;
		this.motionZ = vz * 1;
		this.angularVelocity = 0.1f;
		this.angularAcceleration = 0f;
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
			this.setSprite(this.spriteSet.get((this.age / 1) % 6 + 1, 6));
		}
	}
}
