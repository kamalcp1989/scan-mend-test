package aero.sita.bordermanagement.uae.gw.bean;

public class StatusCodeDesc implements IStatusCodeDesc {
	
	/**
	 * Serial Id
	 */
	private static final long serialVersionUID = 1L;

	private String messageCode;
	
	private String desc;
	
	private String descAr;
	
	private String paxStatusCode;

	/**
	 * @return the messageCode
	 */
	@Override
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * @param messageCode the messageCode to set
	 */
	public void setMessageCode(final String messageCode) {
		this.messageCode = messageCode;
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
	@Override
	public String getDescAr() {
		return descAr;
	}

	/**
	 * @param descAr the descAr to set
	 */
	public void setDescAr(final String descAr) {
		this.descAr = descAr;
	}

	/**
	 * @return the paxStatusCode
	 */
	@Override
	public String getPaxStatusCode() {
		return paxStatusCode;
	}

	/**
	 * @param paxStatusCode the paxStatusCode to set
	 */
	public void setPaxStatusCode(final String paxStatusCode) {
		this.paxStatusCode = paxStatusCode;
	}

	

}
