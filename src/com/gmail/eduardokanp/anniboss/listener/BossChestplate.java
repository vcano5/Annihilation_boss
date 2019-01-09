package com.gmail.eduardokanp.anniboss.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BossChestplate  implements Listener{

	static ItemStack chestplate = com.gmail.eduardokanp.anniboss.Main.chestplate();
	
	@EventHandler
	public void regenerationOnHit(EntityDamageByEntityEvent e) {
		if(e.getDamager().getType() == EntityType.PLAYER) {
			if(e.getEntity().getType() == EntityType.PLAYER) {
				Player p = (Player) e.getEntity();
				if(p.getInventory().getChestplate().equals(chestplate)) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 1));
				}
			}
		}
		
	}
}
