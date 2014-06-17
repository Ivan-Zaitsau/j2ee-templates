package dao;

import java.io.Serializable;

/**
 * Root interface for all entities stored in database.<br>
 * Can be considered to be a stub.
 * (It needs to be moved to separate project where all other entities reside)
 * 
 * @author Ivan Zaitsau
 */
public interface Entity<PK extends Serializable> {
	PK getId();
}
