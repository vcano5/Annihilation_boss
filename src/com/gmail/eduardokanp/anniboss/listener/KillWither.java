package com.gmail.eduardokanp.anniboss.listener;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class KillWither implements Listener {
	
	ItemStack Star = com.gmail.eduardokanp.anniboss.Main.star();
	
	@EventHandler
	public void onWitherDeath(EntityDeathEvent e) {
		if(e.getEntity().getType() == EntityType.WITHER) {
			e.getDrops().clear();
			e.setDroppedExp(0);
			Location loc = e.getEntity().getLocation();
			e.getEntity().getWorld().dropItemNaturally(loc, Star);
			
			for (int i = 0; i < 50; i += 1) {
				for(Player p: Bukkit.getOnlinePlayers()) {
					Location lc2 = loc;
					String lc = "0." + i;
					Double lcd = Double.parseDouble(lc);
					lc2.add(lcd, 0, lcd);
					p.getWorld().spigot().playEffect(lc2, Effect.FLAME);
				}
			}
		}
	}
}