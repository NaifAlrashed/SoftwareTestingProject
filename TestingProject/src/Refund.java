
public class Refund extends DailyTransaction {
	private String buyerUserName;
	private String sellerUserName;
	private String refundCredit;
	
	public Refund (String transactionCode, String buyerUserName, String sellerUserName, String refundCredit) {
		super(transactionCode);
		setBuyerUserName(buyerUserName);
		setSellerUserName(sellerUserName);
		setRefundCredit(refundCredit);
	}
	/**
	 * @return the buyerUserName
	 */
	public String getBuyerUserName() {
		return buyerUserName;
	}
	/**
	 * @param buyerUserName the buyerUserName to set
	 */
	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}
	/**
	 * @return the sellerUserName
	 */
	public String getSellerUserName() {
		return sellerUserName;
	}
	/**
	 * @param sellerUserName the sellerUserName to set
	 */
	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}
	/**
	 * @return the refundCredit
	 */
	public String getRefundCredit() {
		return refundCredit;
	}
	/**
	 * @param refundCredit the refundCredit to set
	 */
	public void setRefundCredit(String refundCredit) {
		this.refundCredit = refundCredit;
	}
}
