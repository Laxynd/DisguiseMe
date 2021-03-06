package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

public class DisguiseVillager extends DisguiseAgeable {
	
	public static final int FARMER = 0;
	public static final int LIBRARIAN = 1;
	public static final int PRIEST = 2;
	public static final int BLACKSMITH = 3;
	public static final int BUTCHER = 4;
	public static final int NITWIT = 5;
	
	public DisguiseVillager(){
		super();
		
		dataTypes.put(13, VARINT);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Villager){
			Villager v = (Villager) e;
			setProfession(v.getProfession().ordinal());
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.VILLAGER;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_VILLAGER_AMBIENT;
	}
	
	public int getProfession(){
		return getInteger(13);
	}
	
	public void setProfession(int profession){
		set(13, profession);
	}
}