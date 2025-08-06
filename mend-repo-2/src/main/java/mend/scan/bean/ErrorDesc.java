package aero.sita.bordermanagement.uae.gw.bean;

public class ErrorDesc implements IErrorDesc {

	/**
	 * Serialize ID
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	private String desc;
	
	private String descAr;

	/**
	 * @return the errorCode
	 */
	@Override
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(final String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the desc
	 */
	@Override
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(final String desc) {
		this.desc = desc;
	}

	/**
	 * @return the descAr
	 */
	public String getDescAr() {
		return descAr;
	}

	/**
	 * @param descAr the descAr to set
	 */
	public void setDescAr(final String descAr) {
		this.descAr = descAr;
	}
	

	
	
	

}
