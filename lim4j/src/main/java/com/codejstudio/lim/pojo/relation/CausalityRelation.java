package com.codejstudio.lim.pojo.relation;

import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.common.util.CollectionUtil;
import com.codejstudio.lim.pojo.AbstractRelationableInformationElement;
import com.codejstudio.lim.pojo.BaseElement;
import com.codejstudio.lim.pojo.GenericActionableElement;
import com.codejstudio.lim.pojo.GenericElement;
import com.codejstudio.lim.pojo.i.IConvertible;
import com.codejstudio.lim.pojo.util.ElementTrace;
import com.codejstudio.lim.pojo.util.PojoElementClassConstant;

/**
 * CausalityRelation.class
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     
 * @since   lim4j_v1.0.0
 */
public class CausalityRelation extends BaseRelation {

	/* constants */

	private static final long serialVersionUID = 842198428412975651L;

	public static final String CAUSE = "cause";
	public static final String EFFECT = "effect";


	/* constructors */

	/**
	 * only for JAXB auto unmarshalling usage
	 */
	public CausalityRelation() {
		super();
	}

	public CausalityRelation(boolean initIdFlag) throws LIMException {
		super(initIdFlag, true);
	}

	public CausalityRelation(boolean initIdFlag, AbstractRelationableInformationElement cause, 
			AbstractRelationableInformationElement effect) throws LIMException {
		super(initIdFlag, true);
		setCause(cause);
		setEffect(effect);
	}


	public CausalityRelation(AbstractRelationableInformationElement cause, 
			AbstractRelationableInformationElement effect) throws LIMException {
		this(true, cause, effect);
	}


	/* initializers */

	/**
	 * only for com.codejstudio.lim.common.util.InitializationUtil#autoInit() usage
	 */
	static void autoInit() {}

	static {
		PojoElementClassConstant.registerElementClassForInit(CausalityRelation.class);
		BaseRelation.registerSubPojoClassForInit(CausalityRelation.class);
	}


	/* getters & setters */

	@Override
	public BaseElement getBasePrimaryElement() {
		return super.getIntegratedElementDelegate(CAUSE);
	}

	@Override
	@XmlTransient
	public AbstractRelationableInformationElement getPrimaryElement() {
		return getCause();
	}


	public AbstractRelationableInformationElement getCause() {
		return super.primaryElement;
	}

	public boolean setCause(final AbstractRelationableInformationElement cause) throws LIMException {
		boolean flag = true;
		if (super.primaryElement != null) {
			flag &= super.removeIntegratedElementDelegate(CAUSE);
		}
		if (cause != null) {
			flag &= super.putIntegratedElementDelegate(CAUSE, new BaseElement(cause));
		}
		flag &= super.setPrimaryElement(cause, false);

		if (flag) {
			ElementTrace.log.info(this.toBaseString() + ": setCause(" 
					+ ((cause == null) ? null : cause.toBaseString()) + ")");
		} else {
			ElementTrace.log.warn(this.toBaseString() + "fail to setCause(" 
					+ ((cause == null) ? null : cause.toBaseString()) + ")");
		}
		return flag;
	}


	@Override
	public BaseElement getBaseSecondaryElement() {
		return super.getIntegratedElementDelegate(EFFECT);
	}

	@Override
	@XmlTransient
	public AbstractRelationableInformationElement getSecondaryElement() {
		return getEffect();
	}


	public AbstractRelationableInformationElement getEffect() {
		return super.secondaryElement;
	}

	public boolean setEffect(final AbstractRelationableInformationElement effect) throws LIMException {
		boolean flag = true;
		if (super.secondaryElement != null) {
			flag &= super.removeIntegratedElementDelegate(EFFECT);
		}
		if (effect != null) {
			flag &= super.putIntegratedElementDelegate(EFFECT, new BaseElement(effect));
		}
		flag &= super.setSecondaryElement(effect, false);

		if (flag) {
			ElementTrace.log.info(this.toBaseString() + ": setEffect(" 
					+ ((effect == null) ? null : effect.toBaseString()) + ")");
		} else {
			ElementTrace.log.warn(this.toBaseString() + "fail to setEffect(" 
					+ ((effect == null) ? null : effect.toBaseString()) + ")");
		}
		return flag;
	}


	/* overridden methods */

	@Override
	public IConvertible reload(final IConvertible convertible, 
			final Map<String, GenericElement> rootElementMap, 
			final Map<String, GenericActionableElement> rootActionableElementMap) throws LIMException {
		if (super.reload(convertible, rootElementMap, rootActionableElementMap) == null) {
			return null;
		}
		reloadFromRootElementMap(rootElementMap);
		return (IConvertible) this;
	}

	private void reloadFromRootElementMap(final Map<String, GenericElement> rootElementMap) 
			throws LIMException {
		Map<String, BaseElement> item;
		if (CollectionUtil.checkNullOrEmpty(rootElementMap) 
				|| CollectionUtil.checkNullOrEmpty(item = super.getIntegratedElementMap())) {
			return;
		}

		BaseElement cause = item.get(CAUSE);
		if (cause != null && cause.getId() != null) {
			GenericElement ge = rootElementMap.get(cause.getId());
			this.primaryElement = (ge instanceof AbstractRelationableInformationElement) 
					? (AbstractRelationableInformationElement) ge : this.primaryElement;
			super.addInnerElementDelegate(this.primaryElement);
		}
		BaseElement effect = item.get(EFFECT);
		if (effect != null && effect.getId() != null) {
			GenericElement ge = rootElementMap.get(effect.getId());
			this.secondaryElement = (ge instanceof AbstractRelationableInformationElement) 
					? (AbstractRelationableInformationElement) ge : this.secondaryElement;
			super.addInnerElementDelegate(this.secondaryElement);
		}
	}

}
