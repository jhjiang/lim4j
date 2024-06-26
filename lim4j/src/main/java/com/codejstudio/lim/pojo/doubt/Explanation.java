package com.codejstudio.lim.pojo.doubt;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.common.util.CollectionUtil;
import com.codejstudio.lim.common.util.StringUtil;
import com.codejstudio.lim.pojo.BaseElement;
import com.codejstudio.lim.pojo.GenericActionableElement;
import com.codejstudio.lim.pojo.GenericElement;
import com.codejstudio.lim.pojo.InformationElement;
import com.codejstudio.lim.pojo.i.IConvertible;
import com.codejstudio.lim.pojo.util.ElementTrace;
import com.codejstudio.lim.pojo.util.JAXBBoundClassConstant;
import com.codejstudio.lim.pojo.util.PojoElementClassConstant;

/**
 * Explanation.class
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     
 * @since   lim4j_v1.0.0
 */
@XmlRootElement(name = Explanation.TYPE_NAME)
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {
	"baseTargetDoubt",
	"baseResponse",
})
public class Explanation extends InformationElement {

	/* constants */

	private static final long serialVersionUID = 3231010594621310429L;

	public static final String TYPE_NAME = "explanation";


	/* variables */

	@XmlElement(name = "target-doubt")
	protected BaseElement baseTargetDoubt;

	protected Doubt targetDoubt;

	@XmlElement(name = "response")
	protected BaseElement baseResponse;

	protected GenericElement response;


	/* variables: arrays, collections, maps, groups */

	private static final Collection<Class<? extends BaseElement>> SUB_POJO_CLAZZ_COLLECTION;


	/* constructors */

	/**
	 * only for JAXB auto unmarshalling usage
	 */
	public Explanation() {
		super();
	}

	public Explanation(Explanation explanation) throws LIMException {
		super(explanation);
		load(explanation);
	}

	public Explanation(boolean initIdFlag, boolean initTypeFlag) throws LIMException {
		super(initIdFlag, initTypeFlag);
	}

	public Explanation(boolean initIdFlag, boolean initTypeFlag, String description) throws LIMException {
		super(initIdFlag, initTypeFlag, description);
	}

	public Explanation(boolean initIdFlag, boolean initTypeFlag, Doubt targetDoubt) throws LIMException {
		super(initIdFlag, initTypeFlag);
		setTargetDoubt(targetDoubt);
	}

	public Explanation(boolean initIdFlag, boolean initTypeFlag, Doubt targetDoubt, 
			GenericElement response) throws LIMException {
		super(initIdFlag, initTypeFlag);
		setTargetDoubt(targetDoubt);
		setResponse(response);
	}


	public Explanation(Doubt targetDoubt) throws LIMException {
		this(true, false, targetDoubt);
	}

	public Explanation(Doubt targetDoubt, GenericElement response) throws LIMException {
		this(true, false, targetDoubt, response);
	}


	/* initializers */

	/**
	 * only for com.codejstudio.lim.common.util.InitializationUtil#autoInit() usage
	 */
	static void autoInit() {}

	static {
		try {
			SUB_POJO_CLAZZ_COLLECTION = CollectionUtil.generateNewCollection();

			PojoElementClassConstant.registerElementClassForInit(Explanation.class);
			JAXBBoundClassConstant.registerBoundClassForInit(Explanation.class);
			Explanation.registerSubPojoClassForInit(Explanation.class);
		} catch (LIMException e) {
			throw new RuntimeException(e);
		}
	}


	/* getters & setters */

	@XmlTransient
	public BaseElement getBaseTargetDoubt() {
		return baseTargetDoubt;
	}

	public void setBaseTargetDoubt(BaseElement baseTargetDoubt) {
		this.baseTargetDoubt = baseTargetDoubt;
	}

	@XmlTransient
	public Doubt getTargetDoubt() {
		return targetDoubt;
	}

	public boolean setTargetDoubt(final Doubt targetDoubt) throws LIMException {
		if (Objects.equals(this.targetDoubt, targetDoubt)) {
			return true;
		}

		boolean flag = true;
		if (this.targetDoubt != null) {
			this.baseTargetDoubt = null;
			flag &= this.targetDoubt.removeExplanation(this) 
					& super.removeInnerElementDelegate(this.targetDoubt);
			this.targetDoubt = null;
		}
		if (targetDoubt != null) {
			this.targetDoubt = targetDoubt;
			flag &= super.addInnerElementDelegate(targetDoubt) 
					& this.targetDoubt.addExplanation(this);
			this.baseTargetDoubt = new BaseElement(targetDoubt);
		}

		if (flag) {
			ElementTrace.log.info(this.toBaseString() + ": setTargetDoubt(" 
					+ ((targetDoubt == null) ? null : targetDoubt.toBaseString()) + ")");
		} else {
			ElementTrace.log.warn(this.toBaseString() + "fail to setTargetDoubt(" 
					+ ((targetDoubt == null) ? null : targetDoubt.toBaseString()) + ")");
		}
		return flag;
	}


	@XmlTransient
	public BaseElement getBaseResponse() {
		return baseResponse;
	}

	public void setBaseResponse(BaseElement baseResponse) {
		this.baseResponse = baseResponse;
	}

	@XmlTransient
	public GenericElement getResponse() {
		return response;
	}

