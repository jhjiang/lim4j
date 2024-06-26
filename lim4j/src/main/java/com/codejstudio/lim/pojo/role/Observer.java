package com.codejstudio.lim.pojo.role;

import java.util.Collection;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.OwnableInformationElement;
import com.codejstudio.lim.pojo.comment.Comment;
import com.codejstudio.lim.pojo.entity.Entity;
import com.codejstudio.lim.pojo.util.PojoElementClassConstant;

/**
 * Observer.class
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     
 * @since   lim4j_v1.0.0
 */
public class Observer extends BaseRole {

	/* constants */

	private static final long serialVersionUID = 2342010156632805379L;


	/* constructors */

	/**
	 * only for JAXB auto unmarshalling usage
	 */
	public Observer() {
		super();
	}

	public Observer(boolean initIdFlag, boolean initTypeFlag) throws LIMException {
		super(initIdFlag, initTypeFlag);
	}

	public Observer(boolean initIdFlag, boolean initTypeFlag, Entity entity) throws LIMException {
		super(initIdFlag, initTypeFlag, entity);
	}

	public Observer(boolean initIdFlag, boolean initTypeFlag, Entity entity, Comment... comments) 
			throws LIMException {
		super(initIdFlag, initTypeFlag, entity, comments);
	}


	public Observer(Entity entity) throws LIMException {
		super(true, true, entity);
	}

	public Observer(Entity entity, Comment... comments) throws LIMException {
		super(true, true, entity, comments);
	}


	/* initializers */

	/**
	 * only for com.codejstudio.lim.common.util.InitializationUtil#autoInit() usage
	 */
	static void autoInit() {}

	static {
		PojoElementClassConstant.registerElementClassForInit(Observer.class);
		BaseRole.registerSubPojoClassForInit(Observer.class);
	}


	/* CRUD for arrays, collections, maps, groups: observed elements */

	public boolean containObservedElement(final OwnableInformationElement element) {
		return (this.entity == null) ? false : this.entity.containObservedElement(element);
	}

	public boolean addObservedElement(final OwnableInformationElement... elements) throws LIMException {
		return (this.entity == null) ? false : this.entity.addObservedElement(elements);
	}

	public boolean addObservedElement(final Collection<OwnableInformationElement> elementCollection) 
			throws LIMException {
		return (this.entity == null) ? false : this.entity.addObservedElement(elementCollection);
	}

	public boolean removeObservedElement(final OwnableInformationElement... elements) throws LIMException {
		return (this.entity == null) ? false : this.entity.removeObservedElement(elements);
	}

	public boolean removeObservedElement(final Collection<OwnableInformationElement> elementCollection) 
			throws LIMException {
		return (this.entity == null) ? false : this.entity.removeObservedElement(elementCollection);
	}

}
