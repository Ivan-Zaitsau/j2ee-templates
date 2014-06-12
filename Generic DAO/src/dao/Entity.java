package dao;

import java.io.Serializable;

/**
 * 
 * @author Ivan Zaitsau
 */
public interface Entity<PK extends Serializable> {
	PK getId();
}