	public boolean setResponse(final GenericElement response) throws LIMException {
		if (Objects.equals(this.response, response)) {
			return true;
		}

		boolean flag = true;
		if (this.response != null) {
			this.baseResponse = null;
			flag &= super.removeInnerElementDelegate(this.response);
			this.response = null;
		}
		if (response != null) {
			this.response = response;
			flag &= super.addInnerElementDelegate(response);
			this.baseResponse = new BaseElement(response);
		}

		if (flag) {
			ElementTrace.log.info(this.toBaseString() + ": setResponse(" 
					+ ((response == null) ? null : response.toBaseString()) + ")");
		} else {
			ElementTrace.log.warn(this.toBaseString() + "fail to setResponse(" 
					+ ((response == null) ? null : response.toBaseString()) + ")");
		}
		return flag;
	}


	/* overridden methods */

	@Override
	public IConvertible getXmlElement() throws LIMException {
		if (this.xmlElement == null) {
			this.xmlElement = this.getClass().equals(Explanation.class) ? this : new Explanation(this);
		}
		return this.xmlElement;
	}

	@Override
	public IConvertible getPojoElement(final Map<String, GenericElement> rootElementMap, 
			final Map<String, GenericActionableElement> rootActionableElementMap) throws LIMException {
		if (this.pojoElement == null) {
			this.pojoElement = (StringUtil.isEmpty(this.getType()) 
							|| !this.getClass().equals(Explanation.class)) 
					? this : super.generatePojoElementDelegate();
		}
		this.pojoElement.reload(this, rootElementMap, rootActionableElementMap);
		return this.pojoElement;
	}


	@Override
	public IConvertible reload(final IConvertible convertible, 
			final Map<String, GenericElement> rootElementMap, 
			final Map<String, GenericActionableElement> rootActionableElementMap) throws LIMException {
		if (!(convertible instanceof Explanation) 
				|| super.reload(convertible, rootElementMap, rootActionableElementMap) == null) {
			return null;
		}
		load((Explanation) convertible);
		reloadFromRootElementMap(rootElementMap);
		return (IConvertible) this;
	}

	private void load(final Explanation element) {
		if (element != null) {
			this.baseTargetDoubt = element.baseTargetDoubt;
			this.targetDoubt = element.targetDoubt;
			this.baseResponse = element.baseResponse;
			this.response = element.response;
		}
	}

	private void reloadFromRootElementMap(final Map<String, GenericElement> rootElementMap) 
			throws LIMException {
		if (CollectionUtil.checkNullOrEmpty(rootElementMap)) {
			return;
		}

		if (this.baseTargetDoubt != null && this.baseTargetDoubt.getId() != null) {
			GenericElement ge = rootElementMap.get(this.baseTargetDoubt.getId());
			this.targetDoubt = (ge instanceof Doubt) ? (Doubt) ge : this.targetDoubt;
			super.addInnerElementDelegate(this.targetDoubt);
		}
		if (this.baseResponse != null && this.baseResponse.getId() != null) {
			GenericElement ge = rootElementMap.get(this.baseResponse.getId());
			this.response = (ge != null) ? ge : this.response;
			super.addInnerElementDelegate(this.response);
		}
	}


	@Override
	public Explanation cloneElement(final Map<String, BaseElement> clonedElementMap) throws LIMException {
		if (!CollectionUtil.checkNullOrEmpty(clonedElementMap) && this.id != null) {
			if (clonedElementMap.containsKey(this.id)) {
				BaseElement value = clonedElementMap.get(this.id);
				String type;
				if (value != null && value.getClass().equals(Explanation.class) 
						&& ((type = value.getType()) == null || type.equals(TYPE_NAME))) {
					return (Explanation) value;
				}
			} else {
				clonedElementMap.put(this.id, new BaseElement(this.id, this.type));
			}
		}

		Explanation clonedElement = (Explanation) super.cloneElement(clonedElementMap);
		return cloneToElement(clonedElement, clonedElementMap);
	}

	@Override
	public Explanation cloneToElement(final GenericElement clonedElement) throws LIMException {
		GenericElement ce;
		return (!(clonedElement instanceof Explanation) 
						|| !((ce = super.cloneToElement(clonedElement)) instanceof Explanation)) 
				? null : cloneToElement((Explanation) ce, null);
	}

	private Explanation cloneToElement(final Explanation clonedElement, 
			final Map<String, BaseElement> clonedElementMap) throws LIMException {
		clonedElement.baseTargetDoubt = (this.baseTargetDoubt != null) 
				? (BaseElement) this.baseTargetDoubt.cloneElement(clonedElementMap) 
				: clonedElement.baseTargetDoubt;
		clonedElement.targetDoubt = (this.targetDoubt != null) 
				? this.targetDoubt.cloneElement(clonedElementMap) : clonedElement.targetDoubt;

		clonedElement.baseResponse = (this.baseResponse != null) 
				? (BaseElement) this.baseResponse.cloneElement(clonedElementMap) 
				: clonedElement.baseResponse;
		clonedElement.response = (this.response != null) 
				? this.response.cloneElement(clonedElementMap) : clonedElement.response;

		return clonedElement;
	}


	/* static methods */

	protected static void registerSubPojoClassForInit(final Class<? extends BaseElement> clazz) {
		if (Explanation.class.isAssignableFrom(clazz)) {
			SUB_POJO_CLAZZ_COLLECTION.add(clazz);
		}
	}

}
