package com.gmail.eduardokanp.anniboss.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

public class BossHelmet implements Listener{ 
	
	ItemStack helmet = com.gmail.eduardokanp.anniboss.Main.helmet();
	
	@EventHandler
	public void cancelFireDamage(EntityDamageEvent e) {
		if(e.getEntity().getType() == EntityType.PLAYER) {
			DamageCause dmc = e.getCause();
			Player p = (Player) e.getEntity();
			if(dmc == DamageCause.FIRE || dmc == DamageCause.LAVA || dmc == DamageCause.FIRE_TICK) {
				if(p.getInventory().getHelmet().equals(helmet)) {
					e.setCancelled(true);
				}
			}
		}
	}
}
