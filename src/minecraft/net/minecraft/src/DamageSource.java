package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityDamageSource;
import net.minecraft.src.EntityDamageSourceIndirect;
import net.minecraft.src.EntityFireball;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;

public class DamageSource {

	public static DamageSource inFire = (new DamageSource("inFire")).func_40546_j();
	public static DamageSource onFire = (new DamageSource("onFire")).setDamageBypassesArmor().func_40546_j();
	public static DamageSource lava = (new DamageSource("lava")).func_40546_j();
	public static DamageSource inWall = (new DamageSource("inWall")).setDamageBypassesArmor();
	public static DamageSource drown = (new DamageSource("drown")).setDamageBypassesArmor();
	public static DamageSource starve = (new DamageSource("starve")).setDamageBypassesArmor();
	public static DamageSource cactus = new DamageSource("cactus");
	public static DamageSource fall = (new DamageSource("fall")).setDamageBypassesArmor();
	public static DamageSource outOfWorld = (new DamageSource("outOfWorld")).setDamageBypassesArmor().setDamageAllowedInCreativeMode();
	public static DamageSource generic = (new DamageSource("generic")).setDamageBypassesArmor();
	public static DamageSource explosion = new DamageSource("explosion");
	public static DamageSource magic = (new DamageSource("magic")).setDamageBypassesArmor();
	private boolean isBlockable = false;
	private boolean isDamageAllowedInCreativeMode = false;
	private float hungerDamage = 0.3F;
	private boolean field_40549_q;
	private boolean field_40548_r;
	public String damageType;


	public static DamageSource causeMobDamage(EntityLiving var0) {
		return new EntityDamageSource("mob", var0);
	}

	public static DamageSource causePlayerDamage(EntityPlayer var0) {
		return new EntityDamageSource("player", var0);
	}

	public static DamageSource causeArrowDamage(EntityArrow var0, Entity var1) {
		return (new EntityDamageSourceIndirect("arrow", var0, var1)).func_40544_c();
	}

	public static DamageSource causeFireballDamage(EntityFireball var0, Entity var1) {
		return (new EntityDamageSourceIndirect("fireball", var0, var1)).func_40546_j().func_40544_c();
	}

	public static DamageSource causeThrownDamage(Entity var0, Entity var1) {
		return (new EntityDamageSourceIndirect("thrown", var0, var1)).func_40544_c();
	}

	public static DamageSource func_40542_b(Entity var0, Entity var1) {
		return (new EntityDamageSourceIndirect("indirectMagic", var0, var1)).setDamageBypassesArmor();
	}

	public boolean func_40547_b() {
		return this.field_40548_r;
	}

	public DamageSource func_40544_c() {
		this.field_40548_r = true;
		return this;
	}

	public boolean unblockable() {
		return this.isBlockable;
	}

	public float getHungerDamage() {
		return this.hungerDamage;
	}

	public boolean canHarmInCreative() {
		return this.isDamageAllowedInCreativeMode;
	}

	protected DamageSource(String var1) {
		this.damageType = var1;
	}

	public Entity getSourceOfDamage() {
		return this.getEntity();
	}

	public Entity getEntity() {
		return null;
	}

	protected DamageSource setDamageBypassesArmor() {
		this.isBlockable = true;
		this.hungerDamage = 0.0F;
		return this;
	}

	protected DamageSource setDamageAllowedInCreativeMode() {
		this.isDamageAllowedInCreativeMode = true;
		return this;
	}

	protected DamageSource func_40546_j() {
		this.field_40549_q = true;
		return this;
	}

	public boolean func_40543_k() {
		return this.field_40549_q;
	}

	public String func_40545_l() {
		return this.damageType;
	}

}
