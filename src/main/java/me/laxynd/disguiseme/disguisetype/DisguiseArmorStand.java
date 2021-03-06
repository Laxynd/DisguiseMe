package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import static me.laxynd.disguiseme.DataType.VECTOR3F;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.util.EulerAngle;

public class DisguiseArmorStand extends DisguiseLivingEntity {
	
	public DisguiseArmorStand(){
		super();
		
		dataTypes.put(11, BYTE);
		dataTypes.put(12, VECTOR3F);
		dataTypes.put(13, VECTOR3F);
		dataTypes.put(14, VECTOR3F);
		dataTypes.put(15, VECTOR3F);
		dataTypes.put(16, VECTOR3F);
		dataTypes.put(17, VECTOR3F);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.ARMOR_STAND;
	}
	
	@Override
	public Sound getSound(){
		return null;
	}
	
	@Override
	public void from(Entity e){
		if (e instanceof ArmorStand){
			ArmorStand as = (ArmorStand) e;
			setSmall(as.isSmall());
			setGravity(as.hasGravity());
			setArms(as.hasArms());
			setNoBasePlate(!as.hasBasePlate());
			setMarker(as.isMarker());
			setHeadRotation(as.getHeadPose());
			setBodyRotation(as.getBodyPose());
			setLeftArmRotation(as.getLeftArmPose());
			setRightArmRotation(as.getRightArmPose());
			setLeftLegRotation(as.getLeftLegPose());
			setRightLegRotation(as.getRightLegPose());
		} else throw new IllegalArgumentException();
	}
	
	public boolean isSmall(){
		return getBitMask(11, 0x01);
	}
	
	public void setSmall(boolean small){
		setBitMask(11, 0x01, small);
	}
	
	@Deprecated
	public boolean hasGravity(){
		return !hasNoGravity();
	}
	
	@Deprecated
	public void setGravity(boolean gravity){
		setNoGravity(!gravity);
	}
	
	public boolean hasArms(){
		return getBitMask(11, 0x04);
	}
	
	public void setArms(boolean arms){
		setBitMask(11, 0x04, arms);
	}
	
	public boolean hasNoBasePlate(){
		return getBitMask(11, 0x08);
	}
	
	public void setNoBasePlate(boolean noBasePlate){
		setBitMask(11, 0x08, noBasePlate);
	}
	
	public boolean isMarker(){
		return getBitMask(11, 0x10);
	}
	
	public void setMarker(boolean marker){
		setBitMask(11, 0x10, marker);
	}
	
	public float[] getHeadRotation(){
		return getVector3F(12);
	}
	
	public void setHeadRotation(float[] headRotation){
		set(12, headRotation);
	}
	
	public void setHeadRotation(EulerAngle angle){
		setHeadRotation(new float[]{(float) angle.getX(), (float) angle.getY(), (float) angle.getZ()});
	}
	
	public float[] getBodyRotation(){
		return getVector3F(13);
	}
	
	public void setBodyRotation(float[] bodyRotation){
		set(13, bodyRotation);
	}
	
	public void setBodyRotation(EulerAngle angle){
		setBodyRotation(new float[]{(float) angle.getX(), (float) angle.getY(), (float) angle.getZ()});
	}
	
	public float[] getLeftArmRotation(){
		return getVector3F(14);
	}
	
	public void setLeftArmRotation(float[] leftArmRotation){
		set(14, leftArmRotation);
	}
	
	public void setLeftArmRotation(EulerAngle angle){
		setLeftArmRotation(new float[]{(float) angle.getX(), (float) angle.getY(), (float) angle.getZ()});
	}
	
	public float[] getRightArmRotation(){
		return getVector3F(15);
	}
	
	public void setRightArmRotation(float[] rightArmRotation){
		set(15, rightArmRotation);
	}
	
	public void setRightArmRotation(EulerAngle angle){
		setRightArmRotation(new float[]{(float) angle.getX(), (float) angle.getY(), (float) angle.getZ()});
	}
	
	public float[] getLeftLegRotation(){
		return getVector3F(16);
	}
	
	public void setLeftLegRotation(float[] leftLegRotation){
		set(16, leftLegRotation);
	}
	
	public void setLeftLegRotation(EulerAngle angle){
		setLeftLegRotation(new float[]{(float) angle.getX(), (float) angle.getY(), (float) angle.getZ()});
	}
	
	public float[] getRightLegRotation(){
		return getVector3F(17);
	}
	
	public void setRightLegRotation(float[] rightLegRotation){
		set(17, rightLegRotation);
	}
	
	public void setRightLegRotation(EulerAngle angle){
		setRightLegRotation(new float[]{(float) angle.getX(), (float) angle.getY(), (float) angle.getZ()});
	}
}