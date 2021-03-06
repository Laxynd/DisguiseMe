package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

public class DisguiseSheep extends DisguiseAnimal {
	
	public DisguiseSheep(){
		super();
		
		dataTypes.put(13, BYTE);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Sheep){
			Sheep s = (Sheep) e;
			setColor((byte) s.getColor().ordinal());
			setSheared(s.isSheared());
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.SHEEP;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_SHEEP_AMBIENT;
	}
	
	public byte getColor(){
		return (byte) (getByte(13) & 0x0F);
	}
	
	public void setColor(byte color){
		set(16, (byte) ((getByte(13) & 0x10) + color));
	}
	
	public boolean isSheared(){
		return getBitMask(13, 0x10);
	}
	
	public void setSheared(boolean sheared){
		setBitMask(13, 0x10, sheared);
	}
}