package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import org.bukkit.Sound;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseBlaze extends DisguiseMonster {
	
	public DisguiseBlaze(){
		super();
		
		dataTypes.put(12, BYTE);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Blaze){
			Blaze b = (Blaze) e;
			setOnFire(b.getFireTicks() > 0);
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.BLAZE;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_BLAZE_AMBIENT;
	}
	
	public boolean isOnFire(){
		return getBitMask(12, 0x01);
	}
	
	public void setOnFire(boolean onFire){
		setBitMask(12, 0x01, onFire);
	}
}