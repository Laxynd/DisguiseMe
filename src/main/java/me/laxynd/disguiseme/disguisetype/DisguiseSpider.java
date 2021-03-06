package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Spider;

public class DisguiseSpider extends DisguiseMonster {
	
	public DisguiseSpider(){
		super();
		
		dataTypes.put(12, BYTE);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Spider){
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.SPIDER;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_SPIDER_AMBIENT;
	}
	
	public boolean isClimbing(){
		return getBitMask(12, 0x01);
	}
	
	public void setClimbing(boolean climbing){
		setBitMask(12, 0x01, climbing);
	}
}