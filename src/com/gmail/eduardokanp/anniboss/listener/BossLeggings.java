package com.gmail.eduardokanp.anniboss.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BossLeggings implements Listener {
	
	ItemStack leggings = com.gmail.eduardokanp.anniboss.Main.leggings();
	
	@EventHandler
	public void speedOnHit(EntityDamageByEntityEvent e) {
		if(e.getDamager().getType() == EntityType.PLAYER) {
			Player p = (Player) e.getDamager();
			if(p.getInventory().getLeggings().equals(leggings)) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120, 1));
			}
		}
	}
}
