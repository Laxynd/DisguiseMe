package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.SLOT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseItem extends Disguise {
	
	public DisguiseItem(){
		super();
		
		dataTypes.put(6, SLOT);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.DROPPED_ITEM;
	}
	
	@Override
	public Sound getSound(){
		return null;
	}

	@Override
	public void from(Entity e) {}
}