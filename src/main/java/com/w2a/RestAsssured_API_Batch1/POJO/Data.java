package com.w2a.RestAsssured_API_Batch1.POJO;

public class Data {
	private Subscriptions subscriptions;

	private String default_source;

	private String object;

	private String invoice_prefix;

	private Sources sources;

	private String currency;

	private String discount;

	private String id;

	private String shipping;

	private String delinquent;

	private String business_vat_id;

	private String created;

	private String email;

	private String description;

	private String livemode;

	private String account_balance;

	private Metadata metadata;

	public Subscriptions getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Subscriptions subscriptions) {
		this.subscriptions = subscriptions;
	}

	public String getDefault_source() {
		return default_source;
	}

	public void setDefault_source(String default_source) {
		this.default_source = default_source;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getInvoice_prefix() {
		return invoice_prefix;
	}

	public void setInvoice_prefix(String invoice_prefix) {
		this.invoice_prefix = invoice_prefix;
	}

	public Sources getSources() {
		return sources;
	}

	public void setSources(Sources sources) {
		this.sources = sources;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShipping() {
		return shipping;
	}

	{
		this.shipping = shipping;
	}

	public String getDelinquent() {
		return delinquent;
	}

	public void setDelinquent(String delinquent) {
		this.delinquent = delinquent;
	}

	public String getBusiness_vat_id() {
		return business_vat_id;
	}

	public void setBusiness_vat_id(String business_vat_id) {
		this.business_vat_id = business_vat_id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLivemode() {
		return livemode;
	}

	public void setLivemode(String livemode) {
		this.livemode = livemode;
	}

	public String getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(String account_balance) {
		this.account_balance = account_balance;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "ClassPojo [subscriptions = " + subscriptions + ", default_source = " + default_source + ", object = "
				+ object + ", invoice_prefix = " + invoice_prefix + ", sources = " + sources + ", currency = "
				+ currency + ", discount = " + discount + ", id = " + id + ", shipping = " + shipping
				+ ", delinquent = " + delinquent + ", business_vat_id = " + business_vat_id + ", created = " + created
				+ ", email = " + email + ", description = " + description + ", livemode = " + livemode
				+ ", account_balance = " + account_balance + ", metadata = " + metadata + "]";
	}
}
