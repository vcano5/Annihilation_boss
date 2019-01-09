package com.gmail.eduardokanp.anniboss.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

public class BossBoots implements Listener{
	
	ItemStack boots = com.gmail.eduardokanp.anniboss.Main.boots();
	
	@EventHandler
	public void cancelFallDamage(EntityDamageEvent event)
	{
		if(event.getEntity().getType() == EntityType.PLAYER && event.getCause() == DamageCause.FALL)
		{
			Player p = (Player)event.getEntity();
			if(p.getInventory().getBoots().equals(boots))
			{
				event.setCancelled(true);
			}
		}
	}  
}
